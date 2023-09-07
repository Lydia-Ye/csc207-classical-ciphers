import java.io.PrintWriter;

/**
 * The program encodes and decodes messages using Caesar cipher.
 *
 * @author Lydia Ye
 */

public class CaesarCipher {
  public static void main(String[] args) throws Exception{
    // Print error messages if input is invalid
    if (!(args[0].equals("encode")) && !(args[0].equals("decode"))){
      // invalid instruction
      System.err.println("Invalid input: the first parameter should be 'encode' or 'decode'");
      System.exit(1);
    } else if (args.length != 2) {
      //invalid number of command line arguments
      System.err.println("Invalid input: incorrect number of parameters");
      System.exit(2);
    } // if

    String instruction = args[0];
    String message = args[1];

    if (instruction.equals("encode")) {
      printResult(message);
    } 
    /* 
    else if (instruction.equals("decode")) {
      String result = decode(message);
    } // if
*/


  } // main(String[])

  public static String encode(String message, int n) {
    char[] ch = message.toCharArray();  // array of letters to be encrypt
    char[] encoded_ch = new char[message.length()];

    for (int i = 0; i < message.length(); i++){
      encoded_ch[i] = (char) ('a' + (ch[i] - 'a' + n) % 26);
    } // for

    String encodedMessage = new String(encoded_ch);

    return encodedMessage;

  } // encode

  public static void printResult(String message) {
    PrintWriter pen = new PrintWriter(System.out, true);
    int n = 0;    // value of key to encrypt/decrpt the letter with
    for (n = 0; n <= 25; n++) {
      pen.println("n = " + n + ": " + encode(message, n));
    } // for
    pen.flush();
  } // printResult;

} // class CaesarCipher



