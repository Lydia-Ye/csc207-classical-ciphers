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

    // Get instruction and message from command line arguments.
    String instruction = args[0];
    String message = args[1];

    printResult(message, instruction);
  } // main(String[])

  /**
   * Encode message with input value of key
   */
  public static String encode(String message, int n) {
    char[] ch = message.toCharArray();  // array of letters to be encrypt
    char[] encoded_ch = new char[message.length()]; // array of encrypted letters
    
    // Encode each single letter of message with n
    for (int i = 0; i < message.length(); i++){
      encoded_ch[i] = (char) ('a' + (ch[i] - 'a' + n) % 26);
    } // for

    // Convert array into string
    String encodedMessage = new String(encoded_ch);
    return encodedMessage;
  } // encode


  /**
   * Decode message with input value of key
   */
  public static String decode(String message, int n) {
    char[] ch = message.toCharArray();  // array of letters to be decrypt
    char[] decoded_ch = new char[message.length()]; // array of decrypted letters
    
    // Decode each single letter of message with n
    for (int i = 0; i < message.length(); i++){
      decoded_ch[i] = (char) ('a' + ((ch[i] - 'a' - n) + 26)% 26);
    } // for

    // Convert array into string
    String decodedMessage = new String(decoded_ch);
    return decodedMessage;
  } // decode

  /**
   * Print result
   */
  public static void printResult(String message, String instruction) {
    PrintWriter pen = new PrintWriter(System.out, true);
    int n = 0;    // value of key to encrypt/decrpt the letter with
    
    if (instruction.equals("encode")) {
      for (n = 0; n <= 25; n++) {
        pen.println("n = " + n + ": " + encode(message, n));
      } // for
    } else if (instruction.equals("decode")) {
      for (n = 0; n <= 25; n++) {
        pen.println("n = " + n + ": " + decode(message, n));
      } // for
    } // if

    pen.flush();
  } // printResult;
} // class CaesarCipher



