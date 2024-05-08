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