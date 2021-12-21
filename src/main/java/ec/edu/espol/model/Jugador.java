/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;

/**
 *
 * @author rsgar
 */
public class Jugador {
    private String Name;
    private int points;
    private int intentos;
    private final ArrayList<String> palabras_encontradas;
    
    public Jugador(String Name, ArrayList<String> palabras_encontradas) {
        this.Name = Name;
        this.points = 0;
        this.intentos = 3;
        this.palabras_encontradas = palabras_encontradas;
    }
    
    public Jugador() {
        this.Name = null;
        this.points = 0;
        this.intentos = 3;
        this.palabras_encontradas = new ArrayList<>();
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
    
    public int getPalabrasEncontradas(){
        return this.palabras_encontradas.size();
    }   
    
    public void addPalabra(String word){
        this.palabras_encontradas.add(word);
    }
    
    public void mistake(){
        this.intentos--;
        this.points -= 3;
    }
    
    public void acert(){
        this.points += 3;
    }
}
