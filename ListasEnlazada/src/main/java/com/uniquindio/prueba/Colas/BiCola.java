package com.uniquindio.prueba.Colas;

import com.uniquindio.prueba.Nodo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BiCola <T extends Comparable<T>>{
    private Nodo<T> principio;
    private Nodo<T> fin;
    private int tamaño;

    public BiCola() {
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

    public void encolarInicio(T dato){
        Nodo<T>nuevo= new Nodo<T>(dato);
        if(estaVacia()){
            principio= nuevo;
            fin= nuevo;
        }else{
            nuevo.setProximo(principio);
            principio=nuevo;
        }
        tamaño++;
    }


    // Desencolar -> quitar el primero
    public T desencolarInicio() {
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


    public void encolarFinal(T dato) {
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

    public T desencolarFinal() {
        if (estaVacia()) {
            System.out.println("La cola está vacía, no se puede quitar del final.");
            return null;
        }

        // si solo hay un elemento
        if (principio.getProximo() == null) {
            T dato = principio.getDato();
            principio = null;
            fin = null;
            tamaño = 0;
            return dato;
        }

        // recorrer hasta el penúltimo
        Nodo<T> actual = principio;
        while (actual.getProximo().getProximo() != null) {
            actual = actual.getProximo();
        }

        T dato = actual.getProximo().getDato();
        actual.setProximo(null);
        fin = actual;
        tamaño--;

        return dato;
    }

    //Insertar en posición específica
    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > tamaño) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }

        if (posicion == 0) {
            encolarInicio(dato);
            return;
        } else if (posicion == tamaño) {
            encolarFinal(dato);
            return;
        }

        Nodo<T> actual = principio;
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
