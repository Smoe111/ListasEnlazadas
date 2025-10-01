package com.uniquindio.prueba;

public class BiCola <T> {

    // cola bidireccional

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

    public boolean estaVacia() {
        return tamaño == 0;
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

    public void agregarInicio(T dato){

        Nodo<T>  nuevo= new Nodo<T>(dato);
         if(estaVacia()){
             principio= nuevo;
             fin= nuevo;
         }else{
             nuevo.setProximo(principio);
             principio=nuevo;
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
}
