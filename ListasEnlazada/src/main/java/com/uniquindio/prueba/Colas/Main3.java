package com.uniquindio.prueba.Colas;

public class Main3 {
    public static void main(String[] args) {

        //COLA SIMPLE
        System.out.println("=== COLA SIMPLE ===");
        Cola<Integer> cola = new Cola<>();

        // Encolar elementos
        cola.encolar(30);
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(40);

        System.out.println("Cola inicial:");
        cola.mostrar(); // 30 -> 10 -> 20 -> 40 -> null

        // Insertar en posición 2
        cola.insertarEnPosicion(25, 2);
        System.out.println("Después de insertar 25 en posición 2:");
        cola.mostrar(); // 30 -> 10 -> 25 -> 20 -> 40 -> null

        // Ordenar ascendente
        cola.ordenarAscendente();
        System.out.println("Después de ordenar ascendente:");
        cola.mostrar(); // 10 -> 20 -> 25 -> 30 -> 40 -> null

        // Desencolar elementos
        System.out.println("Desencolado: " + cola.desencolar()); // 10
        System.out.println("Desencolado: " + cola.desencolar()); // 20

        // Verificar estado
        System.out.println("¿Cola vacía? " + cola.estaVacia()); // false
        System.out.println("Tamaño de la cola: " + cola.getTamaño()); // 3
        System.out.println();


        //BICOLA
        System.out.println("=== BICOLA ===");
        BiCola<Integer> bicola = new BiCola<>();

        // Encolar al inicio
        bicola.encolarInicio(5);
        bicola.encolarInicio(1);

        // Encolar al final
        bicola.encolarFinal(10);
        bicola.encolarFinal(20);

        System.out.println("Bicola inicial:");
        bicola.mostrar(); // 1 -> 5 -> 10 -> 20 -> null

        // Insertar en posición 2
        bicola.insertarEnPosicion(7, 2);
        System.out.println("Después de insertar 7 en posición 2:");
        bicola.mostrar(); // 1 -> 5 -> 7 -> 10 -> 20 -> null

        // Ordenar ascendente
        bicola.ordenarAscendente();
        System.out.println("Después de ordenar ascendente:");
        bicola.mostrar(); // 1 -> 5 -> 7 -> 10 -> 20 -> null

        // Desencolar al inicio
        System.out.println("Desencolado al inicio: " + bicola.desencolarInicio()); // 1

        // Desencolar al final
        System.out.println("Desencolado al final: " + bicola.desencolarFinal()); // 20

        // Verificar estado
        System.out.println("¿Bicola vacía? " + bicola.estaVacia()); // false
        System.out.println("Tamaño de la bicola: " + bicola.getTamaño()); // 3
    }
}
