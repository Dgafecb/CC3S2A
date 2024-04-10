package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    @Test
    public void oneIncorrectLetter() {
        Word word = new Word("A");
        Score score = word.guess("Z");
        String result = score.letter(0);
        assertThat(result).isEqualTo(Letter.INCORRECT);

    }
}