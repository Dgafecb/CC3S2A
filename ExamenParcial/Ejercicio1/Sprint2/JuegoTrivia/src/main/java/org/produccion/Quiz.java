package org.produccion;
import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quiz{
    //Manejara flujo del juego
    // , cargar preguntas,
    // recibir respuestas
    public LinkedList<Question> preguntasTrivia;//Almacenaremos todas las preguntas cargadas aqui
    public int puntuacion =0;
    public boolean triviaTerminada = false;
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
    public void imprimirPreguntas(){
        //Clase que dado una lista de preguntas mostrara en consola la trivia para el usuario
        while(!preguntasTrivia.isEmpty()) {
            Question pregunta = preguntasTrivia.pop();
            System.out.println(pregunta.descripcion);
            System.out.println("1) " + pregunta.getRespuesta1());
            System.out.println("2) " + pregunta.getRespuesta2());
            System.out.println("3) " + pregunta.getRespuesta3());
            System.out.println("4) " + pregunta.getRespuesta4());
            int alternativaCorrecta = pregunta.getRespuestaCorrecta();
            Scanner scanner = new Scanner(System.in);
            String respuesta = scanner.nextLine();
            if (recibirRespuesta(respuesta)) {//Validamos la entrada del usuario
                if (Integer.parseInt(respuesta) == alternativaCorrecta) {
                    System.out.println("Correcto!");
                    puntuacion+=1;
                } else {
                    System.out.println("Incorrecto, la respuesta correcta era: " + alternativaCorrecta);
                }
            } else {
                preguntasTrivia.add(pregunta);//Si el usuario da un input invalido volvemos a intentar
            }
        }
        terminarJuego();
    }
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
    public int terminarJuego(){
        triviaTerminada=true;
        //Una vez terminada las preguntas se mostrara la puntuacion obtenida
        System.out.println("Tu puntuacion final es: "+puntuacion);
        System.out.println("Juego terminado");
        return puntuacion;
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