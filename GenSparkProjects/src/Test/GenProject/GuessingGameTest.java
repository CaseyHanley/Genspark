package GenProject;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessingGameTest {

    GuessingGame theGame;
    @BeforeEach
    void setUp() {

        theGame= new GuessingGame();

    }

    @Test
    void game() {


        theGame.guessTheNumber = theGame.randNumGen();
        theGame.guessedNum = 4;
        theGame.turn = 3;
        theGame.guess("test");

    }
}