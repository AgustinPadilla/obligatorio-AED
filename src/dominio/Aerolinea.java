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

    public boolean equals(Aerolinea obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return Objects.equals(this.nombre, obj.nombre);
    }

    public ListaS<Avion> getAviones() {
        return Aviones;
    }  
    
    
}
