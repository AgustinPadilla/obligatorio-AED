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
public class Vuelo {
    private String codigoVuelo;
    private String aerolinea;
    private String codAvion;
    private String paisDestino;
    private int dia;
    private int mes;
    private int anio;
    private int cantPasajesEcon;
    private int cantPasajesPClase;
    private int vendidosEcon;
    private int vendidosPClase;
    private ListaS<Cliente> listaEsperaEcon;
    private ListaS<Cliente> listaEsperaPClase;

    public Vuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int anio, int cantPasajesEcon, int cantPasajesPClase, int vendidosEcon, int vendidosPClase, ListaS<Cliente> listaEsperaEcon, ListaS<Cliente> listaEsperaPClase) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.codAvion = codAvion;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.cantPasajesEcon = cantPasajesEcon;
        this.cantPasajesPClase = cantPasajesPClase;
        this.vendidosEcon = vendidosEcon;
        this.vendidosPClase = vendidosPClase;
        this.listaEsperaEcon = new ListaS<Cliente>();
        this.listaEsperaPClase = new ListaS<Cliente>();
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantPasajesEcon() {
        return cantPasajesEcon;
    }

    public void setCantPasajesEcon(int cantPasajesEcon) {
        this.cantPasajesEcon = cantPasajesEcon;
    }

    public int getCantPasajesPClase() {
        return cantPasajesPClase;
    }

    public void setCantPasajesPClase(int cantPasajesPClase) {
        this.cantPasajesPClase = cantPasajesPClase;
    }

    public int getVendidosEcon() {
        return vendidosEcon;
    }

    public void setVendidosEcon(int vendidosEcon) {
        this.vendidosEcon = vendidosEcon;
    }

    public int getVendidosPClase() {
        return vendidosPClase;
    }

    public void setVendidosPClase(int vendidosPClase) {
        this.vendidosPClase = vendidosPClase;
    }
    
    public boolean tienePasajesVendidos(){
        return vendidosEcon > 0 || vendidosPClase > 0;
    }
    
}
