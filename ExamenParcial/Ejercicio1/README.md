# Avance del juego de Preguntas Trivia
## Sprint 1
### Tareas
1. Configurar el entorno del proyecto utilizando Gradle, incluyendo la dependencia para JUnit5
2. Desarrollar la clase Question con atributos para la descripción de la pregunta, las opciones
disponibles y la respuesta correcta.
3. Implementar la clase Quiz que manejará el flujo del juego, incluyendo cargar preguntas,
presentarlas al usuario y recibir respuestas.
4. Programar la lógica para mostrar preguntas de manera secuencial y permitir al usuario
ingresar respuestas.
5. Escribir pruebas unitarias para asegurar que las preguntas se carguen correctamente y que
las respuestas sean validadas adecuadamente.

### Resolucion

Para resolver estas tareas primero definiremos las dependencias de gradle para usar junit
```java
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
```
Luego definiremos 2 clases que manejaran la logica del juego y las preguntas
#### Clase Question
```java
public class Question{
    //Clase que describira pregunta,
    // listara opciones
    // y la respuesta correcta
    String descripcion;
    String respuesta1;
    String respuesta2;
    String respuesta3;
    String respuesta4;
    int respuestaCorrecta;
    // Con sus respectivos getters y setters
}

```
### Clase Quiz
Esta clase tendra 3 metodos cargarPreguntas, imprimirPreguntas y recibirRespuesta que validara la entrada del usuario
```java
public class Quiz{
    //Manejara flujo del juego
    // , cargar preguntas,
    // recibir respuestas
    LinkedList<Question> preguntasTrivia;//Almacenaremos todas las preguntas cargadas aqui
    public Quiz(){
        preguntasTrivia = new LinkedList<>();
    }
    public boolean cargarPreguntas(String path){//Clase encargada de leer un archivo en formato .txt
        //Para cargar las preguntas

                try {
                    File archivoLeido = new File(path);
                    Scanner scannerArchivo = new Scanner(archivoLeido);
                    while (scannerArchivo.hasNextLine()) {
                        String datos = scannerArchivo.nextLine();
                        System.out.println(datos);
                        String[] temporal = datos.split(",");
                        Question lineaPregunta = new Question();
                        lineaPregunta.setDescripcion(temporal[0]);
                        lineaPregunta.setRespuesta1(temporal[1]);
                        lineaPregunta.setRespuesta2(temporal[2]);
                        lineaPregunta.setRespuesta3(temporal[3]);
                        lineaPregunta.setRespuesta4(temporal[4]);
                        lineaPregunta.setRespuestaCorrecta(Integer.parseInt(temporal[5]));
                        preguntasTrivia.add(lineaPregunta);
                    }
                    scannerArchivo.close();
                    return true;
                } catch (FileNotFoundException e) {
                    System.out.println("Por favor ingrese un path correcto");

                }
                return false;
    }
    public void imprimirPreguntas(LinkedList<Question> preguntas){
        //Clase que dado una lista de preguntas mostrara en consola la trivia para el usuario

    }
    public boolean recibirRespuesta(String opcionElegida){
        //Verificara si las entradas del usuario son validas
        Pattern patron = Pattern.compile("^[1-4]$");
        Matcher matcher = patron.matcher(opcionElegida);
        boolean matchFound = matcher.find();
        if(matchFound) {
            System.out.println("Opcion valida");
        } else {
            System.out.println("Opcion no valida");
        }
        return matchFound;
    }
}
```
### Pruebas Unitarias
Para las pruebas unitarias del primer sprint, validaremos principalmente 2 cosas, que se carguen correctamente las preguntas desde un archivo en los recursos
y la entrada valida del usuario
```java
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
```

##Sprint2
### Tareas
1. Ampliar la clase Quiz para incluir un sistema de puntuación que rastree las respuestas
correctas e incorrectas.
2. Implementar lógica para múltiples rondas de juego, permitiendo al juego continuar hasta
que se completen todas las preguntas.
3. Crear un mecanismo para terminar el juego una vez que se hayan respondido todas las
preguntas, y mostrar el resultado final al usuario.
4. Escribir pruebas unitarias para verificar la precisión del sistema de puntuación y la correcta
funcionalidad del flujo del juego.

