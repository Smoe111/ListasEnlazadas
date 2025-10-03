package com.uniquindio.prueba.ListasEnlazadas;

public class Main1 {
    public static void main(String[] args) {

        // prueba lista simple
        System.out.println("=== Lista Simplemente Enlazada ===");
        ListaEnlazada<Integer> listaSimple = new ListaEnlazada<>();

        listaSimple.insertarPrimero(10);
        listaSimple.insertarPrimero(20);
        listaSimple.insertarPrimero(30);

        System.out.println("Lista actual:");
        listaSimple.mostrar();

        System.out.println("¿Está el número 20?: " + listaSimple.localizar(20));
        System.out.println("¿Está el número 40?: " + listaSimple.localizar(40));

        listaSimple.eliminar(20);
        System.out.println("Lista después de eliminar el 20:");
        listaSimple.mostrar();

        listaSimple.insertarEnPosicion(15, 1);
        System.out.println("Lista después de insertar 15 en la posición 1:");
        listaSimple.mostrar();

        // Ordenar lista ascendente
        listaSimple.ordenarAscendente();
        System.out.println("Lista después de ordenar ascendente:");
        listaSimple.mostrar();



        // prueba lista doblemente enlazada
        System.out.println("\n=== Lista Doblemente Enlazada ===");
        ListaDobleEnlazada<Integer> listaDoble = new ListaDobleEnlazada<>();

        listaDoble.agregarAlFinal(10);
        listaDoble.agregarAlFinal(20);
        listaDoble.agregarAlFinal(30);

        System.out.println("Lista hacia adelante:");
        listaDoble.mostrarAdelante();

        System.out.println("Lista hacia atrás:");
        listaDoble.mostrarAtras();

        listaDoble.agregarAlInicio(5);
        System.out.println("Después de agregar al inicio:");
        listaDoble.mostrarAdelante();

        listaDoble.insertarEnPosicion(25, 2);
        System.out.println("Después de insertar 25 en la posición 2:");
        listaDoble.mostrarAdelante();

        // Ordenar lista doblemente enlazada
        listaDoble.ordenarAscendente();
        System.out.println("Lista doble después de ordenar ascendente:");
        listaDoble.mostrarAdelante();

        listaDoble.eliminarElemento(20);
        System.out.println("Después de eliminar 20:");
        listaDoble.mostrarAdelante();
    }
}