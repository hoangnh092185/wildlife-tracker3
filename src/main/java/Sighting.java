import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Sighting {
  private int id;
  private String location;
  private int animalId;
  private int endangerAnimalId;

  public Sighting(String location, int animalId, int endangerAnimalId){
    this.location = location;
    this.animalId = animalId;
    this.endangerAnimalId = endangerAnimalId;
  }
  public int getId(){
    return id;
  }
  public String getLocation(){
    return location;
  }
  public int getAnimalId(){
    return animalId;
  }
  public int getEndangerAnimalId(){
    return endangerAnimalId;
  }
  public boolean isEndanger(){
    if (endanger == 0){
      return false;
    }return true;
  }
  @Override
  public boolean equals(Object otherSighting){
    if(!(otherSighting instanceof Sighting)){
      return false;
    }else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getLocation().equals(newSighting.getLocation()) && this.getAnimalId() == newSighting.getAnimalId() && this.getEndangerAnimalId() == newSighting.getEndangerAnimalId() && this.getId() == newSighting.getId();
    }
  }
  public static List<Sighting> all() {
    String sql = "SELECT * FROM sightings ORDER BY location";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql)
        .executeAndFetch(Sighting.class);
    }
  }
  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO sightings(location, animalId, endangerAnimalId) VALUES(:location, :animalId, :endangerAnimalId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("location", this.location)
        .addParameter("animalId", this.animalId)
        .addParameter("endangerAnimalId", this.endangerAnimalId)
        .executeAndFetch()
        .getkey();
    }
  }
  public static Sighting find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings WHERE id = :id";
      Sighting sighting = con.createQuery(sql)
        .addParameter(sql)
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
  public void update(String newLocation) {
    try(Connection con = DB.sql2o.open()){
      String sql = "UPDATE sightings SET location = :location WHERE id = :id";
      con.createQuery(sql)
      .addParameter("location", newLocation)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
  public static List<Animal> searchAnimals(String searchAnimals){
    try(Connection con = DB.sql2o.open()){
      String sql = ""

      return con.createQuery(sql)
        .addParameter("searchAnimals", searchAnimals)
        .executeAndFetch(Animal.class)
    }
  }
}
