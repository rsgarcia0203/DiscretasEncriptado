/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author rsgar
 */
public class TablaPuntuaciones {
    ArrayList<Integer> puntuaciones;
    ArrayList<String> usuarios;

    public TablaPuntuaciones(ArrayList<Integer> puntuaciones, ArrayList<String> usuarios) {
        this.puntuaciones = puntuaciones;
        this.usuarios = usuarios;
    }

    public TablaPuntuaciones() {
        this.puntuaciones = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    
    public ArrayList<Integer> getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(ArrayList<Integer> puntuaciones) {
        this.puntuaciones = puntuaciones;
    }

    public ArrayList<String> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<String> usuarios) {
        this.usuarios = usuarios;
    }
    
    public static void saveLeaderboard(ArrayList<String> users, ArrayList<Integer> points) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("resources\\puntuaciones.txt")))) {
            for (int i = 0; i < users.size(); i++) {
                String s = users.get(i) + "|" + points.get(i).toString();
                bw.write(s + "\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadLeaderboard() throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader("resources\\puntuaciones.txt"))) {
            ArrayList<String> users = new ArrayList<>();
            ArrayList<Integer> points = new ArrayList<>();
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split("\\|");
                users.addLast(tokens[0]);
                points.addLast(Integer.parseInt(tokens[1]));
                br.readLine();
            }
            br.close();
            
            this.puntuaciones = points;
            this.usuarios = users;
        } catch (IOException ex) {
            
        }
    }
}
