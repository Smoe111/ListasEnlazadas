package com.uniquindio.prueba;

public class Nodo<T> {
    T dato;
    Nodo<T> proximo;

    public Nodo (T dato){
        this.dato= dato;
        this.proximo = null;
    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> setDato(T dato) {
        this.dato = dato;
        return this;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public Nodo<T> setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
        return this;
    }
}
