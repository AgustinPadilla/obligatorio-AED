/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tads;

/**
 *
 * @author v794708
 */
public interface IColaS<T> {
    
    void Adicionar(T x);
    
    T Frente();
    
    T Fondo();
    
    T Extraer();
    
    boolean Vacia();
}
