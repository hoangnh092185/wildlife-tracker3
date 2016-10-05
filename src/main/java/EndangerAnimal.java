import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class EndangerAnimal extends Animal {

  private String health;
  private String age;

  public static final String DATABASE_TYPE = "endanger";

  public static final String HEALTH_LEVEL_1 = "Poor";
  public static final String HEALTH_LEVEL_2 = "Good";
  public static final String HEALTH_LEVEL_3 = "Healthy";

  public static final String AGE_LEVEL_1 = "New Born";
  public static final String AGE_LEVEL_2 = "Young";
  public static final String AGE_LEVEL_3 = "Adult";

  public EndangerAnimal(String _name, String _health, String _age) {
    name = _name;
    health = _health;
    age = _age;
    type = DATABASE_TYPE;
  }

  public String getHealth(){
    return health;
  }
  public String getAge(){
    return age;
  }

  public static List<EndangerAnimal> all() {
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM animals WHERE type = 'endanger';";
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(EndangerAnimal.class);
    }
  }

  public void saveEndanger() {
    
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO animals (name, health, age, type) VALUES (:name, :health, :age, :type)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("health", this.health)
        .addParameter("age", this.age)
        .addParameter("type", type)
        .throwOnMappingFailure(false)
        .executeUpdate()
        .getKey();
    }
  }
  public static EndangerAnimal find(int _id){
    try(Connection con = DB.sql2o.open()){
    String sql = "SELECT * FROM animals where id=:id";
      EndangerAnimal endanger = con.createQuery(sql)
        .addParameter("id", _id)
        .executeAndFetchFirst(EndangerAnimal.class);
        return endanger;
      }
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
}
