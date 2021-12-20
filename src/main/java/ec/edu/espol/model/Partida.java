/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


/**
 *
 * @author rsgar
 */
public abstract class Partida {
    
    public static Jugador jugador;
    public static Crypto sopa;
    public static ArrayList<String> encontradas = new ArrayList();
    public static ArrayList<String> validas;
    
    public static void nuevaPartida(){
        encontradas.clear();
        jugador = new Jugador();
        validas = new ArrayList();
        actualizarPalabrasValidas();
    }
    
    public static boolean yaEncontrada(String palabra){
        return encontradas.contains(palabra);
    }
    
    public static void agregarPalabra(String palabra) {
        encontradas.add(palabra);
    }
    
    /**
     * Este método actualiza la lista de palabras que es posible encontrar 
     * dentro la sopa, tomando en cuenta los movimientos que puede hacer
     * el jugador.
     */
    public static void actualizarPalabrasValidas(){
        
        validas.clear();
        
        try(BufferedReader bf = new BufferedReader(new FileReader("resources\\palabras.txt"))){
             
            String palabra;
            while((palabra = bf.readLine()) != null){
                
                palabra = palabra.strip();
                boolean valida = true;
                
                if(palabra.length() > 1) continue;
                                               
                palabra = palabra.toUpperCase();
                
                if(valida && !encontradas.contains(palabra)){
                    validas.add(palabra);
                }
            }
            
        }catch(Exception e){}        
    }

    
}
