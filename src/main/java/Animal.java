import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;


public class Animal {
  private String name;
  private String endanger;
  private int id;

  public Animal(String name, String endanger) {
    this.name = name;
    this.endanger = endanger;
  }

  public String getName(){
    return name;
  }
  public String getEndanger(){
    return endanger;
  }
  public int getId(){
    return id;
  }
  @Override
  public boolean equals(Object otherAnimal){
    if(!(otherAnimal instanceof Animal)){
      return false;
    }else {
      Animal newAnimal = (Animal) otherAnimal;
      return this.getName().equals(newAnimal.getName()) &&
              this.getEndanger().equals(newAnimal.getEndanger()) &&
        this.getId() == newAnimal.getId();
    }
  }
  public static List<Animal> all() {
    String sql = "SELECT * FROM animals";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(Animal.class);
    }
  }
  public List<Sighting> getSighting(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings where animalId=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Sighting.class);
    }
  }
  public static Animal find (int _id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals where id=:id";
      Animal animal = con.createQuery(sql)
        .addParameter("id", _id)
        .executeAndFetchFirst(Animal.class);
        return animal;
      }
  }
  public void save() {
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO animals(name, endanger, health, age) VALUES(:name, :endanger, :health, :age)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("endanger", this.endanger)
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
