package com.uniquindio.prueba.Pilas;

import com.uniquindio.prueba.Nodo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pila<T extends Comparable<T>> {
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

    //Insertar en posición específica (0 = cima)
    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > tamaño) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (posicion == 0) {
            empilar(dato);
            return;
        }

        Nodo<T> actual = cima;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getProximo();
        }

        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setProximo(actual.getProximo());
        actual.setProximo(nuevo);
        tamaño++;
    }

    //Ordenar ascendente
    public void ordenarAscendente() {
        if (estaVacia() || cima.getProximo() == null) return;

        List<T> listaTemp = new ArrayList<>();
        Nodo<T> actual = cima;
        while (actual != null) {
            listaTemp.add(actual.getDato());
            actual = actual.getProximo();
        }

        Collections.sort(listaTemp);

        actual = cima;
        int index = 0;
        while (actual != null) {
            actual.setDato(listaTemp.get(index++));
            actual = actual.getProximo();
        }
    }

    public void mostrar() {
        Nodo<T> actual = cima;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getProximo();
        }
    }
}
