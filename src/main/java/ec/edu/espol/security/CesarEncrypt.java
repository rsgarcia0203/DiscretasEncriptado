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
    private static final char[] charsArray = (CHARS + CHARS).toCharArray();
    public static Map<Character, Character> encodeChars = new HashMap<>();
    public static Map<Character, Character> decodeChars = new HashMap<>();

    // primero obtenemos las claves de nuestro abecedario con la cantidad n de desplazamientos
    public static void getEncodeChars() {

        // La cantidad de desplazamientos será aleatoria
        int displacement;

        do {
            displacement = (int) (Math.random() * CHARS.length());
        } while (displacement < 3 && displacement < CHARS.length());

        for (int i = 0; i < charsArray.length; i++) {
            if (encodeChars.size() != CHARS.length() || decodeChars.size() != CHARS.length()) {
                encodeChars.put(charsArray[i], charsArray[i + displacement]);
                decodeChars.put(charsArray[i + displacement], charsArray[i]);
            }
            System.out.println("||");
            System.out.println(encodeChars);
            System.out.println(decodeChars);
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

    public static String encodeWord(String word) {
        StringBuilder encodeword = new StringBuilder();

        for (char letra : word.toCharArray()) {
            String encodeLetter = encodeChars.get(letra).toString();
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

    public static String decodeWord(String word) {
        StringBuilder decodeword = new StringBuilder();

        for (char letra : word.toCharArray()) {
            String encodeLetter = decodeChars.get(letra).toString();
            decodeword.append(encodeLetter);
        }

        return decodeword.toString();
    }

}
