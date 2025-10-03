package com.uniquindio.prueba.Pilas;

public class Main4 {
    public static void main(String[] args) {

        System.out.println("=== PILA ===");
        Pila<Integer> pila = new Pila<>();

        // Empilar elementos
        pila.empilar(30);
        pila.empilar(10);
        pila.empilar(20);

        System.out.println("Pila inicial:");
        pila.mostrar(); // 20 -> 10 -> 30

        // Insertar en posición 1 (relativo a cima)
        pila.insertarEnPosicion(15, 1);
        System.out.println("\nDespués de insertar 15 en posición 1:");
        pila.mostrar(); // 20 -> 15 -> 10 -> 30

        // Ordenar ascendente
        pila.ordenarAscendente();
        System.out.println("\nDespués de ordenar ascendente:");
        pila.mostrar(); // 10 -> 15 -> 20 -> 30

        // Desempilar elementos
        System.out.println("\nDesempilado: " + pila.desempilar()); // 10
        System.out.println("Desempilado: " + pila.desempilar()); // 15

        System.out.println("\nPila final:");
        pila.mostrar(); // 20 -> 30

        // Verificar estado
        System.out.println("\n¿Pila vacía? " + pila.estaVacia()); // false
        System.out.println("Tamaño de la pila: " + pila.getTamaño()); // 2
    }
}
