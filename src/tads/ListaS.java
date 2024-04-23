package tads;

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
        NodoS<T> elem = new NodoS<T>(x);
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
    public void Insertar(T x, int pos){
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

    public boolean Contiene(T valor){
        NodoS<T> aux = cabeza;
        while (aux.getSiguiente() != null){
            if(aux.getDato().equals(valor)){
                return true;
            }else{
                aux = aux.getSiguiente();
            }
        }
        return false;
    }
    
    public void EliminarPorValor(T x) {
        NodoS<T> aux = cabeza;
        while (aux.getSiguiente() != null) {
            NodoS<T> auxSig = aux.getSiguiente();
            if (auxSig.getDato() == x) {
                aux.setSiguiente(auxSig.getSiguiente());
                longitud--;
                return;
            } else {
                aux = aux.getSiguiente();
            }
        }
    }
    
    public NodoS<T> ObtenerPorValor(T x) {
        NodoS<T> aux = cabeza;
        while (aux.getSiguiente() != null) {
            if (aux.getDato() == x) {
                return aux;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return null;
    }
    
}
