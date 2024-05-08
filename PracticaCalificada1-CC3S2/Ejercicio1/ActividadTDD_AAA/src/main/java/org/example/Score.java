package org.example;

public class Score {
    String word;
    String intento;
    public Score(String correctWord, String intento){
        this.word = correctWord;
        this.intento = intento;
    }
    public String letter(int position) {
        if(word.contains(intento)){
            if(word.length() > position ){
                return Letter.CORRECT;
            }
            else{
                return Letter.PART_CORRECT;
            }
        }
        else{
            return Letter.INCORRECT;
        }
    }
}