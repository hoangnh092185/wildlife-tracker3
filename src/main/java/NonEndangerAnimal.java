import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class NonEndangerAnimal extends Animal {

  public static final String DATABASE_TYPE = "nonendanger";

  public NonEndangerAnimal(String _name) {
    name = _name;
    type = DATABASE_TYPE;
  }

  public String getName(){
    return name;
  }
  public void saveNon() {
    
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO animals(name, type) VALUES(:name, :type)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("type", type)
        .throwOnMappingFailure(false)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<NonEndangerAnimal> all() {
    String sql = "SELECT * FROM animals WHERE type='nonendanger';";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql)
      .throwOnMappingFailure(false)
      .executeAndFetch(NonEndangerAnimal.class);
    }
  }
  public static NonEndangerAnimal find(int _id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where id=:id";
      NonEndangerAnimal nonendanger = con.createQuery(sql)
        .addParameter("id", _id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(NonEndangerAnimal.class);
    return nonendanger;
    }
  }
}
