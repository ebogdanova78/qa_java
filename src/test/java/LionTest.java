import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void lionGetFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = lion.getFood();
        assertEquals("Некорректный результат вызова метода getFood", expectedResult, actualResult);
    }

    @Test
    public void lionGetKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedResult = 1;
        int actualResult = lion.getKittens();
        assertEquals("Некорректный результат вызова метода getKittens", expectedResult, actualResult);
    }


    @Test
    public void lionDoesHaveManeTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actualResult = lion.doesHaveMane();
        assertTrue("Некорректое значение", actualResult);
    }

    @Test
    public void lionDoesHaveWrongManeTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean actualResult = lion.doesHaveMane();
        assertFalse("Некорректое значение свойства", actualResult);
    }

    /*@Test(expected = Exception.class)
    public void lionDoesHaveUndefinedManeTest() throws Exception {
        new Lion("Undefined", feline);
    }*/

    @Test
    public void lionDoesHaveUndefinedManeTest() {
        assertThrows(Exception.class, () -> {new Lion("Undefined", feline);
        });
    }
}