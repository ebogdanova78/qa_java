import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AnimalKindTest  {
    private final String ANIMALKIND;

    public AnimalKindTest (String animalKind) {
        this.ANIMALKIND = animalKind;
    }

    @Parameterized.Parameters
    public static Object[] invalidAnimalKind() {
        return new Object[]{
                "Не хищник",
                "Не травоядное",
                "Неопределенное"
        };
    }

    @Test(expected = Exception.class)
    public void getInvalidAnimalKind() throws Exception {
        Feline feline = new Feline();
        feline.getFood(ANIMALKIND);
    }
}
