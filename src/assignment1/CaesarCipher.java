package assignment1;


import java.io.PrintWriter;

public class CaesarCipher {
  public static void main (String[] args) throws Exception {
 
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      pen.println("Incorrect number of parameters");
      
    }
    else if (args[0].equals("encode")) {
      encode("Test");
    }
    else if (args[0].equals("decode")) {
      decode("Test");
    }
    else {
      pen.println("Valid options are \"encode\" or \"decode\"");
    }
    pen.flush();
  } // main(String[])

  
  public static void encode(String message) {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("Encoding");
    pen.flush();
  }
  
  public static void decode(String message) {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("Decoding");
    pen.flush();
  }
}

/*
Citations:
https://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java


*/