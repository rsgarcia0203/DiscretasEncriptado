
package ec.edu.espol.util;

public class EmptyListException extends RuntimeException {
    
    public EmptyListException(){
        super("La lista está vacía.");
    }
    
}
