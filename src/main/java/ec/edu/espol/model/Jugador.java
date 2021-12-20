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

    public Jugador() {
     this.palabras_encontradas = new ArrayList<>();   
    }
    
    public Jugador(String Name, ArrayList<String> palabras_encontradas) {
        this.Name = Name;
        this.points = 0;
        this.intentos = 3;
        this.palabras_encontradas = palabras_encontradas;
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
    
    public void addPoints(int points){
        this.points += points;
    }
    
    public void intentoFallido(){
        this.intentos--;
    }
    
    
}
