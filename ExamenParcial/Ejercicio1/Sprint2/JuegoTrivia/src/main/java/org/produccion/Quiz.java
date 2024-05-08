package org.produccion;
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