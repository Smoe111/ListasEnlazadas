package com.uniquindio.prueba.ListasCircularesEnlazadas;


public class Main2 {
    public static void main(String[] args) {

        // LISTA CIRCULAR SIMPLE
        System.out.println("=== LISTA CIRCULAR SIMPLE ===");
        ListaCircularEnlazada<Integer> listaSimple = new ListaCircularEnlazada<>();

        listaSimple.insertar(10);
        listaSimple.insertar(20);
        listaSimple.insertar(30);
        listaSimple.insertar(40);

        System.out.println("Recorrido inicial:");
        listaSimple.recorrer(); // 10 -> 20 -> 30 -> 40 -> (cabeza)

        // Insertar en posición
        listaSimple.insertarEnPosicion(25, 2);
        System.out.println("Después de insertar 25 en posición 2:");
        listaSimple.recorrer();

        // Ordenar ascendente
        listaSimple.ordenarAscendente();
        System.out.println("Después de ordenar ascendente:");
        listaSimple.recorrer();

        // Buscar
        System.out.println("Buscar 20: " + listaSimple.buscar(20)); // true
        System.out.println("Buscar 50: " + listaSimple.buscar(50)); // false

        // Eliminar
        listaSimple.eliminar(30);
        System.out.println("Después de eliminar 30:");
        listaSimple.recorrer();

        System.out.println("¿Está vacía? " + listaSimple.estaVacia()); // false
        System.out.println("Tamaño: " + listaSimple.getTamaño());
        System.out.println();


        // LISTA CIRCULAR DOBLE
        System.out.println("=== LISTA CIRCULAR DOBLE ===");
        ListaCircularDobleEnlazada<Integer> listaDoble = new ListaCircularDobleEnlazada<>();

        listaDoble.insertarFinal(100);
        listaDoble.insertarFinal(200);
        listaDoble.insertarInicio(300);
        listaDoble.insertarInicio(50);

        System.out.println("Recorrido hacia adelante:");
        listaDoble.recorrerAdelante(); // 50 -> 100 -> 200 -> 300 -> (cabeza)

        System.out.println("Recorrido hacia atrás:");
        listaDoble.recorrerAtras(); // 300 -> 200 -> 100 -> 50 -> (último)

        // Insertar en posición
        listaDoble.insertarEnPosicion(150, 2);
        System.out.println("Después de insertar 150 en posición 2:");
        listaDoble.recorrerAdelante();

        // Ordenar ascendente
        listaDoble.ordenarAscendente();
        System.out.println("Después de ordenar ascendente:");
        listaDoble.recorrerAdelante();

        // Buscar
        System.out.println("Buscar 200: " + listaDoble.buscar(200)); // true
        System.out.println("Buscar 999: " + listaDoble.buscar(999)); // false

        // Eliminar
        listaDoble.eliminar(100);
        System.out.println("Después de eliminar 100:");
        listaDoble.recorrerAdelante();

        System.out.println("¿Está vacía? " + listaDoble.estaVacia()); // false
        System.out.println("Tamaño: " + listaDoble.getTamaño());
    }
}
