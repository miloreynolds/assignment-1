package assignment1;
import java.io.PrintWriter;

public class VigenereCipher {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.err, true);
    if (args.length != 3) {
      pen.println("Incorrect number of parameters");
      System.exit(1);
    } else if (args[0].equals("encode")) {
      encode(args[1], args[2]);
    } else if (args[0].equals("decode")) {
      decode(args[1], args[2]);
    } else {
      pen.println("Valid options are \"encode\" or \"decode\"");
      System.exit(2);
    }
    pen.flush();
  }// main(String[])

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
