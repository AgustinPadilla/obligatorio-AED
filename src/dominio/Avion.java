/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import tads.ListaS;

/**
 *
 * @author agust
 */
public class Avion {

    private String codigo;
    private int capacidadMaxima;
    private ListaS<Vuelo> Vuelos;
    
    public Avion(String codigo, int capacidadMaxima){
        this.codigo = codigo;
        this.capacidadMaxima = capacidadMaxima;
        this.Vuelos = new ListaS<Vuelo>();
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
    
    public ListaS<Vuelo> getVuelos() {
        return Vuelos;
    }

    public void setVuelos(ListaS<Vuelo> Vuelos) {
        this.Vuelos = Vuelos;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Avion)) return false;
        Avion otro = (Avion) obj;
        return this.codigo.equals(otro.codigo);
    }
    
    public boolean vuelosConPasajesVendidos(){
        if (Vuelos.Vacia()) return false;
        
        for (int i = 0; i < Vuelos.Longitud(); i++) {
            if(Vuelos.Obtener(i).tienePasajesVendidos()){
                return true;
            }
        }
        return false;
    }
    
    @Override 
    public String toString(){
        return codigo + "-" + capacidadMaxima + "|" ;
    }
}
