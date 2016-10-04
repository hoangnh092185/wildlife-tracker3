import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class EndangerAnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void endangerEndangerAnimal_instantiatesCorrectly_true() {
    EndangerAnimal testEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Adult");
    assertEquals(true, testEndangerAnimal instanceof EndangerAnimal);
  }
  @Test
  public void getEndangerAnimal_endangerEndangerAnimalInstantiatesWithName_String() {
    EndangerAnimal testEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Adult");
    assertEquals("Batman", testEndangerAnimal.getName());
  }

  @Test
  public void getEndanger_endangerEndangerAnimalInstantiatesWithHealth_String() {
    EndangerAnimal testEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Adult");
    assertEquals("Healthy", testEndangerAnimal.getHealth());
  }
  @Test
  public void getEndanger_endangerEndangerAnimalInstantiatesWithAge_String() {
    EndangerAnimal testEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Adult");
    assertEquals("Adult", testEndangerAnimal.getAge());
  }
  @Test
  public void getEndanger_endangerEndangerAnimalInstantiatesWithType_String() {
    EndangerAnimal testEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Adult");
    assertEquals("endanger", testEndangerAnimal.getType());
  }
  @Test
  public void equals_returnsTrueIfNameAndEmailAreSame_true() {
    EndangerAnimal firstEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Adult");
    EndangerAnimal anotherEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Adult");
    assertTrue(firstEndangerAnimal.equals(anotherEndangerAnimal));
  }
  @Test
  public void save_insertsObjectIntoDatabase_endangerEndangerAnimal() {
  EndangerAnimal firstEndangerAnimal = new EndangerAnimal("Batman", "Poor", "Adult");
    firstEndangerAnimal.saveEndanger();
    assertTrue(EndangerAnimal.all().get(0).equals(firstEndangerAnimal));
  }
  @Test
  public void all_returnsAllInstancesOfEndangerAnimal_true() {
    EndangerAnimal firstEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Adult");
    firstEndangerAnimal.saveEndanger();
    EndangerAnimal secondEndangerAnimal = new EndangerAnimal("Robbin", "Poor", "New Born");
    secondEndangerAnimal.saveEndanger();
    assertEquals(true, EndangerAnimal.all().get(0).equals(firstEndangerAnimal));
    assertEquals(true, EndangerAnimal.all().get(1).equals(secondEndangerAnimal));
  }
  @Test
   public void save_assignsIdToObject() {
     EndangerAnimal testEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Poop");
     testEndangerAnimal.saveEndanger();
     EndangerAnimal savedEndangerAnimal = EndangerAnimal.all().get(0);
     assertEquals(testEndangerAnimal.getId(), savedEndangerAnimal.getId());
   }
   @Test
    public void find_returnsEndangerAnimalWithSameId_secondEndangerAnimal() {
      EndangerAnimal firstEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Adult");
      firstEndangerAnimal.saveEndanger();
      EndangerAnimal secondEndangerAnimal = new EndangerAnimal("Robbin", "nonEndanger", "Baby");
      secondEndangerAnimal.saveEndanger();
      assertEquals(EndangerAnimal.find(secondEndangerAnimal.getId()), secondEndangerAnimal);
    }

}
