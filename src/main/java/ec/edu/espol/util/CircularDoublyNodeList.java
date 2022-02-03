/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

/**
 *
 * @author rsgar
 */
class CircularDoublyNodeList<E> {
    
    private E content;
    private CircularDoublyNodeList<E> next;
    private CircularDoublyNodeList<E> previous;
    
    public CircularDoublyNodeList(){
        next = this;
        previous = this;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public CircularDoublyNodeList<E> getNext() {
        return next;
    }

    public void setNext(CircularDoublyNodeList<E> next) {
        this.next = next;
    }
    
    public CircularDoublyNodeList<E> getPrevious() {
        return previous;
    }

    public void setPrevious(CircularDoublyNodeList<E> previous) {
        this.previous = previous;
    }
    
}