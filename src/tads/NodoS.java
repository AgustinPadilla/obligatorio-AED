package tads;


public class NodoS<T> {
    protected T dato;
    protected NodoS<T> siguiente;

    public NodoS(T dato, NodoS<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public NodoS(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoS<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoS<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
