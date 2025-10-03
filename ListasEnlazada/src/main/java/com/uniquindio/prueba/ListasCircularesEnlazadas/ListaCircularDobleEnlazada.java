package com.uniquindio.prueba.ListasCircularesEnlazadas;

import com.uniquindio.prueba.Nodo;
import com.uniquindio.prueba.NodoDoble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaCircularDobleEnlazada <T extends Comparable<T>> {
    private NodoDoble<T> cabeza;
    private NodoDoble<T> ultimo;
    private int tamaño;

    public ListaCircularDobleEnlazada(){
        this.cabeza = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    public int getTamaño() {
        return tamaño;
    }

    //insertar al final
    public void insertarFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (cabeza == null) { // primer nodo
            cabeza = nuevo;
            ultimo = nuevo;
            cabeza.setProximo(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            nuevo.setAnterior(ultimo);
            nuevo.setProximo(cabeza);
            ultimo.setProximo(nuevo);
            cabeza.setAnterior(nuevo);
            ultimo = nuevo;
        }
        tamaño++;
    }

    //insertar inicio
    public void insertarInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            ultimo = nuevo;
            cabeza.setProximo(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            nuevo.setProximo(cabeza);
            nuevo.setAnterior(ultimo);
            cabeza.setAnterior(nuevo);
            ultimo.setProximo(nuevo);
            cabeza = nuevo;
        }
        tamaño++;
    }

    //insertar en una posición específica
    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion <= 0) {
            insertarInicio(dato);
            return;
        }

        NodoDoble<T> actual = cabeza;
        int index = 0;
        while (index < posicion - 1 && actual.getProximo() != cabeza) {
            actual = actual.getProximo();
            index++;
        }

        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        nuevo.setProximo(actual.getProximo());
        nuevo.setAnterior(actual);

        actual.getProximo().setAnterior(nuevo);
        actual.setProximo(nuevo);

        if (actual == ultimo) {
            ultimo = nuevo;
        }

        tamaño++;
    }

    //ordenar de forma ascendente
    public void ordenarAscendente() {
        if (cabeza == null || cabeza.getProximo() == cabeza) return;

        // Convertir lista a ArrayList
        List<T> listaTemp = new ArrayList<>();
        NodoDoble<T> actual = cabeza;
        do {
            listaTemp.add(actual.getDato());
            actual = actual.getProximo();
        } while (actual != cabeza);

        // Ordenar
        Collections.sort(listaTemp);

        // Reconstruir lista circular doble con valores ordenados
        actual = cabeza;
        int index = 0;
        do {
            actual.setDato(listaTemp.get(index++));
            actual = actual.getProximo();
        } while (actual != cabeza);
    }


    public boolean eliminar(T dato) {
        if (cabeza == null) return false;

        NodoDoble<T> actual = cabeza;
        do {
            if (actual.getDato().equals(dato)) {
                if (actual == cabeza && actual == ultimo) {
                    // único elemento
                    cabeza = null;
                    ultimo = null;
                } else if (actual == cabeza) {
                    cabeza = cabeza.getProximo();
                    cabeza.setAnterior(ultimo);
                    ultimo.setProximo(cabeza);
                } else if (actual == ultimo) {
                    ultimo = ultimo.getAnterior();
                    ultimo.setProximo(cabeza);
                    cabeza.setAnterior(ultimo);
                } else {
                    actual.getAnterior().setProximo(actual.getProximo());
                    actual.getProximo().setAnterior(actual.getAnterior());
                }
                tamaño--;
                return true;
            }
            actual = actual.getProximo();
        } while (actual != cabeza);

        return false;
    }

    public boolean buscar(T dato) {
        if (cabeza == null) return false;

        NodoDoble<T> actual = cabeza;
        do {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = actual.getProximo();
        } while (actual != cabeza);

        return false;
    }

    public void recorrerAdelante() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        NodoDoble<T> actual = cabeza;
        do {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getProximo();
        } while (actual != cabeza);
        System.out.println("(cabeza)");
    }

    public void recorrerAtras() {
        if (ultimo == null) {
            System.out.println("Lista vacía");
            return;
        }
        NodoDoble<T> actual = ultimo;
        do {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getAnterior();
        } while (actual != ultimo);
        System.out.println("(último)");
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}
