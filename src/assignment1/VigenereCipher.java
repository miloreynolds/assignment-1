package assignment1;
import java.io.PrintWriter;

/**
 * Encodes and decodes messages by using the Vigenere Cipher method
 *
 * @param args the strings typed on the command line 
 * @throws - error with code 1 if instruction is not "encode"
 *           or "decode" or if message/key has uppercase or whitespace
 *           characters
 *         - error with code 2 if there are not exactly 3 arguments
 */
public class VigenereCipher {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.err, true);
    String instruction = args[0];
    if (args.length != 3) {
      pen.println("Incorrect number of parameters");
      System.exit(2);
    } else if (instruction.equals("encode")) {
      checkMessage(args[1]);
      checkMessage(args[2]);
      encode(args[1], args[2]);
    } else if (instruction.equals("decode")) {
      checkMessage(args[1]);
      checkMessage(args[2]);
      decode(args[1], args[2]);
    } else {
      pen.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);
    }
    pen.flush();
  }// main(String[])

  /**
   * Checks if given string has uppercase or whitespace characters
   *
   * @param message the string to check for errors
   * @throws error with code 1 if message consists of whitespace,
   *         is not a letter, or is uppercase
   */
  public static void checkMessage(String message) {
    PrintWriter pen = new PrintWriter(System.err, true);
    // Check to see that there are no whitespace or uppercase
    for (int i = 0; i < message.length(); i++) {
      char character = message.charAt(i);
      //If invalid character encountered, print error message and exit
      if (!Character.isLetter(character) || Character.isWhitespace(character) 
          || Character.isUpperCase(character)) {
        pen.println("Messages must be only lowercase and without whitespace");
        System.exit(1);
      }
    }
  }// checkMessage(String)
  
  /**
   * Encodes the given message by shifting characters with keyword.
   *
   * @param - message the string to encode
   *        - key the keyword by which the message is shifted
   */
  public static void encode(String message, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);
    //If key is the empty string, return message as it is
    if (key.equals("")) {
      pen.println(message);
    } else {
      int base = 97;
      int length = message.length();
      //Create character array to store encoded message
      char[] messArray = new char[length];
      //Modify key to be length of the message
      String wholeKey = new String(createKey(key, length));
      //Loop through/decode each character in message
      for (int i = 0; i < length; i++) {
        //Rebase characters so a=0
        int messNum = ((int) message.charAt(i)) - base;
        int keyNum = ((int) wholeKey.charAt(i)) - base;
        //Encode character(and wrap around, if necessary)  
        int encNum = (messNum + keyNum) % 26;     
        //Insert into encoded message array
        messArray[i] = (char) (encNum + base);
      }
      String encoded = new String(messArray);
      pen.println(encoded);
    }
    pen.flush();
  }// encode(String, String)

  /**
   * Decodes the given message by shifting characters with keyword.
   *
   * @param - message the string to encode
   *        - key the keyword by which the message is shifted
   */
  public static void decode(String message, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);
  //If key is the empty string, return message as it is
    if (key.equals("")) {
      pen.println(message);
    } else {
      int base = 97;
      int length = message.length();      
      //Create character array to store decoded message
      char[] messArray = new char[length];
      //Modify key to be the length of the message
      String wholeKey = new String(createKey(key, length));      
      //Loop through/decode each character in message
      for (int i = 0; i < length; i++) {
        //Rebase characters so a=0
        int messNum = ((int) message.charAt(i)) - base;
        int keyNum = ((int) wholeKey.charAt(i)) - base;        
        //Decode character(and wrap around, if necessary) 
        int decNum = (messNum - keyNum + 26) % 26;
        messArray[i] = (char) (decNum + base);
      }
      String decoded = new String(messArray);
      pen.println(decoded);
    }
    pen.flush();
  }// decode (String, String)

  /**
   * Creates the full keyword by repeating the word until
   * it is the same length as the message.
   *
   * @param - key the string with which to create the keyword
   *        - length the length that the final keyword must be
   * @return the full keyword used to shift the messages
   */
  public static String createKey(String key, int length) {
    //Create array to house modified key
    char[] wholeKeyword = new char[length];    
    //Repeat keyword until specified length is reached
    for (int i = 0; i < length; i++) {
      wholeKeyword[i] = key.charAt(i % key.length());
    }
    String wholeKey = new String(wholeKeyword);
    return wholeKey;
  }// createKey (String, int)
}// class VigenereCipher
