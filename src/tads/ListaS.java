package tads;

import Excepciones.NoExisteException;

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
        int contador = 0;
        NodoS<T> aux = cabeza;
        while (contador < pos) {
            aux = aux.getSiguiente();
            contador++;
        }
        NodoS<T> auxSig = aux.getSiguiente();
        aux.setDato(auxSig.getDato());
        aux.setSiguiente(auxSig.getSiguiente());
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

    public NodoS<T> ObtenerPorValor(T x) {
        NodoS<T> aux = cabeza;
        while (aux.getSiguiente() != null) {
            if (aux.getDato().equals(x)) {
                return aux;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

}
