
package ec.edu.espol.model;

import ec.edu.espol.util.CircularDoublyLinkedList;
import ec.edu.espol.util.DoublyLinkedList;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class Sopa {
    
    int n_filas;
    int n_columnas;
    private final DoublyLinkedList<CircularDoublyLinkedList> sopa;
    private final String CHARS = "AABCDEEFGHIIJKLMNÑOOPQRSTUUVWXYZ";
    
    public Sopa(int n_filas, int n_columnas){
        this.n_filas = n_filas;
        this.n_columnas = n_columnas;
        sopa = new DoublyLinkedList();
        
        Random rnd = new Random();
        
        for(int i = 0; i < n_filas; i++){
            CircularDoublyLinkedList<Letra> fila = new CircularDoublyLinkedList();
            sopa.addFirst(fila);
            
            for(int j = 0; j < n_columnas; j++){
                char c = CHARS.charAt(rnd.nextInt(CHARS.length()));
                Letra l = new Letra(c, n_filas-i, j+1);
                
                fila.addLast(l);
            }
        }
        
    }
    
    public DoublyLinkedList<CircularDoublyLinkedList> getSopa(){
        return sopa;
    }
    
    public void avanzarFila(int nfila){
        if(nfila > n_filas || nfila < 1) return;
        
        CircularDoublyLinkedList<Letra> fila = sopa.get(nfila-1);
        fila.moveForward();
        actualizarColumnas(fila, nfila);
    }
    
    public void retrocederFila(int nfila){
        if(nfila > n_filas || nfila < 1) return;
        
        CircularDoublyLinkedList<Letra> fila = sopa.get(nfila-1);
        fila.moveBackwards();
        actualizarColumnas(fila, nfila);
    }
    
    public void avanzarColumna(int ncolumna){
        if(ncolumna > n_columnas || ncolumna < 1) return;
        CircularDoublyLinkedList<Letra> columna = new CircularDoublyLinkedList();
        
        for(CircularDoublyLinkedList<Letra> fila: sopa){
            Letra l = fila.get(ncolumna-1);
            int nueva_fila = (l.getFila() == n_filas)?1:l.getFila()+1;
            l.actualizarPosicion(nueva_fila, l.getColumna());
            
            columna.addLast(l);
        }
        
        columna.moveForward();
        for(int i = 0; i<sopa.size(); i++){
            CircularDoublyLinkedList<Letra> fila = sopa.get(i);
            fila.set(ncolumna-1, columna.get(i));
        }
        
    }
    
    public void retrocederColumna(int ncolumna){
        if(ncolumna > n_columnas || ncolumna < 1) return;
        CircularDoublyLinkedList<Letra> columna = new CircularDoublyLinkedList();
        
        for(CircularDoublyLinkedList<Letra> fila: sopa){
            Letra l = fila.get(ncolumna-1);
            int nueva_fila = (l.getFila() == 1)?n_filas:l.getFila()-1;
            l.actualizarPosicion(nueva_fila, l.getColumna());
            
            columna.addLast(l);
        }
        
        columna.moveBackwards();
        for(int i = 0; i<sopa.size(); i++){
            CircularDoublyLinkedList<Letra> fila = sopa.get(i);
            fila.set(ncolumna-1, columna.get(i));
        }
    }
    
    private void actualizarColumnas(CircularDoublyLinkedList<Letra> fila, int nfila){
        
        Iterator<Letra> it = fila.iterator();
        while(it.hasNext()){
            Letra l = it.next();
            l.actualizarPosicion(nfila, fila.indexOf(l)+1);
        }
        
    }
    
    public void eliminarFila(int n_fila){
        sopa.remove(n_fila-1);
        for(int i = n_fila-1; i<sopa.size(); i++){
            CircularDoublyLinkedList<Letra> fila = sopa.get(i);
            for(Letra letra: fila){
                letra.actualizarPosicion(i+1, letra.getColumna());
            }
        }
        n_filas--;
        Partida.actualizarPalabrasValidas();
    }
    
    public void eliminarColumna(int n_columna){
        
        for(int i = 0; i<sopa.size(); i++){
            CircularDoublyLinkedList<Letra> fila = sopa.get(i);
            fila.remove(n_columna-1);
            actualizarColumnas(fila, i+1);
        }
        n_columnas--;
        Partida.actualizarPalabrasValidas();
    }
    
    public void insertarFila(int index){
        CircularDoublyLinkedList<Letra> fila = new CircularDoublyLinkedList();
        sopa.add(fila, index-1);
        Random rnd = new Random();
        
        for(int j = 1; j <= n_columnas; j++){
                char c = CHARS.charAt(rnd.nextInt(CHARS.length()));
                Letra l = new Letra(c, index, j);
                
                fila.addLast(l);
        }
        
        for(int i = index; i < n_filas; i++){
            CircularDoublyLinkedList<Letra> fila_aux = sopa.get(i);
            for(Letra letra: fila_aux){
                letra.actualizarPosicion(i+1, letra.getColumna());
            }
        }
        n_filas++;
        Partida.actualizarPalabrasValidas();
    }
    
    public void insertarColumna(int index){
        
        Queue<Letra> cola = new ArrayDeque();
        Random rnd = new Random();
        
        for(int j = 1; j <= n_filas; j++){
                char c = CHARS.charAt(rnd.nextInt(CHARS.length()));
                Letra l = new Letra(c, j, index);
                cola.offer(l);
        }
        
        for(int i = 0; i < n_filas; i++){
            sopa.get(i).add(cola.poll(), index-1);
        }
        
        for(int i = 0; i < n_filas; i++){
            CircularDoublyLinkedList<Letra> fila = sopa.get(i);
            actualizarColumnas(fila, i+1);
        }
        n_columnas++;
        Partida.actualizarPalabrasValidas();
    }

    public int getN_filas() {
        return n_filas;
    }

    public int getN_columnas() {
        return n_columnas;
    }
    
    public void reorganizarLetras(){
        // Aprovechando la característica de Hashing del HashSet para reorganizar las Letras de la Sopa
        // Note que la clase Letra sobrescribe al método "hashCode()"
        
        Set<CircularDoublyLinkedList<Letra>> filas = new HashSet();
        for(CircularDoublyLinkedList<Letra> fila: sopa){
            
            Set<Letra> letras = new HashSet();
            CircularDoublyLinkedList<Letra> nueva_fila = new CircularDoublyLinkedList();
            
            for(Letra letra: fila){
                letras.add(letra);
            }
            
            Iterator<Letra> it = letras.iterator();
            
            while(it.hasNext()){
                nueva_fila.addLast(it.next());
            }
            
            filas.add(nueva_fila);
        }
        
        int n = 0;
        Iterator<CircularDoublyLinkedList<Letra>> it = filas.iterator();
        
        while(it.hasNext()){
            CircularDoublyLinkedList<Letra> fila_reorganizada = it.next();
            sopa.set(n++, fila_reorganizada);
            actualizarColumnas(fila_reorganizada, n);
        }
        
    }
}
