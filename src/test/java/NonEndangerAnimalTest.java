import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class NonEndangerAnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    NonEndangerAnimal testNonEndangerAnimal = new NonEndangerAnimal("Batman");
    assertEquals(true, testNonEndangerAnimal instanceof NonEndangerAnimal);
  }
  @Test
  public void getNonEndangerAnimal_animalInstantiatesWithName_String() {
    NonEndangerAnimal testNonEndangerAnimal = new NonEndangerAnimal("Batman");
    assertEquals("Batman", testNonEndangerAnimal.getName());
  }
  @Test
  public void getNonEndangerAnimal_animalInstantiatesWithType_String() {
    NonEndangerAnimal testNonEndangerAnimal = new NonEndangerAnimal("Batman");
    assertEquals("nonendanger", testNonEndangerAnimal.getType());
  }

  @Test
  public void equals_returnsTrueIfNameAndTypeAreSame_true() {
    NonEndangerAnimal firstNonEndangerAnimal = new NonEndangerAnimal("Batman");
    NonEndangerAnimal anotherNonEndangerAnimal = new NonEndangerAnimal("Batman");
    assertTrue(firstNonEndangerAnimal.equals(anotherNonEndangerAnimal));
  }
  @Test(expected = UnsupportedOperationException.class)
  public void throw_insertsObjectIntoDatabase_Catch() {
    NonEndangerAnimal firstNonEndangerAnimal = new NonEndangerAnimal("");
    firstNonEndangerAnimal.saveNon();
    // assertTrue(NonEndangerAnimal.all().get(0).equals(firstNonEndangerAnimal));
  }
  @Test
  public void save_insertsObjectIntoDatabase_animal() {
    NonEndangerAnimal firstNonEndangerAnimal = new NonEndangerAnimal("Batman");
    firstNonEndangerAnimal.saveNon();
    assertTrue(NonEndangerAnimal.all().get(0).equals(firstNonEndangerAnimal));
  }
  @Test
  public void allNonEndanger_returnsAllInstancesOfNonEndangerAnimal_true() {
    NonEndangerAnimal firstNonEndangerAnimal = new NonEndangerAnimal("Batman");
    firstNonEndangerAnimal.saveNon();
    NonEndangerAnimal secondNonEndangerAnimal = new NonEndangerAnimal("Robbin");
    secondNonEndangerAnimal.saveNon();
    assertEquals(true, NonEndangerAnimal.all().get(0).equals(firstNonEndangerAnimal));
    assertEquals(true, NonEndangerAnimal.all().get(1).equals(secondNonEndangerAnimal));
  }
  @Test
   public void save_assignsIdToObject() {
     NonEndangerAnimal testNonEndangerAnimal = new NonEndangerAnimal("Batman");
     testNonEndangerAnimal.saveNon();
     NonEndangerAnimal savedNonEndangerAnimal = NonEndangerAnimal.all().get(0);
     assertEquals(testNonEndangerAnimal.getId(), savedNonEndangerAnimal.getId());
   }
   @Test
    public void find_returnsNonEndangerAnimalWithSameId_secondNonEndangerAnimal() {
      NonEndangerAnimal firstNonEndangerAnimal = new NonEndangerAnimal("Batman");
      firstNonEndangerAnimal.saveNon();
      NonEndangerAnimal secondNonEndangerAnimal = new NonEndangerAnimal("Robbin");
      secondNonEndangerAnimal.saveNon();
      assertEquals(NonEndangerAnimal.find(secondNonEndangerAnimal.getId()), secondNonEndangerAnimal);
    }

}
