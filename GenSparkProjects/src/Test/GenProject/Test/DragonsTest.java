package GenProject.Test;

import GenProject.Dragons;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DragonsTest {

    Dragons dragon;

    @BeforeEach
    void setUp() {
        dragon = new Dragons();

    }

    @Test
    void dragonsCave() {
        dragon.answer = 1;
        dragon.DragonsCave();
    }
}