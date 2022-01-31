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
public class Padlock {

    private int[] key;
    private ArrayList<int[]> possiblesKeys;
    private int intentos;
    
    // Contructores
    public Padlock() {
        this.key = generateKey(3);
        this.possiblesKeys = generatePossiblesKeys();
        this.intentos = 3;
    }

    public Padlock(int[] key) {
        this.key = key;
        this.possiblesKeys = generatePossiblesKeys();
        this.intentos = 3;
    }

    public Padlock(int[] key, ArrayList<int[]> possiblesKeys) {
        this.key = key;
        this.possiblesKeys = possiblesKeys;
        this.intentos = 3;
    }
    
    // Getters y Setters
    public int[] getKey() {
        return key;
    }

    public void setKey(int[] key) {
        this.key = key;
    }

    public ArrayList<int[]> getPossiblesKeys() {
        return possiblesKeys;
    }

    public void setPossiblesKeys(ArrayList<int[]> possiblesKeys) {
        this.possiblesKeys = possiblesKeys;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
        
    // El método generará la clave del padlock con una cantidad de n dígitos para la clave
    private int[] generateKey(int n) throws MaxDigitsException {
        if (n >= 3 && n <= 5) {
            int[] k = new int[n];
            for (int i = 0; i < this.key.length; i++) {
                int digit = (int) (Math.random() * 10);
                k[i] = digit;
            }
            return k;
        } else {
            throw new MaxDigitsException("");
        }
    }

    // El método generará las posibles claves para abrir el padlock
    private ArrayList<int[]> generatePossiblesKeys() throws MaxPosiblesKeysException{
        int n = this.key.length + 2;

        if (n > 3 && n < 8) {
            ArrayList<int[]> possiblesK = new ArrayList<>();

            //Generamos claves aleatorias
            for (int i = 0; i < n; i++) {
                int[] tmpKey = generateDifferentKey();

                if (possiblesK.isEmpty()) {  // La primera clave posible tendrá un digito de nuestra clave, en el lugar correcto
                    int index = (int) (Math.random() * this.key.length);
                    tmpKey[index] = this.key[index];
                } else if (i == (n - 1)) {  // La última clave posible tendrá un dígito de nuestra clave, pero en el lugar incorrecto
                    int index = (int) (Math.random() * this.key.length);
                    tmpKey[getDifferentIndex(index)] = this.key[index];
                } else if (i == (int) (n / 2)) {  // La clave posible que en la mitad de la lista tendrá dos dígitos de nuestra clave, pero en el lugar incorrecto
                    int index1 = (int) (Math.random() * this.key.length);
                    int index2 = getDifferentIndex(index1);
                    tmpKey[getDifferentIndex(index1)] = this.key[index1];
                    tmpKey[getDifferentIndex(index2)] = this.key[index2];
                } else if (i < (int) (n / 2)) {  // La(s) clave(s) posible(s) generada(s) que estén entre la primera y la central, tendrá(n) un digito de nuestra clave, pero en el lugar incorrecto
                    int index = (int) (Math.random() * this.key.length);
                    tmpKey[getDifferentIndex(index)] = this.key[index];
                } 
                
                // La(s) clave(s) posible(s) generada(s) que estén después de la central, no tendrán ningun número de nuestra clave, por lo cual agregamos nuestra tmpKey
                possiblesK.add(tmpKey);
            }

            return possiblesK;
        } else {
            throw new MaxPosiblesKeysException("");
        }
    }
    
    // Devuelve un índice aleatorio totalmente diferente al indice dado
    private int getDifferentIndex(int oldIndex) {
        int newIndex = (int) (Math.random() * this.key.length);

        while (newIndex == oldIndex) {
            newIndex = (int) (Math.random() * this.key.length);
        }

        return newIndex;
    }
    
    // Genera una clave totalmente diferente a la clave del padlock
    private int[] generateDifferentKey() {
        int[] k = generateKey(this.key.length);
        
        for (int i = 0; i < this.key.length; i++) {
            if (this.contains(k[i])){
                do{
                    int digit = (int) (Math.random() * 10);
                    k[i] = digit;
                } while(!this.contains(k[i]));         
            }
        }
        
        return k;
    }
    
    // Detecta si la clave del padlock contiene un número n 
    private boolean contains(int n){
        
        for (int i = 0; i < this.key.length; i++){
            if (this.key[i] == n){
                return true;
            }
        }
        
        return false;
    }
}
