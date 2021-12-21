/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author rsgar
 */
public class Crypto {
    
    private final String key;
    private String word;
    private String encryptWord;
    private String decryptWord;

    public Crypto() {
        this.key = "SomosProgramadores";
    }

    public Crypto(String key) {
        this.key = key;
    }

    public Crypto(String key, String word, String encryptWord, String decryptWord) {
        this.key = key;
        this.word = word;
        this.encryptWord = encryptWord;
        this.decryptWord = decryptWord;
    }

    public Crypto(String key, String word) {
        this.key = key;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getEncryptWord() {
        return encryptWord;
    }

    public void setEncryptWord(String encryptWord) {
        this.encryptWord = encryptWord;
    }

    public String getDecryptWord() {
        return decryptWord;
    }

    public void setDecryptWord(String decryptWord) {
        this.decryptWord = decryptWord;
    }
   
    public String getKey() {
        return key;
    }
    
    // Método para crear la clave de encriptado / desencriptado
    public SecretKeySpec createKeyCode(String key){
        
        try{
            byte[] chain = key.getBytes("UTF-8");
            MessageDigest md =  MessageDigest.getInstance("SHA-1");
            chain = md.digest(chain);
            chain = Arrays.copyOf(chain, 16);
            SecretKeySpec skp = new SecretKeySpec(chain, "AES");
            return skp;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            return null;
        }
        
    }
    
    //Método de encriptado
    public String encrypt(String encrypt){
        
        try{
            SecretKeySpec skp = createKeyCode(key);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skp);
            
            byte[] chain = encrypt.getBytes("UTF-8");
            byte[] encrypts = cipher.doFinal(chain);
            Encoder encoder = Base64.getEncoder();
            String encryptChain = encoder.encodeToString(encrypts);
            return encryptChain;
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            return null;
        }
        
    }
    
    //Método de descencriptado
    public String decrypt(String decrypt){
        
        try{
            SecretKeySpec skp = createKeyCode(key);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skp);
            
            Decoder decoder = Base64.getDecoder();
            byte[] chain = decoder.decode(decrypt);
            byte[] decrypts = cipher.doFinal(chain);
            String decryptChain = new String(decrypts);
            return decryptChain;
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            return null;
        }
        
    }
}
