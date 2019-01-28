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

    char[] charArray = new char[length];

    for (int n = 0; n < 25; n++) {
      for (int i = 0; i < length; i++) {
        int origNum = ((int) message.charAt(i)) - base;
        int encNum = (origNum + n) % 26;

        charArray[i] = (char) (encNum + base);
      }

      String encoded = new String(charArray);
      pen.println("n = " + n + ": " + encoded);
      pen.flush();
    }
  }

  public static void decode(String message) {
    PrintWriter pen = new PrintWriter(System.out, true);
    int base = 97;
    int length = message.length();

    char[] charArray = new char[length];

    for (int n = 0; n < 25; n++) {
      for (int i = 0; i < length; i++) {
        int origNum = ((int) message.charAt(i)) - base;
        
        int decNum = (origNum + 26 - n) % 26;

        charArray[i] = (char) (decNum + base);
      }

      String decoded = new String(charArray);
      pen.println("n = " + n + ": " + decoded);
      pen.flush();
    }
  }
}

/*
 * Citations: https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
 * https://stackoverflow.com/questions/21197737/what-is-the-point-of-system-err
 * 
 */
