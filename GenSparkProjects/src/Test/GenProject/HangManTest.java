package GenProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class HangManTest {

    HangMan hangMan;


    @BeforeEach
    void setup(){
        hangMan = new HangMan();

    }

    @Test
    void draw() {

        ArrayList<Character> testChars = new ArrayList<>();
        testChars.add('a');

        hangMan.draw(1,testChars, testChars);

    }

    @Test
    void getRandomWord() {
    }
}