/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 *
 * @author rsgar
 */
public abstract class PartidaCrypto {

    public static Crypto crypto;
    public static ArrayList<String> palabras;
    public static int palabrasAcertadas;
    public static int puntos;
    public static int intentos;

    public static void nuevaPartida() {
        crypto = new Crypto();
        palabras = new ArrayList();
        intentos = 3;
        palabrasAcertadas = 0;
        puntos = 0;
        cargarPalabras();
    }

    public static void cargarPalabras() {
        Charset inputCharset = Charset.forName("UTF-8");
        try (BufferedReader bf = new BufferedReader(new FileReader("resources/palabras.txt", inputCharset))) {

            String palabra;
            while ((palabra = bf.readLine()) != null) {

                palabra = palabra.strip();

                if (palabra.length() > 1) {
                    palabra = palabra.toUpperCase();
                    palabras.add(palabra);
                }

            }

        } catch (Exception e) {
        }
    }
    
    public static void recargarIntentos() {
        intentos = 3;
    }

    public static void mistake() {
        intentos--;
        puntos -= 3;
    }

    public static void acert() {
        puntos += 3;
        palabrasAcertadas++;
    }
}
