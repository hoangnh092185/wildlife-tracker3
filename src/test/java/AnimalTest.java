import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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
  @Test
  public void save_insertsObjectIntoDatabase_animal() {
    Animal firstAnimal = new Animal("Batman", "Endanger");
    firstAnimal.save();
    assertTrue(Animal.all().get(0).equals(firstAnimal));
  }
  @Test
  public void all_returnsAllInstancesOfAnimal_true() {
    Animal firstAnimal = new Animal("Batman", "Endanger");
    firstAnimal.save();
    Animal secondAnimal = new Animal("Robbin", "nonEndanger");
    secondAnimal.save();
    assertEquals(true, Animal.all().get(0).equals(firstAnimal));
    assertEquals(true, Animal.all().get(1).equals(secondAnimal));
  }
  @Test
   public void save_assignsIdToObject() {
     Animal testAnimal = new Animal("Batman", "Endanger");
     testAnimal.save();
     Animal savedAnimal = Animal.all().get(0);
     assertEquals(testAnimal.getId(), savedAnimal.getId());
   }
   @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
      Animal firstAnimal = new Animal("Batman", "Endanger");
      firstAnimal.save();
      Animal secondAnimal = new Animal("Robbin", "nonEndanger");
      secondAnimal.save();
      assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

}
