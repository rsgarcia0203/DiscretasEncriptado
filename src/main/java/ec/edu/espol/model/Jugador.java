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
    private int intentos;
    
    public Jugador(String Name) {
        this.Name = Name;
        this.intentos = 3;
    }
    
    public Jugador() {
        this.Name = null;
        this.intentos = 3;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
        
}
