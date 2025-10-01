package com.uniquindio.prueba;

public class Pila<T> {
    private Nodo<T> cima;
    private int tamaño;

    public Pila() {
        this.cima = null;
        this.tamaño = 0;
    }

    public Nodo<T> getCima() {
        return cima;
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public void empilar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setProximo(cima);
        cima = nuevo;
        tamaño++;
    }

    public T desempilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía, no se puede desempilar.");
            return null;
        }
        T dato = cima.getDato();
        cima = cima.getProximo();
        tamaño--;
        return dato;
    }

    public void mostrar() {
        Nodo<T> actual = cima;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getProximo();
        }
    }
}
