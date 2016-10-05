import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.sql2o.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class Sighting {
  private int id;
  private String location;
  private int animalId;
  private String rangerName;
  private Timestamp timeSighted;

  public Sighting(String location, String rangerName, int animalId){
    this.location = location;
    this.animalId = animalId;
    this.rangerName = rangerName;
  }
  public int getId(){
    return id;
  }
  public String getLocation(){
    return location;
  }
  public String getRangerName(){
    return rangerName;
  }
  public int getAnimalId(){
    return animalId;
  }
  public Timestamp getTimeSighted(){
    return timeSighted;
  }

  @Override
  public boolean equals(Object otherSighting){
    if(!(otherSighting instanceof Sighting)){
      return false;
    }else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getLocation().equals(newSighting.getLocation()) &&
      this.getAnimalId() == newSighting.getAnimalId() &&
      this.getRangerName().equals(newSighting.getRangerName()) &&
      this.getId() == newSighting.getId();
    }
  }
  public static List<Sighting> all() {
    String sql = "SELECT * FROM sightings ORDER BY animalid";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql)
        .executeAndFetch(Sighting.class);
    }
  }
  public static List<Sighting> allEndanger() {
    String sql = "SELECT * FROM sightings, animals WHERE sightings.animalid = animals.id AND animals.type = 'endanger';";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql)
        .executeAndFetch(Sighting.class);
    }
  }
  // public List<Object> allEndanger() {
  //     List<Object> allAnimals = new ArrayList<Object>();
  //     try(Connection con = DB.sql2o.open()) {
  //       String sqlNon = "SELECT * FROM animals WHERE type='nonendanger';";
  //       List<NonEndangerAnimal> nonAnimals = con.createQuery(sqlNon)
  //         .executeAndFetch(NonEndangerAnimal.class);
  //       allAnimals.addAll(nonAnimals);
  //     }
  //     return allAnimals;
  // }
  // public static List<Sighting> allNonEndanger() {
  //   String sql = "SELECT * FROM sightings, animals WHERE sightings.animalid = animals.id AND animals.type = 'nonendanger';";
  //   try(Connection con = DB.sql2o.open()){
  //     return con.createQuery(sql)
  //       .executeAndFetch(Sighting.class);
  //   }
  // }
  public void save(){
    if (this.rangerName.length()<=0){
      throw new UnsupportedOperationException("Field Can't be empty");
    }
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO sightings(location, rangername, animalid, timesighted) VALUES(:location, :rangername, :animalid, now())";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("location", this.location)
        .addParameter("rangername", this.rangerName)
        .addParameter("animalid", this.animalId)
        .executeUpdate()
        .getKey();
    }
  }
  public static Sighting find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE id = :id";
      Sighting sighting = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Sighting.class);
        return sighting;
    }
  }
  public void delete() {
    try(Connection con = DB.sql2o.open()){
      String sql = "DELETE FROM sightings WHERE id = :id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
  public void updateSighting(String newLocation) {
    try(Connection con = DB.sql2o.open()){
      String sql = "UPDATE sightings SET location = :location WHERE id = :id";
      con.createQuery(sql)
      .addParameter("location", newLocation)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
  public List<Object> getAnimals() {
      List<Object> allAnimals = new ArrayList<Object>();

      try(Connection con = DB.sql2o.open()) {
        String sqlNon = "SELECT * FROM animals WHERE type='nonendanger';";
        List<NonEndangerAnimal> nonAnimals = con.createQuery(sqlNon)
          .executeAndFetch(NonEndangerAnimal.class);
        allAnimals.addAll(nonAnimals);

        String sqlEndanger = "SELECT * FROM animals WHERE type = 'endanger';";
        List<EndangerAnimal> endangerAnimals = con.createQuery(sqlEndanger)

          .executeAndFetch(EndangerAnimal.class);
          allAnimals.addAll(endangerAnimals);
        }
        return allAnimals;
    }
}
