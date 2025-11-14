import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class BlowFishCipher {

    public static void main(String[] args) throws Exception {
        
        KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
        
        SecretKey secretkey = keygenerator.generateKey();
        
        Cipher cipher = Cipher.getInstance("Blowfish");
        
        cipher.init(Cipher.ENCRYPT_MODE, secretkey);
        
        String inputText = "Hello world";
        
        byte[] encrypted = cipher.doFinal(inputText.getBytes());
        
        cipher.init(Cipher.DECRYPT_MODE, secretkey);
        
        byte[] decrypted = cipher.doFinal(encrypted);
        
        System.out.println("Original String: " + inputText);

        String encryptedString = Base64.getEncoder().encodeToString(encrypted);
        System.out.println("Encrypted (Base64): " + encryptedString);
        
        System.out.println("Decrypted String: " + new String(decrypted));
    }
}
