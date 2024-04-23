/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author agust
 */
public class Avion {
    private String codigo;
    private int capacidadMaxima;
    
    public Avion(String codigo, int capacidadMaxima){
        this.codigo = codigo;
        this.capacidadMaxima = capacidadMaxima;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public void setCapacidadMaxima(int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
    }
    
    public int getCapacidadMaxima(){
        return capacidadMaxima;
    }
}
