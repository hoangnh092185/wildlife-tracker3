import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("Batman", "Endanger");
    assertEquals(true, testAnimal instanceof Animal);
  }
  @Test
  public void getAnimal_animalInstantiatesWithName_String() {
    Animal testAnimal = new Animal("Batman", "Endanger");
    assertEquals("Batman", testAnimal.getName());
  }

  @Test
  public void getEndanger_animalInstantiatesWithEndanger_String() {
    Animal testAnimal = new Animal("Batman", "Endanger");
    assertEquals("Endanger", testAnimal.getEndanger());
  }
  @Test
  public void equals_returnsTrueIfNameAndEmailAreSame_true() {
    Animal firstAnimal = new Animal("Batman", "Endanger");
    Animal anotherAnimal = new Animal("Batman", "Endanger");
    assertTrue(firstAnimal.equals(anotherAnimal));
  }

}
