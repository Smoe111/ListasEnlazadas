package com.uniquindio.prueba.ListasCircularesEnlazadas;

import com.uniquindio.prueba.Nodo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaCircularEnlazada<T extends Comparable<T>> {
    private Nodo<T> cabeza;
    private Nodo<T> ultimo;
    private int tamaño;

    public ListaCircularEnlazada() {
        this.cabeza = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    public int getTamaño() {
        return tamaño;
    }

    //insertar al final
    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            ultimo = nuevo;
            nuevo.setProximo(cabeza); // apunta a sí mismo
        } else {
            ultimo.setProximo(nuevo);
            nuevo.setProximo(cabeza);
            ultimo = nuevo;
        }
        tamaño++;
    }


    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0) throw new IndexOutOfBoundsException("Posición inválida");
        if (posicion == 0) { // insertar al inicio
            Nodo<T> nuevo = new Nodo<>(dato);
            if (cabeza == null) {
                cabeza = nuevo;
                ultimo = nuevo;
                nuevo.setProximo(cabeza);
            } else {
                nuevo.setProximo(cabeza);
                cabeza = nuevo;
                ultimo.setProximo(cabeza);
            }
            tamaño++;
            return;
        }

        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getProximo();
            if (actual == cabeza) break; // si la posición excede tamaño, insertar al final
        }

        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setProximo(actual.getProximo());
        actual.setProximo(nuevo);

        if (actual == ultimo) {
            ultimo = nuevo;
        }

        tamaño++;
    }


    public void ordenarAscendente() {
        if (cabeza == null || cabeza.getProximo() == cabeza) return; // vacía o un solo elemento

        // Convertir lista circular a ArrayList
        List<T> listaTemp = new ArrayList<>();
        Nodo<T> actual = cabeza;
        do {
            listaTemp.add(actual.getDato());
            actual = actual.getProximo();
        } while (actual != cabeza);

        // Ordenar
        Collections.sort(listaTemp);

        // Reconstruir lista circular con valores ordenados
        actual = cabeza;
        int index = 0;
        do {
            actual.setDato(listaTemp.get(index++));
            actual = actual.getProximo();
        } while (actual != cabeza);
    }


    public boolean eliminar(T dato) {
        if (cabeza == null) return false;

        Nodo<T> actual = cabeza;
        Nodo<T> anterior = ultimo;
        do {
            if (actual.getDato().equals(dato)) {
                if (actual == cabeza) { // eliminar cabeza
                    cabeza = cabeza.getProximo();
                    ultimo.setProximo(cabeza);
                } else if (actual == ultimo) { // eliminar último
                    ultimo = anterior;
                    ultimo.setProximo(cabeza);
                } else { // eliminar en medio
                    anterior.setProximo(actual.getProximo());
                }
                tamaño--;
                return true;
            }
            anterior = actual;
            actual = actual.getProximo();
        } while (actual != cabeza);

        return false;
    }

    public boolean buscar(T dato) {
        if (cabeza == null) return false;

        Nodo<T> actual = cabeza;
        do {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = actual.getProximo();
        } while (actual != cabeza);

        return false;
    }

    public void recorrer() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo<T> actual = cabeza;
        do {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getProximo();
        } while (actual != cabeza);
        System.out.println("(cabeza)");
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}
