package sistemaAutogestion;

import Excepciones.NoExisteException;
import dominio.*;
import tads.ListaS;
import tads.NodoS;

public class Sistema implements IObligatorio {

    private ListaS<Aerolinea> ListaAerolineas;
    private ListaS<Cliente> ListaClientes;

    @Override
    public Retorno crearSistemaDeGestion() {
        ListaAerolineas = new ListaS<>();
        ListaClientes = new ListaS<>();

        return Retorno.ok();
    }

    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
        Aerolinea nuevo = new Aerolinea(nombre, pais, cantMaxAviones);

        if (cantMaxAviones <= 0) {
            return Retorno.error2();
        }

        if (ListaAerolineas.Contiene(nuevo)) {
            return Retorno.error1();
        }

        ListaAerolineas.Adicionar(nuevo);
        return Retorno.ok();
    }

    @Override
    public Retorno eliminarAerolinea(String nombre) {
        Aerolinea aux = new Aerolinea(nombre);
        int pos;
        Aerolinea Aerolinea;
        try {
            pos = ListaAerolineas.ObtenerPorValor(aux);
            Aerolinea = ListaAerolineas.Obtener(pos);
        } catch (NoExisteException ex) {
            return Retorno.error1();
        }

        if (!Aerolinea.getAviones().Vacia()) {
            return Retorno.error2();
        }

        ListaAerolineas.EliminarPorValor(aux);

        return Retorno.ok();
    }

    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {

        if (capacidadMax < 9 || capacidadMax % 3 != 0) {
            return Retorno.error2();
        }

        Aerolinea x = new Aerolinea(nomAerolinea);
        int pos;
        Aerolinea Aerolinea;
        try {
            pos = ListaAerolineas.ObtenerPorValor(x);
            Aerolinea = ListaAerolineas.Obtener(pos);
        } catch (NoExisteException ex) {
            return Retorno.error3();
        }
        
        if (Aerolinea.getAviones().Longitud() == Aerolinea.getCantMaxAviones()) return Retorno.error4();

        Avion nuevoAvion = new Avion(codigo, capacidadMax);

        try {
            Aerolinea.agregarAvion(nuevoAvion);
        } catch (Exception e) {
            return Retorno.error1();
        }
        return Retorno.ok();
    }

    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {

        Aerolinea aux = new Aerolinea(nomAerolinea);
        int pos;
        Aerolinea Aerolinea;
        try {
            pos = ListaAerolineas.ObtenerPorValor(aux);
            Aerolinea = ListaAerolineas.Obtener(pos);
        } catch (NoExisteException ex) {
            return Retorno.error1();
        }

        try {
            Avion x = new Avion(codAvion, 0);
            int posAvion = Aerolinea.getAviones().ObtenerPorValor(x);
            Avion avion = Aerolinea.getAviones().Obtener(posAvion);
            if (avion.vuelosConPasajesVendidos()) {
                return Retorno.error3();
            }

            Aerolinea.eliminarAvion(posAvion);
        } catch (NoExisteException e) {
            return Retorno.error2();
        }
        return Retorno.ok();
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
        return Retorno.ok(ListaAerolineas.ListarAlfabeticamente());
    }

    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        Aerolinea x = new Aerolinea(nombre);
        int pos;
        Aerolinea Aerolinea;
        try {
            pos = ListaAerolineas.ObtenerPorValor(x);
            Aerolinea = ListaAerolineas.Obtener(pos);
        } catch (NoExisteException ex) {
            return Retorno.error1();
        }
        
        return Retorno.ok(Aerolinea.getAviones().Listar());
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
