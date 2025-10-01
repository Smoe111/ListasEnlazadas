package com.uniquindio.prueba;

public class ListaDobleEnlazada <T>{

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
