package sistemaAutogestion;

import dominio.*;
import tads.ListaS;
import tads.NodoS;

public class Sistema implements IObligatorio {

    private ListaS<Aerolinea> ListaAerolineas;
    private ListaS<Vuelo> ListaVuelos;
    private ListaS<Cliente> ListaClientes;
    
    @Override
    public Retorno crearSistemaDeGestion() {
        ListaAerolineas = new ListaS<Aerolinea>();
        ListaVuelos = new ListaS<Vuelo>();
        ListaClientes = new ListaS<Cliente>();
        
        return Retorno.ok();
    }

    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
      Aerolinea nuevo = new Aerolinea(nombre, pais, cantMaxAviones);
      
      if(cantMaxAviones == 0) return Retorno.error2();
      
      if(ListaAerolineas.Contiene(nuevo)) return Retorno.error1();
      
      ListaAerolineas.Adicionar(nuevo);
      return Retorno.ok();
    }

    @Override
    public Retorno eliminarAerolinea(String nombre) {
        Aerolinea aux = new Aerolinea(nombre);
        
        if (!ListaAerolineas.Contiene(aux)) return Retorno.error1();
        
        if (!ListaAerolineas.ObtenerPorValor(aux).getDato().getAviones().Vacia()) return Retorno.error2();
        
        ListaAerolineas.EliminarPorValor(aux);
        
        return Retorno.ok();
    }

    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        
        if(capacidadMax >= 9 || capacidadMax%3 != 0) return Retorno.error2();
        
        Aerolinea x = new Aerolinea(nomAerolinea);
        NodoS<Aerolinea> nodo = ListaAerolineas.ObtenerPorValor(x);
        
        if(nodo == null) return Retorno.error3();
        
        Avion nuevoAvion = new Avion(codigo, capacidadMax);
        
        try{
        nodo.getDato().agregarAvion(nuevoAvion);
        } catch(Exception e){
            return Retorno.error1();
        }
        return Retorno.ok();
    }

    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarAerolineas() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarClientes() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarVuelos() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno vuelosDeCliente(String pasaporte) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        return Retorno.noImplementada();
    }

}
