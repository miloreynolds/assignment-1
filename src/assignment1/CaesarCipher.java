package assignment1;
import java.io.PrintWriter;

public class CaesarCipher {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.err, true);
    if (args.length != 2) {
      pen.println("Incorrect number of parameters");
      System.exit(1);
    } else if (args[0].equals("encode")) {
      encode(args[1]);
    } else if (args[0].equals("decode")) {
      decode(args[1]);
    } else {
      pen.println("Valid options are \"encode\" or \"decode\"");
      System.exit(2);
    }
    pen.flush();
  } // main(String[])


  public static void encode(String message) {
    PrintWriter pen = new PrintWriter(System.out, true);
    int base = 97;
    int length = message.length();
    //Create character array to house encoded message
    char[] charArray = new char[length];
    //Encode message for keys 0<=n<26
    for (int n = 0; n < 25; n++) {
      //Loop through and encode each character
      for (int i = 0; i < length; i++) {
        //Rebase character so a=0
        int origNum = ((int) message.charAt(i)) - base;
        //Encode character and add to array
        int encNum = (origNum + n) % 26;
        charArray[i] = (char) (encNum + base);
      }
      String encoded = new String(charArray);
      //Print encoded message for each value of n
      pen.println("n = " + n + ": " + encoded);
      pen.flush();
    }
  }// encode (String)

  public static void decode(String message) {
    PrintWriter pen = new PrintWriter(System.out, true);
    int base = 97;
    int length = message.length();
    //Create character array to house decoded message
    char[] charArray = new char[length];
    //Decode message for each key 0<=n<26
    for (int n = 0; n < 25; n++) {
      //Decode each character
      for (int i = 0; i < length; i++) {
        //Rebase character so a=0
        int origNum = ((int) message.charAt(i)) - base;
        //Decode character and add to array
        int decNum = (origNum + 26 - n) % 26;
        charArray[i] = (char) (decNum + base);
      }
      String decoded = new String(charArray);
      //Print decoded message for each value of n
      pen.println("n = " + n + ": " + decoded);
      pen.flush();
    }
  }// decode (String)
  
}

/*
 * Citations: 
 * https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
 * https://stackoverflow.com/questions/21197737/what-is-the-point-of-system-err
 * 
 */
