import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class EndangerAnimal extends Animal {
  private String name;
  private String health;
  private String age;

  public static final String DATABASE_TYPE = "endanger";

  public static final String Health_Level_1 = "Poor";
  public static final String Health_Level_2 = "Good";
  public static final String Health_Level_3 = "Healthy";

  public static final String Age_Level_1 = "New Born";
  public static final String Age_Level_2 = "Young";
  public static final String Age_Level_3 = "Adult";

  public EndangerAnimal(String _name, String _health, String _age) {
    name = _name;
    health = _health;
    age = _age;
    type = DATABASE_TYPE;
  }

  public String getName(){
    return name;
  }
  public String getHealth(){
    return health;
  }
  public String getAge(){
    return age;
  }
  public int getId(){
    return id;
  }
  @Override
  public boolean equals(Object otherEndangerAnimal){
    if(!(otherEndangerAnimal instanceof EndangerAnimal)){
      return false;
    }else {
      EndangerAnimal newEndangerAnimal = (EndangerAnimal) otherEndangerAnimal;
      return this.getName().equals(newEndangerAnimal.getName()) &&
              this.getHealth().equals(newEndangerAnimal.getHealth()) &&
              this.getAge().equals(newEndangerAnimal.getAge()) &&
              this.getId() == newEndangerAnimal.getId();
    }
  }

  public static List<EndangerAnimal> allEndanger() {
    String sql = "SELECT * FROM animals WHERE type='endanger';";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(EndangerAnimal.class);
    }
  }
  // public List<Sighting> getSighting(){
  //   try(Connection con = DB.sql2o.open()){
  //     String sql = "SELECT * FROM sightings where animalId=:id";
  //     return con.createQuery(sql)
  //       .addParameter("id", this.id)
  //       .executeAndFetch(Sighting.class);
  //   }
  // }
  // public static EndangerAnimal find(int id){
  //   try(Connection con = DB.sql2o.open()){
  //     String sql = "SELECT * FROM animals where type = 'endanger';";
  //     Animal animal = con.createQuery(sql)
  //       .addParameter("id", id)
  //       .executeAndFetchFirst(EndangerAnimal.class);
  //       return animal;
  //     }
  // }
  @Override
  public void save() {
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO animals(name, health, age, type) VALUES(:name, :health, :age, :type)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("health", this.health)
        .addParameter("age", this.age)
        .addParameter("type", type)
        .executeUpdate()
        .getKey();
    }
  }
  public void delete () {
    try(Connection con = DB.sql2o.open()){
      String sql = "DELETE FROM animals WHERE id=:id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
  public void update(String newName, String newEndanger) {
    try(Connection con = DB.sql2o.open()){
      String sql = "UPDATE animals SET name = :name, endanger = :endanger WHERE id = :id";
      con.createQuery(sql)
      .addParameter("name", newName)
      .addParameter("endanger", newEndanger)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

}
