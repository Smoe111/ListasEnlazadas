package com.uniquindio.prueba;

public class Cola <T>{
    private Nodo<T> principio;
    private Nodo<T> fin;
    private int tamaño;

    // Constructor
    public Cola() {
        this.principio = null;
        this.fin = null;
        this.tamaño = 0;
    }

    // Getters y Setters
    public Nodo<T> getPrincipio() {
        return principio;
    }

    public void setPrincipio(Nodo<T> principio) {
        this.principio = principio;
    }

    public Nodo<T> getFin() {
        return fin;
    }

    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (estaVacia()) {
            principio = nuevo;
            fin = nuevo;
        } else {
            fin.setProximo(nuevo);
            fin = nuevo;
        }
        tamaño++;
    }

    // Desencolar -> quitar el primero
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía, no se puede desencolar.");
            return null;
        }
        T dato = principio.getDato();
        principio = principio.getProximo();
        tamaño--;

        // Si la cola quedó vacía después de desencolar
        if (principio == null) {
            fin = null;
        }

        return dato;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }
}
