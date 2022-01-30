/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author rsgar
 */
public class MaxPosiblesKeysException extends RuntimeException {

    public MaxPosiblesKeysException(String message) {
        super(message);
    }

    public MaxPosiblesKeysException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
