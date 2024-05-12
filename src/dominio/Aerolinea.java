/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;
import tads.ListaS;

public class Aerolinea {
    private String nombre;
    private String pais;
    private int cantMaxAviones;
    private ListaS<Avion> Aviones;
    
    public Aerolinea(String nombre, String pais, int cantMaxAviones){
        this.nombre = nombre;
        this.pais = pais;
        this.cantMaxAviones = cantMaxAviones;
        this.Aviones = new ListaS<Avion>();
    }
    
    public Aerolinea(String nombre){
        this.nombre = nombre;
    }
    
    public void setNombre(String nom){
        nombre = nom;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setPais (String p){
        pais = p;
    }
    
    public String getPais(){
        return pais;
    }
    
    public void setCantMaxAviones(int v){
        cantMaxAviones = v;
    }
    
    public int getCantMaxAviones(){
        return cantMaxAviones;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Aerolinea)) return false;
        Aerolinea otro = (Aerolinea) obj;
        return this.nombre.equals(otro.nombre);
    }

    public ListaS<Avion> getAviones() {
        return Aviones;
    }  
    
    public void agregarAvion(Avion avion) throws Exception {
        if(Aviones.Contiene(avion)) throw new Exception("Avion ya existe");
        
        Aviones.Adicionar(avion);
    }
    
    public void eliminarAvion(int pos) {
        
        Aviones.Eliminar(pos);
    }
    
    @Override 
    public String toString(){
        return nombre + "-" + pais + "-" + cantMaxAviones + "|" ;
    }
}
