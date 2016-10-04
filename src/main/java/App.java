import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request,response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template","templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/animal", (request,response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template","templates/animal.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/endanger-animal", (request,response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template","templates/endangerAnimal.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/wildlife-list", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template","templates/wildlifeList.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    post("/animal/new", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      Animal newAnimal = new Animal(request.queryParams("name"), "No");
      newAnimal.save();
      Sighting newSighting = new Sighting(request.queryParams("location"), request.queryParams("rangername"), newAnimal.getId());
      newSighting.save();
      model.put("template","templates/wildlifeList.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/endanger-animal", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      Animal newAnimal = new Animal(request.queryParams("name"), "Yes", request.queryParams("health"),request.queryParams("age"));
      newAnimal.save();
      // String newHealth = request.queryParams("health");
      // String newAge = request.queryParams("age");
      // newAnimal.updateAnimal(newHealth, newAge);
      Sighting newSighting = new Sighting(request.queryParams("location"), request.queryParams("rangername"), newAnimal.getId());
      newSighting.save();
      model.put("template","templates/wildlifeList.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
