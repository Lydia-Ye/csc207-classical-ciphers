import java.io.PrintWriter;

/**
 * The program encodes and decodes messages using Vigenere cipher.
 *
 * @author Lydia Ye
 */


public class VigenereCipher {
  public static void main(String[] args) throws Exception{
    PrintWriter pen = new PrintWriter(System.out, true);

    // Print error messages if input is invalid
    if (!(args[0].equals("encode")) && !(args[0].equals("decode"))){
      // invalid instruction
      System.err.println("Invalid input: the first parameter should be 'encode' or 'decode'");
      System.exit(1);
    } else if (args.length != 3) {
      //invalid number of command line arguments
      System.err.println("Invalid input: incorrect number of parameters");
      System.exit(2);
    } // if

    String instruction = args[0];
    String message = args[1];
    String keyword = args[2];
    String result;

    if (instruction.equals("encode")) {
      result = encode(message, keyword);
      pen.println(result);
    } else if (instruction.equals("decode")) {
      result = decode(message, keyword);
      pen.println(result);
    } // if

  } // main(String[])

  public static String encode(String message, String keyword) {
    char[] ch = message.toCharArray();  // array of letters to be encrypt
    char[] encoded_ch = new char[message.length()];
    char[] key = keyword.toCharArray();

    for (int i = 0; i < message.length(); i++) {
      int n =  i % keyword.length();
      encoded_ch[i] = (char) ('a' + ((ch[i] - 'a') + (key[n] - 'a')) % 26);
    } // for

    String encodedMessage = new String(encoded_ch);
    return encodedMessage;
  } // encode

  public static String decode(String message, String keyword) {
    char[] ch = message.toCharArray();  // array of letters to be encrypt
    char[] decoded_ch = new char[message.length()];
    char[] key = keyword.toCharArray();

    for (int i = 0; i < message.length(); i++) {
      int n =  i % keyword.length();
      decoded_ch[i] = (char) ('a' + ((ch[i] - 'a') - (key[n] - 'a') + 26 ) % 26);
    } // for

    String decodedMessage = new String(decoded_ch);
    return decodedMessage;
  } // decode

} // class VigenereCipher
