package com.uniquindio.prueba;

public class NodoDoble {

    private int dato;
    private NodoDoble anterior;
    private NodoDoble proximo;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.anterior = null;
        this.proximo = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble getProximo() {
        return proximo;
    }

    public void setProximo(NodoDoble proximo) {
        this.proximo = proximo;
    }
}
