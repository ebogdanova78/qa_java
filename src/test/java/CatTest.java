import com.example.Cat;
import com.example.Feline;
import com.example.Animal;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void catGetSoundTest() {
        Cat cat = new Cat(new Feline());
        String expectedResult = "Мяу";
        String actualResult = cat.getSound();
        assertEquals("Некорректный результат вызова метода getSound", expectedResult, actualResult);
    }

    @Test
    public void catGetFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = cat.getFood();
        assertEquals("Некорректный результат вызова метода getFood", expectedResult, actualResult);
    }

    @Test
    public void catGetFamilyTest() {
        Cat cat = new Cat(feline);
        String expectedResult = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualResult = cat.getFamily();
        assertEquals("Некорректный результат вызова метода getFamily", expectedResult, actualResult);
    }
}
