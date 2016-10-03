// import org.junit.*;
// import org.sql2o.*;
// import java.sql.Timestamp;
// import java.util.Date;
// import java.text.DateFormat;
//
//
// public class EndangerAnimal extends Animal {
//   private String name;
//   private String health;
//   private String age;
//   private int id;
//   // public static final String Database_TYPE = "endanger";
//
//   public EndangerAnimal(String name, String health, String age) {
//     this.name = name;
//     this.health = health;
//     this.age = age;
//   }
//
//   public String getName(){
//     return name;
//   }
//   public String getHealth(){
//     return health;
//   }
//   public String age(){
//     return age;
//   }
//   public int getId(){
//     return id;
//   }
//   @Override
//   public boolean equals(Object otherEndangerAnimal){
//     if(!(otherEndangerAnimal instanceof EndangerAnimal)){
//       return false;
//     }else {
//       EndangerAnimal newEndangerAnimal = (EndangerAnimal) otherEndangerAnimal;
//       return this.getName().equals(newEndangerAnimal.getName()) &&
//               this.getHealth().equals(newEndangerAnimal.getHealth()) &&
//               this.getAge().equals(newEndangerAnimal.getAge()) &&
//               this.getId() == newEndangerAnimal.getId();
//     }
//   }
//   public static List<EndangerAnimal> all() {
//     String sql = "SELECT * FROM animals";
//     try(Connection con = DB.sql2o.open()){
//       return con.createQuery(sql).executeAndFetch(EndangerAnimal.class);
//     }
//   }
//   public List<Sighting> getSighting(){
//     try(Connection con = DB.sql2o.open()){
//       String sql = "SELECT * FROM sightings where animalId=:id";
//       return con.createQuery(sql)
//         .addParameter("id", this.id)
//         .executeAndFetch(Sighting.class);
//     }
//   }
//   public static EndangerAnimal find (int _id){
//     try(Connection con = DB.sql2o.open()){
//       String sql = "SELECT * FROM animals where id=:id";
//       Animal animal = con.createQuery(sql)
//         .addParameter("id", _id)
//         .executeAndFetchFirst(EndangerAnimal.class);
//         return animal;
//       }
//   }
//   public void save() {
//     try(Connection con = DB.sql2o.open()){
//       String sql = "INSERT INTO animals(name, endanger) VALUES(:name, :endanger)";
//       this.id = (int) con.createQuery(sql, true)
//         .addParameter("name", this.name)
//         .addParameter("endanger", this.endanger)
//         .executeUpdate()
//         .getKey();
//     }
//   }
//   public void delete () {
//     try(Connection con = DB.sql2o.open()){
//       String sql = "DELETE FROM animals WHERE id=:id";
//       con.createQuery(sql)
//       .addParameter("id", id)
//       .executeUpdate();
//     }
//   }
//   public void update(String newName, String newEndanger) {
//     try(Connection con = DB.sql2o.open()){
//       String sql = "UPDATE animals SET name = :name, endanger = :endanger WHERE id = :id";
//       con.createQuery(sql)
//       .addParameter("name", newName)
//       .addParameter("endanger", newEndanger)
//       .addParameter("id", id)
//       .executeUpdate();
//     }
//   }
//
// }
