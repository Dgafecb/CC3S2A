package org.example;

public class Word {
    String word;
        public Word(String correctWord) {//Asignamos la palabra correcta
            word = correctWord;
        }
        public Score guess(String intento) {//Enviamos la letra que intenta adivinar de la palabra
            Score score = new Score(word,intento);
            return score;
        }
    }
