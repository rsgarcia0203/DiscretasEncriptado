/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.security;

import ec.edu.espol.model.Letra;
import ec.edu.espol.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rsgar
 */
public abstract class CesarEncrypt {

    private static final String CHARS = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private final static char[] charsArray = (CHARS + CHARS).toCharArray();
    private final static Map<Character, Character> encodeChars = new HashMap<>();
    private final static Map<Character, Character> decodeChars = new HashMap<>();

    // primero obtenemos las claves de nuestro abecedario con la cantidad n de desplazamientos
    public void getEncodeChars(int displacement) throws IndexOutOfBoundsException {

        if (displacement >= CHARS.length()) {
            throw new IndexOutOfBoundsException("");
        } else {
            for (int i = 0; i < charsArray.length; i++) {
                encodeChars.put(charsArray[i], charsArray[i + displacement]);
                decodeChars.put(charsArray[i + displacement], charsArray[i]);
            }
        }

    }

    public static String encodeWord(ArrayList<Letra> letters) {
        StringBuilder encodeword = new StringBuilder();
        
        for (Letra letra : letters) {
            String encodeLetter = encodeChars.get(letra.getLetra()).toString();
            encodeword.append(encodeLetter);
        }
        
        return encodeword.toString();
    }

    public static String decodeWord(ArrayList<Letra> letters) {
        StringBuilder decodeword = new StringBuilder();
        
        for (Letra letra : letters) {
            String encodeLetter = decodeChars.get(letra.getLetra()).toString();
            decodeword.append(encodeLetter);
        }
        
        return decodeword.toString();
    }

}
