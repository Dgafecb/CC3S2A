package org.produccion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    @Test
    void imprimirPreguntasValido() {
        //Arrange
        Quiz trivia = new Quiz();
        //Act
        boolean pathValido = trivia.cargarPreguntas("/home/pcs5/aaa/CC3S2A/ExamenParcial/Ejercicio1-Sprint1/JuegoTrivia/src/main/resources/preguntas.txt");
        //Assert
        assertTrue(pathValido);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void recibirRespuestaValida(String opcionValida) {
        //Arrange
        Quiz trivia = new Quiz();
        //Act
        boolean valido = trivia.recibirRespuesta(opcionValida);
        //Assert
        assertTrue(valido);
    }
    @ParameterizedTest
    @ValueSource(strings = {"9", "C", "a", "0","D2","asd"})
    void recibirRespuestaInvalidas(String opcionInvalida) {
        //Arrange
        Quiz trivia = new Quiz();
        //Act
        boolean invalido = trivia.recibirRespuesta(opcionInvalida);
        //Assert
        assertFalse(invalido);
    }

}