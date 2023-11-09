import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FelineTest {

        Feline feline = new Feline();

        @Test
        public void getFamilyTest() {
            String expectedResult = "Кошачьи";
            String actualResult = feline.getFamily();
            assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", expectedResult, actualResult);
        }

        @Test
        public void predatorEatMeatTest() throws Exception {
            List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
            List<String> actualResult = feline.eatMeat();
            assertEquals("Некорректный результат вызова метода eatMeat", expectedResult, actualResult);
        }

        @Test
        public void felineGetFoodTest() throws Exception {
            List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
            List<String> actualResult = feline.getFood("Хищник");
            assertEquals("Некорректный результат вызова метода getFood", expectedResult, actualResult);
        }

        @Test
        public void getKittenTest() {
            int expectedResult = 1;
            int actualResult = feline.getKittens();
            assertEquals("Получено неправильное значение:", expectedResult, actualResult);
        }

        @Test
        public void getKittensTest() {
            int expectedResult = 3;
            int actualResult = feline.getKittens(3);
            assertEquals("Получено неправильное значение:", expectedResult, actualResult);
        }

        @Test(expected = Exception.class)
        public void undefinedAnimalKindTest() throws Exception {
            feline.getFood("Undefined");
        }

        @Test
        public void wrongGetFoodTest() throws Exception {
            List<String> expectedResult = List.of("Трава", "Различные растения");
            List<String> actualResult = feline.getFood("Травоядное");
            assertEquals("Получено неправильное значение", expectedResult, actualResult);
        }
}
