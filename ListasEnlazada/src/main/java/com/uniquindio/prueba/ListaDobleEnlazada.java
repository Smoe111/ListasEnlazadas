package com.uniquindio.prueba;

public class ListaDobleEnlazada {

    private NodoDoble head;
    private NodoDoble tail;

    public ListaDobleEnlazada() {
        this.head = null;
        this.tail = null;
    }

    // Agregar al final
    public void agregarAlFinal(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);

        if (head == null) { // lista vacía
            head = tail = nuevo;
        } else {
            tail.setProximo(nuevo);
            nuevo.setAnterior(tail);
            tail = nuevo;
        }
    }

    // Agregar al inicio
    public void agregarAlInicio(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);

        if (head == null) {
            head = tail = nuevo;
        } else {
            nuevo.setProximo(head);
            head.setAnterior(nuevo);
            head = nuevo;
        }
    }

    // Mostrar de inicio a fin
    public void mostrarAdelante() {
        NodoDoble actual = head;
        while (actual != null) {
            System.out.print(actual.getDato() + " <-> ");
            actual = actual.getProximo();
        }
        System.out.println("null");
    }

    // Mostrar de fin a inicio
    public void mostrarAtras() {
        NodoDoble actual = tail;
        while (actual != null) {
            System.out.print(actual.getDato() + " <-> ");
            actual = actual.getAnterior();
        }
        System.out.println("null");
    }

    // Eliminar un nodo con cierto valor
    public void eliminarElemento(int dato) {
        if (head == null) return;

        NodoDoble actual = head;

        while (actual != null && actual.getDato() != dato) {
            actual = actual.getProximo();
        }

        if (actual == null) return; // no encontrado

        // Caso 1: eliminar head
        if (actual == head) {
            head = head.getProximo();
            if (head != null) head.setAnterior(null);
        }
        // Caso 2: eliminar tail
        else if (actual == tail) {
            tail = tail.getAnterior();
            if (tail != null) tail.setProximo(null);
        }
        // Caso 3: nodo en el medio
        else {
            actual.getAnterior().setProximo(actual.getProximo());
            actual.getProximo().setAnterior(actual.getAnterior());
        }
    }


}
