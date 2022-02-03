
package ec.edu.espol.util;

public interface List<E> extends Iterable<E> {
    
    public boolean addFirst(E e); // inserta el elemento e al inicio

    public boolean addLast(E e); // inserta el elemento e al final

    public E removeFirst(); // remueve el elemento al inicio de la lista

    public E removeLast(); // remueve el elemento al final de la lista

    public int size();

    public boolean isEmpty();

    public void clear();
    
    boolean contains(E Element);  
    
    boolean add(E Element, int index); // inserta element en la posición index

    public E remove(int index); // remueve y retorna el elemento en la posición index

    public E get(int index); // retorna el elemento ubicado en la posición index

    public E set(int index, E element); // setea el element en la posición index
    
    int indexOf(E Element);  // retorna el indice donde se encuentra el elemento    
    
}
