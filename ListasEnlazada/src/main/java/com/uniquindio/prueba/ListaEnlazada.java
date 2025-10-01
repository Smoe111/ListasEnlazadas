package com.uniquindio.prueba;

public class ListaEnlazada<T> {

    private Nodo<T> dato;
    int tam = 0;

    public ListaEnlazada() {
        this.dato = null;
    }

    public void insertarPrimero(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setProximo(this.dato);
        this.dato = nuevo;
        tam++;
    }

    public void insertarFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (this.dato == null) {
            this.dato = nuevo;
        } else {
            Nodo<T> actual = this.dato;
            while (actual.getProximo() != null) {
                actual = actual.getProximo();
            }
            actual.setProximo(nuevo);
        }
        tam++;
    }

    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > tam) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            insertarPrimero(dato);
            return;
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> actual = this.dato;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getProximo();
        }
        nuevo.setProximo(actual.getProximo());
        actual.setProximo(nuevo);
        tam++;
    }

    public void mostrar() {
        Nodo<T> actual = dato;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getProximo();
        }
    }

    public boolean esVacia() {
        return dato == null;
    }

    public int getTam() {
        return tam;
    }

    public int localizar(T datoBusqueda) {
        Nodo<T> actual = dato;
        int indice = 0;
        while (actual != null) {
            if (actual.getDato().equals(datoBusqueda)) {
                return indice;
            }
            actual = actual.getProximo();
            indice++;
        }
        return -1;
    }

    public boolean eliminar(T datoBusqueda) {
        if (dato == null) {
            return false;
        }
        if (dato.getDato().equals(datoBusqueda)) {
            dato = dato.getProximo();
            tam--;
            return true;
        }
        Nodo<T> actual = dato;
        while (actual.getProximo() != null) {
            if (actual.getProximo().getDato().equals(datoBusqueda)) {
                actual.setProximo(actual.getProximo().getProximo());
                tam--;
                return true;
            }
            actual = actual.getProximo();
        }
        return false;
    }
}
