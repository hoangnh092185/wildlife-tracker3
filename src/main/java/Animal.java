import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public abstract class Animal {
  public String name;
  public String type;
  public int id;


  public String getName(){
    return name;
  }
  public String getType(){
    return type;
  }
  public int getId(){
    return id;
  }

  public List<Sighting> getSighting(){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM sightings where animalId=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Sighting.class);
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
  public void updateAnimal(String newHealth, String newAge) {
    try(Connection con = DB.sql2o.open()){
      String sql = "UPDATE animals SET health = :name, age = :age WHERE id = :id";
      con.createQuery(sql)
      .addParameter("health", newHealth)
      .addParameter("age", newAge)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
  @Override
  public boolean equals(Object otherAnimal){
    if(!(otherAnimal instanceof Animal)){
      return false;
    }else {
      Animal newAnimal = (Animal) otherAnimal;
      return this.getName().equals(newAnimal.getName()) &&
              this.getType().equals(newAnimal.getType()) &&
        this.getId() == newAnimal.getId();
    }
  }

}
