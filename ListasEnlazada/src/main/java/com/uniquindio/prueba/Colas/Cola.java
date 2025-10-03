package com.uniquindio.prueba.Colas;

import com.uniquindio.prueba.Nodo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cola <T extends Comparable<T>>{
    private Nodo<T> principio;
    private Nodo<T> fin;
    private int tamaño;

    // Constructor
    public Cola() {
        this.principio = null;
        this.fin = null;
        this.tamaño = 0;
    }

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

    //Insertar en una posición específica
    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > tamaño) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (posicion == 0) {
            Nodo<T> nuevo = new Nodo<>(dato);
            nuevo.setProximo(principio);
            principio = nuevo;
            if (fin == null) fin = nuevo;
        } else {
            Nodo<T> actual = principio;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getProximo();
            }
            Nodo<T> nuevo = new Nodo<>(dato);
            nuevo.setProximo(actual.getProximo());
            actual.setProximo(nuevo);
            if (nuevo.getProximo() == null) fin = nuevo;
        }
        tamaño++;
    }

    //Ordenar ascendentemente
    public void ordenarAscendente() {
        if (estaVacia() || principio.getProximo() == null) return;

        List<T> listaTemp = new ArrayList<>();
        Nodo<T> actual = principio;
        while (actual != null) {
            listaTemp.add(actual.getDato());
            actual = actual.getProximo();
        }

        Collections.sort(listaTemp);

        actual = principio;
        int index = 0;
        while (actual != null) {
            actual.setDato(listaTemp.get(index++));
            actual = actual.getProximo();
        }
    }

    public void mostrar() {
        Nodo<T> actual = principio;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getProximo();
        }
        System.out.println("null");
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }
}
