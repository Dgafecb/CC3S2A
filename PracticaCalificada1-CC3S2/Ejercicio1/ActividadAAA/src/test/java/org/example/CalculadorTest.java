package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculadorTest {
    //Suma de 2 numeros positivos
    @Test
    public void testSum_PositiveNumbers_ShouldReturnCorrectSum() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = 5;

        // Act
        int resultado = calculador.sumar(numeroA, numeroB);

        // Assert
        assertEquals(15, resultado, "10 + 5 deberia ser 15");
    }

    //Suma de 2 numeros negativos
    @Test
    public void testSum_NegativeNumbers_ShouldReturnCorrectSum() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = -10;
        int numeroB = -50;

        // Act
        int resultado = calculador.sumar(numeroA, numeroB);

        // Assert
        assertEquals(-60, resultado, "-10 + -50 deberia ser -60");
    }
    //Suma de 1 numero positivo y 1 numero negativo
    @Test
    public void testSum_PositiveNegativeNumbers_ShouldReturnCorrectSum() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = -5;

        // Act
        int resultado = calculador.sumar(numeroA, numeroB);

        // Assert
        assertEquals(5, resultado, "10 + -5 deberia ser 5");
    }
    //Resta de 2 numeros positivos
    @Test
    public void testResta_PositiveNumbers_ShouldReturnCorrectResta() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = 5;

        // Act
        int resultado = calculador.restar(numeroA, numeroB);

        // Assert
        assertEquals(5, resultado, "10 - 5 deberia ser 5");
    }
    //Resta de 1 numero positivo y 1 numero negativo
    @Test
    public void testResta_PositiveNegativeNumber_ShouldReturnCorrectResta() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = -5;

        // Act
        int resultado = calculador.restar(numeroA, numeroB);

        // Assert
        assertEquals(15, resultado, "10 - -5 deberia ser 15");
    }
    //Resta de 2 numeros negativos
    @Test
    public void testResta_NegativeNumbers_ShouldReturnCorrectResta() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = -10;
        int numeroB = -5;

        // Act
        int resultado = calculador.restar(numeroA, numeroB);

        // Assert
        assertEquals(-5, resultado, "-10 - -5 deberia ser -5");
    }
    //Multiplicacion de 2 numeros positivos
    @Test
    public void testMultiplicacion_PositiveNumbers_ShouldReturnCorrectMultiplicacion() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = 5;

        // Act
        int resultado = calculador.multiplicacion(numeroA, numeroB);

        // Assert
        assertEquals(50, resultado, "10 X 5 deberia ser 50");
    }
    //Multiplicacion de 2 numeros negativos
    @Test
    public void testMultiplicacion_NegativeNumbers_ShouldReturnCorrectMultiplicacion() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = -10;
        int numeroB = -5;

        // Act
        int resultado = calculador.multiplicacion(numeroA, numeroB);

        // Assert
        assertEquals(50, resultado, "-10 X -5 deberia ser 50");
    }
    //Multiplicacion de 1 numero positivo y 1 numero negativo
    @Test
    public void testMultiplicacion_PositiveNegativeNumber_ShouldReturnCorrectMultiplicacion() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = -5;

        // Act
        int resultado = calculador.multiplicacion(numeroA, numeroB);

        // Assert
        assertEquals(-50, resultado, "10 X -5 deberia ser -50");
    }
    //Division de 2 numeros positivos
    @Test
    public void testDivision_PositiveNumbers_ShouldReturnCorrectDivision() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = 5;

        // Act
        double resultado = calculador.division(numeroA, numeroB);

        // Assert
        assertEquals(2.0,resultado, "10 / 5 deberia ser 2");
    }
    //Division de 2 numeros negativos
    @Test
    public void testDivision_NegativeNumbers_ShouldReturnCorrectDivision() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = -10;
        int numeroB = -5;

        // Act
        double resultado = calculador.division(numeroA, numeroB);

        // Assert
        assertEquals(2.0,resultado, "-10 / -5 deberia ser 2");
    }
    //Division de 1 numero positivo y 1 numero negativo
    @Test
    public void testDivision_PositivoNegativeNumber_ShouldReturnCorrectDivision() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = -5;

        // Act
        double resultado = calculador.division(numeroA, numeroB);

        // Assert
        assertEquals(-2.0,resultado, "10 / -5 deberia ser -2");
    }
    //Division por 0 espera ArithmeticException
    @Test()
    public void testDivision_PositiveNumberANDZERO_ShouldReturnArithmeticException() {
        // Arrange
        Calculador calculador = new Calculador();
        int numeroA = 10;
        int numeroB = 0;
        try{
            // Act
            double resultado = calculador.division(numeroA, numeroB);
        }catch (ArithmeticException e){
            // Assert
            assertEquals("Division por cero",e.getMessage());
        }

    }
}