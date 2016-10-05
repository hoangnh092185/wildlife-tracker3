import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class SightingTest{

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void sighting_instantiatesCorrectly_true() {
    Sighting testSighting = new Sighting("Area 51", "Ranger ET", 1);
    assertEquals(true, testSighting instanceof Sighting);
  }
  @Test
  public void getLocation_sightingInstantiatesWithName_String() {
    Sighting testSighting = new Sighting("Area 51", "Ranger ET", 1);
    assertEquals("Area 51", testSighting.getLocation());
  }
  @Test
  public void getRangerName_sightingInstantiatesWithEndanger_String() {
    Sighting testSighting = new Sighting("Area 51", "Ranger ET", 1);
    assertEquals("Ranger ET", testSighting.getRangerName());
  }
  @Test
    public void getAnimalId_sightingInstantiatesWithEndanger_int() {
      Sighting testSighting = new Sighting("Area 51", "Ranger ET", 1);
      assertEquals(1, testSighting.getAnimalId());
    }
  @Test
  public void equals_returnsTrueIfNameAndEmailAreSame_true() {
    Sighting firstSighting = new Sighting("Area 51", "Ranger ET", 1);
    Sighting anotherSighting = new Sighting("Area 51", "Ranger ET", 1);
    assertTrue(firstSighting.equals(anotherSighting));
  }
  @Test(expected = UnsupportedOperationException.class)
  public void saveThrow_insertsObjectIntoDatabase_CatchName() {
    Sighting firstSighting = new Sighting("Area 51","", 1);
    firstSighting.save();
    // assertTrue(Sighting.all().get(0).equals(firstSighting));
  }
  @Test
  public void save_insertsObjectIntoDatabase_sighting() {
    Sighting firstSighting = new Sighting("Area 51","Ranger ET", 1);
    firstSighting.save();
    assertTrue(Sighting.all().get(0).equals(firstSighting));
  }
  @Test
  public void all_returnsAllInstancesOfSighting_true() {
    Sighting firstSighting = new Sighting("Area 51", "Ranger ET", 1);
    firstSighting.save();
    Sighting secondSighting = new Sighting("My Backyard", "Ranger Nemo", 1);
    secondSighting.save();
    assertEquals(true, Sighting.all().get(0).equals(firstSighting));
    assertEquals(true, Sighting.all().get(1).equals(secondSighting));
  }
  @Test
   public void save_assignsIdToObject() {
     Sighting testSighting = new Sighting("Area 51", "Ranger ET", 1);
     testSighting.save();
     Sighting savedSighting = Sighting.all().get(0);
     assertEquals(testSighting.getId(), savedSighting.getId());
   }
   @Test
    public void find_returnsSightingWithSameId_secondSighting() {
      Sighting firstSighting = new Sighting("Area 51", "Ranger ET", 1);
      firstSighting.save();
      Sighting secondSighting = new Sighting("My Backyard", "Ranger Nemo", 1);
      secondSighting.save();
      assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
    }
    @Test
    public void getAnimals_retrievesAllAnimalsFromDatabase_animalsList() {
      Sighting firstSighting = new Sighting("Area 51", "Ranger ET", 1);
      firstSighting.save();
      NonEndangerAnimal firstNonEndangerAnimal = new NonEndangerAnimal("Batman");
      firstNonEndangerAnimal.saveNon();
      EndangerAnimal firstEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Adult");
      firstEndangerAnimal.saveEndanger();
      Object[] animals = new Object[] {firstNonEndangerAnimal, firstEndangerAnimal };
      assertTrue(firstSighting.getAnimals().containsAll(Arrays.asList(animals)));
    }
    // @Test
    // public void allEndanger_retrievesAllAnimalsFromDatabase_animalsList() {
    //   EndangerAnimal firstEndangerAnimal = new EndangerAnimal("Batman", "Healthy", "Adult");
    //   firstEndangerAnimal.saveEndanger();
    //   Sighting firstSighting = new Sighting("Area 51", "Ranger ET", firstEndangerAnimal.getId());
    //   firstSighting.save();
    //   assertEquals(Sighting.find(firstSighting.getAnimalId()), firstEndangerAnimal.getId());
    // }

}
