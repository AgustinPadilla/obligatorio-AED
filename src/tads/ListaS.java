package tads;

import Excepciones.NoExisteException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaS<T> implements ILista<T> {

    protected NodoS<T> cabeza;
    protected int longitud;

    // CONSTRUCTOR
    public ListaS() {
        cabeza = null;
        longitud = 0;
    }

    // GETTERS y SETTERs
    public NodoS<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoS<T> cabeza) {
        this.cabeza = cabeza;
    }

    // METODOS
    @Override
    public void Adicionar(T x) {
        NodoS<T> elem = new NodoS(x);
        if (Vacia()) {
            cabeza = elem;
        } else {
            NodoS<T> aux = cabeza;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(elem);
        }
        longitud++;
    }

    @Override
    public void Insertar(T x, int pos) {
        int contador = 0;
        NodoS<T> aux = cabeza;
        while (contador < pos) {
            aux = aux.getSiguiente();
            contador++;
        }
        aux.dato = x;
    }

    @Override
    public T Obtener(int pos) {
        int contador = 0;
        NodoS<T> aux = cabeza;
        while (contador < pos) {
            aux = aux.getSiguiente();
            contador++;
        }
        return aux.dato;
    }

    @Override
    public void Eliminar(int pos) {
        if (pos == 0) {
            cabeza = null;
        } else {

            int contador = 0;
            NodoS<T> aux = cabeza;
            while (contador < pos - 1) {
                aux = aux.getSiguiente();
                contador++;
            }
            NodoS<T> aEliminar = aux.getSiguiente();
            if (aEliminar.getSiguiente() == null) {
                aux.setSiguiente(null);
            } else {
                aux.setSiguiente(aEliminar.getSiguiente());
            }
        }
        longitud--;
    }

    @Override
    public int Longitud() {
        return longitud;
    }

    @Override
    public boolean Vacia() {
        return cabeza == null;
    }

    public boolean Contiene(T valor) {
        if (Vacia()) {
            return false;
        }
        NodoS<T> aux = cabeza;
        do {
            if (valor.equals(aux.getDato())) {
                return true;
            } else {
                aux = aux.getSiguiente();
            }
        } while (aux != null);

        return false;
    }

    public void EliminarPorValor(T x) throws NoExisteException {
        if (Vacia()) {
            return;
        }
        if (cabeza.getDato().equals(x)) {
            cabeza = null;
            return;
        }
        NodoS<T> aux = cabeza;
        do {
            if (aux.getSiguiente() != null) {
                NodoS<T> auxSig = aux.getSiguiente();
                if (auxSig.getDato().equals(x)) {
                    aux.setSiguiente(auxSig.getSiguiente());
                    longitud--;
                    return;
                } else {
                    aux = aux.getSiguiente();
                }
            }
        } while (aux.getSiguiente() != null);
        throw new NoExisteException();
    }

    public int ObtenerPorValor(T x) throws NoExisteException {
        NodoS<T> aux = cabeza;
        int cont = 0;
        if (cabeza.getDato().equals(x)) {
            return cont;
        }

        while (aux.getSiguiente() != null) {
            if (aux.getDato().equals(x)) {
                return cont;
            } else {
                aux = aux.getSiguiente();
                cont++;
            }

        }
        throw new NoExisteException();

    }

    public String ListarAlfabeticamente() {
        NodoS<T> aux = cabeza;
        List<String> elementos = new ArrayList<>();
        String result = aux.getDato().toString();

        // Almacenar todos los elementos en la lista temporal
        while (aux != null) {
            elementos.add(aux.getDato().toString());
            aux = aux.getSiguiente();
        }
        Collections.sort(elementos);

        for (int i = 1; i < elementos.size(); i++) {
            result += "\n" + elementos.get(i).toString();
        }
        return result;
    }

    public String Listar() {
        NodoS<T> aux = cabeza;
        String result = new String();
        result = aux.getDato().toString();
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
            result += "\n" + aux.getDato().toString();
        }
        return result;
    }

}
