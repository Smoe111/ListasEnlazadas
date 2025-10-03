package com.uniquindio.prueba.ListasEnlazadas;

import com.uniquindio.prueba.NodoDoble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaDobleEnlazada <T extends Comparable<T>>{

    private NodoDoble inicio;
    private NodoDoble fin;

    public ListaDobleEnlazada() {
        this.inicio = null;
        this.fin = null;
    }

    // Agregar al final
    public void agregarAlFinal( T dato) {
        NodoDoble nuevo = new NodoDoble(dato);

        if (inicio == null) { // lista vacía
            inicio = fin = nuevo;
        } else {
            fin.setProximo(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }
    }

    // Agregar al inicio
    public void agregarAlInicio(T dato) {
        NodoDoble nuevo = new NodoDoble(dato);

        if (inicio == null) {
            inicio = fin = nuevo;
        } else {
            nuevo.setProximo(inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
    }

    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0) throw new IndexOutOfBoundsException("Posición inválida");

        if (posicion == 0) {
            agregarAlInicio(dato);
            return;
        }

        NodoDoble actual = inicio;
        int indice = 0;
        while (actual != null && indice < posicion - 1) {
            actual = actual.getProximo();
            indice++;
        }

        if (actual == null) { // si la posición es mayor al tamaño, agregar al final
            agregarAlFinal(dato);
            return;
        }

        NodoDoble nuevo = new NodoDoble(dato);
        nuevo.setProximo(actual.getProximo());
        nuevo.setAnterior(actual);

        if (actual.getProximo() != null) {
            actual.getProximo().setAnterior(nuevo);
        } else {
            fin = nuevo; // si se insertó al final, actualizar fin
        }

        actual.setProximo(nuevo);
    }

    public void ordenarAscendente() {
        if (inicio == null || inicio.getProximo() == null) return;

        // Convertir a ArrayList
        List<T> listaArrayList = new ArrayList<>();
        NodoDoble actual = inicio;
        while (actual != null) {
            listaArrayList.add((T) actual.getDato());
            actual = actual.getProximo();
        }

        // Ordenar
        Collections.sort(listaArrayList);

        // Reconstruir la lista con los valores ordenados
        actual = inicio;
        for (T elem : listaArrayList) {
            actual.setDato(elem);
            actual = actual.getProximo();
        }
    }


    // Mostrar de inicio a fin
    public void mostrarAdelante() {
        NodoDoble actual = inicio;
        while (actual != null) {
            System.out.print(actual.getDato() + " <-> ");
            actual = actual.getProximo();
        }
        System.out.println("null");
    }

    // Mostrar de fin a inicio
    public void mostrarAtras() {
        NodoDoble actual = fin;
        while (actual != null) {
            System.out.print(actual.getDato() + " <-> ");
            actual = actual.getAnterior();
        }
        System.out.println("null");
    }

    // Eliminar un nodo con cierto valor
    public void eliminarElemento(T dato) {
        if (inicio == null) return;

        NodoDoble actual = inicio;

        while (actual != null && actual.getDato() != dato) {
            actual = actual.getProximo();
        }

        if (actual == null) return; // no encontrado

        // Caso 1: eliminar head
        if (actual == inicio) {
            inicio = inicio.getProximo();
            if (inicio != null) inicio.setAnterior(null);
        }
        // Caso 2: eliminar tail
        else if (actual == fin) {
            fin = fin.getAnterior();
            if (fin != null) fin.setProximo(null);
        }
        // Caso 3: nodo en el medio
        else {
            actual.getAnterior().setProximo(actual.getProximo());
            actual.getProximo().setAnterior(actual.getAnterior());
        }
    }
}
