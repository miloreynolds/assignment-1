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

  }

  public static void encode(String message, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (key.equals("")) {
      pen.println(message);
    } else {
      int base = 97;
      int length = message.length();

      char[] messArray = new char[length];
      String wholeKey = new String(createKey(key, length));


      for (int i = 0; i < length; i++) {
        int messNum = ((int) message.charAt(i)) - base;
        int keyNum = ((int) wholeKey.charAt(i)) - base;
        int encNum = (messNum + keyNum) % 26;
        messArray[i] = (char) (encNum + base);
      }
      String encoded = new String(messArray);
      pen.println(encoded);
    }
    pen.flush();
  }


  public static void decode(String message, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (key.equals("")) {
      pen.println(message);
    } else {
      int base = 97;
      int length = message.length();

      char[] messArray = new char[length];
      String wholeKey = new String(createKey(key, length));


      for (int i = 0; i < length; i++) {
        int messNum = ((int) message.charAt(i)) - base;
        int keyNum = ((int) wholeKey.charAt(i)) - base;
        int decNum = (messNum - keyNum + 26) % 26;
        messArray[i] = (char) (decNum + base);
      }
      String decoded = new String(messArray);
      pen.println(decoded);
    }
    pen.flush();
  }


  public static String createKey(String key, int length) {
    char[] wholeKeyword = new char[length];
    for (int o = 0; o < length; o++) {
      wholeKeyword[o] = key.charAt(o % key.length());

    }

    String wholeKey = new String(wholeKeyword);
    return wholeKey;

  }
}
