/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

import com.sun.jdi.event.ExceptionEvent;

/**
 *
 * @author v794708
 */
public class NoExisteException extends RuntimeException {

    public NoExisteException() {
        super("El elemento no existe");
    }
    
}
