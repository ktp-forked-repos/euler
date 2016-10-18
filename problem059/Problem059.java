package problem059;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kiran on 1/29/16.
 *
 * A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given value, taken from a secret key.
 * The advantage with the XOR function is that using the same encryption key on the cipher text, restores the plain text; for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
 * If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message.
 * Your task has been made easy, as the encryption key consists of three lower case characters.
 * Using cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes,
 * and the knowledge that the plain text must contain common English words, decrypt the message and find the sum of the ASCII values in the original text.
 */

public class Problem059 {

    public static void main(String[] args) {

        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get("src/problem059/p059_cipher.txt"))).replaceAll("\\s","");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] splitContent = content.split(",");

        char[] encryptedText = new char[splitContent.length];

        for (int i = 0; i < splitContent.length; i++) {
            String character = splitContent[i];
            encryptedText[i] = (char)Integer.parseInt(character);
        }

        char[] decryptedText = null;

        loops:
            for (int firstChar = 'a'; firstChar <= 'z'; firstChar++) {
                for (int secondChar = 'a'; secondChar <= 'z'; secondChar++) {
                    for (int thirdChar = 'a'; thirdChar <= 'z'; thirdChar++) {
                        char[] key = new char[] {(char)firstChar, (char)secondChar, (char)thirdChar};
                        decryptedText = xorDecrypt(encryptedText, key);
                        if (new String(decryptedText).toLowerCase().contains("there")) {
                            break loops;
                        }
                    }
                }
            }

        int sum = 0;
        for (int i = 0; i < decryptedText.length; i++) {
            sum += decryptedText[i];
        }

        System.out.println(sum);
    }

    public static char[] xorDecrypt(char[] text, char[] key) {
        char[] output = new char[text.length];

        int keyIndex = 0;

        for (int i = 0; i < text.length; i++) {
            char c = text[i];
            output[i] = (char)((int)c ^ (int)key[keyIndex]);
            keyIndex++;
            if (keyIndex > 2) keyIndex = 0;
        }

        return output;
    }
}
// Answer: 107359