### Clase Quiz
Modificamos el metodo imprimirPreguntas de la clase Quiz para realizar el juego de trivia y agregamos el atributo Puntuacion a la clase Quiz
```java
public int imprimirPreguntas(int[] respuestas) {
        //Clase que dado una lista de preguntas mostrara en consola la trivia para el usuario
        int i=0;
        while(!preguntasTrivia.isEmpty()) {
            Question pregunta = preguntasTrivia.pop();
            System.out.println(pregunta.descripcion);
            System.out.println("1) " + pregunta.getRespuesta1());
            System.out.println("2) " + pregunta.getRespuesta2());
            System.out.println("3) " + pregunta.getRespuesta3());
            System.out.println("4) " + pregunta.getRespuesta4());
            int alternativaCorrecta = pregunta.getRespuestaCorrecta();
            String respuesta = String.valueOf(respuestas[i]);
            if (recibirRespuesta(respuesta)) {//Validamos la entrada del usuario
                if (Integer.parseInt(respuesta) == alternativaCorrecta) {
                    System.out.println("Correcto!");
                    puntuacion+=1;
                } else {
                    System.out.println("Incorrecto, la respuesta correcta era: " + alternativaCorrecta);
                }
                i+=1;
            } else {
                preguntasTrivia.add(pregunta);//Si el usuario da un input invalido volvemos a intentar
            }
        }
        return terminarJuego();
    }
```
### Pruebas Unitarias
Para validar la puntuacion y que el juego termine correctamente creamos los 2 metodos en la clase QuizTest
```java
@Test
    void validarPuntuacionCorrecta(){
        //Arrange
        Quiz trivia = new Quiz();
        boolean pathValido = trivia.cargarPreguntas("/home/pcs5/aaa/CC3S2A/ExamenParcial/Ejercicio1/Sprint2/JuegoTrivia/src/main/resources/preguntas.txt");
        int[] respuestas = {1,4};
        int puntuacionCorrecta = 1;
        //Act
        int puntuacion = trivia.imprimirPreguntas(respuestas);
        //Assert
        assertEquals(puntuacionCorrecta,puntuacion);
    }
    @Test
    void validarJuegoConcluido(){
        //Arrange
        Quiz trivia = new Quiz();
        boolean pathValido = trivia.cargarPreguntas("/home/pcs5/aaa/CC3S2A/ExamenParcial/Ejercicio1/Sprint2/JuegoTrivia/src/main/resources/preguntas.txt");
        int[] respuestas = {1,2};
        boolean juegoTerminado = true;
        //Act
        int puntuacion = trivia.imprimirPreguntas(respuestas);
        boolean estadoJuego = trivia.triviaTerminada;
        //Assert
        assertEquals(juegoTerminado,estadoJuego);
    }
```

## Preguntas relacionadas al juego Trivia 
1. ¿Qué caracteriza a una metodología ágil y cómo se aplicaría al desarrollo del juego de trivia?
Describe las características principales como la iteración rápida, la adaptabilidad y la
colaboración, y explica cómo estas pueden mejorar el desarrollo y la entrega del juego.
Una metodología ágil esta caracterizada por la flexibilidad y capacidad de adaptarse a requisitos cambiantes, integración continua y la colaboración.
En el desarrollo del juego de trivia la separación de objetivos en sprints nos permite saber que metas tenemos que cumplir en cada fase del desarrollo del juego, esto nos facilita la integración continua y también nos permite tener claro un orden lo que facilitaría la colaboración con otros desarolladores si este fuera el caso.

2. Explica cómo el principio de entrega continua podría implementarse en el proyecto del juego
de trivia usando Gradle. Discute el uso de Gradle para automatizar compilaciones, pruebas y
despliegues, facilitando una integración y entrega continuas.

Gradle nos permite realizar pruebas unitarias y automatizadas, así como la compilación automática de estas, esto nos facilita la entrega continua en un proyecto al poder verificar el código en un ámbito de prueba antes de ser llevado a producción.

3. Describa el ciclo TDD y cómo se aplicaría a una nueva característica en el juego, como la
implementación del sistema de puntuación. Explica el ciclo de "Red-Green-Refactor" y cómo
utilizaría TDD para desarrollar y validar la lógica de puntuación del juego.

Primero realizariamos una prueba básica para el sistema de puntuación, como retorna 10. RED
Podríamos modificar la clase Quiz para que retorne esta puntuación. GREEN
Luego podríamos refactorizar para dada una lista de respuestas retorne la puntuación valida. REFACTOR

4. ¿Cuáles son los beneficios de utilizar TDD en el desarrollo de software y cómo ayuda a
prevenir regresiones en el juego de trivia?

El beneficio de utilizar TDD es que los ciclos de RGR son bastante útiles para poder retroalimentarme continuamente sobre lo que tiene que hacer mi código en base a como fallan las pruebas.

5. Proporciona un ejemplo de cómo podrías refactorizar un bloque de código del juego de
trivia para mejorar su mantenibilidad.
Podría refactorizar el método cargarPreguntas 
6. Explica la importancia de la refactorización en los sprints de desarrollo ágil y cómo se integra
en el proceso de TDD. Discute cómo la refactorización es una parte integral del ciclo de TDD
y cómo contribuye a la mejora continua del código en un entorno ágil.
7. Describe cómo JUnit 5 puede utilizarse para implementar pruebas parametrizadas en el
juego de trivia. Proporciona un ejemplo concreto. Explica la funcionalidad de las pruebas
parametrizadas en JUnit 5 y cómo se podría usar para probar diferentes casos de entrada
para validar la lógica del juego.
8. ¿Qué características nuevas introduce JUnit 5 que son particularmente útiles para proyectos
complejos como el juego de trivia?