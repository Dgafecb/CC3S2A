package org.produccion;

public class Main {
    public static void main(String[] args) {
        Quiz trivia = new Quiz();
        boolean pathValido = trivia.cargarPreguntas("/home/pcs5/aaa/CC3S2A/ExamenParcial/Ejercicio1/Sprint2/JuegoTrivia/src/main/resources/preguntas.txt");
        trivia.imprimirPreguntas();
    }
}

