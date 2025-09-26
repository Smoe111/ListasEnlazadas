package com.uniquindio.prueba;

public class ListaEnlazada {

    public Nodo head;

    public ListaEnlazada() {
        head= null;
    }

    public void agregarElemento(int dato){

        Nodo nuevo= new Nodo(dato);
        if(head == null){
            head = nuevo;
        }else{
            Nodo actual= head;
            while (actual.getProximo() != null){
                actual= actual.getProximo();
            }
            actual.setProximo(nuevo);
        }
    }

    public void mostrar(){
        Nodo actual= head;
        while(actual != null){
            System.out.println(actual.getDato());
            actual= actual.getProximo();
        }
        System.out.println("null");
    }

    public boolean buscarElemento(int dato){
        Nodo actual= head;
        while (actual != null){
            if (actual.getDato() == dato){
                return true;
            }
            actual= actual.getProximo();
        }
        return false;
    }

    public void eliminarElemento(int dato){
        if(head == null) return;

        if(head.getDato() == dato){
            head= head.getProximo();
            return;
        }

        Nodo actual= head;
        while(actual.getProximo() != null && actual.getProximo().getDato() != dato){
            actual= actual.getProximo();
        }

        if (actual.getProximo() != null){
            actual.setProximo(actual.getProximo().getProximo());
        }
    }

    public void agregarEnPosicionEspecifica(int dato, int posicion){
        Nodo nuevo= new Nodo(dato);

        if (posicion<=0){
            nuevo.setProximo(head);
            head= nuevo;
            return;
        }

        Nodo actual= head;
        int indice= 0;

        while(actual.getProximo() != null && indice<posicion-1){
            actual= actual.getProximo();
            indice++;
        }
        nuevo.setProximo(actual.getProximo());
        actual.setProximo(nuevo);
    }


}
