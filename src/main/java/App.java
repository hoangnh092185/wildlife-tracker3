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

    get("/nonendanger", (request,response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template","templates/animal.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/endanger", (request,response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template","templates/endangerAnimal.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  // get("/wildlife-list", (request,response) ->{
  //     Map<String, Object> model = new HashMap<String, Object>();
  //     model.put("animals", )
  //     model.put("template","templates/wildlifeList.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());

    get("/wildlife-list", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("template","templates/wildlifeList.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    post("/nonendanger", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      NonEndangerAnimal newNonEndanger = new NonEndangerAnimal(request.queryParams("name"));
      newNonEndanger.save();
      Sighting newSighting = new Sighting(request.queryParams("location"), request.queryParams("rangername"), newNonEndanger.getId());
      newSighting.save();
      model.put("animals", NonEndangerAnimal.all());
      response.redirect("/wildlife-list");
      // model.put("template","templates/wildlifeList.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/endanger-animal", (request, response)->{
      Map<String, Object> model = new HashMap<String, Object>();
      EndangerAnimal newEndanger = new EndangerAnimal(request.queryParams("name"), request.queryParams("health"),request.queryParams("age"));
      newEndanger.saveDatabase();
      Sighting newSighting = new Sighting(request.queryParams("location"), request.queryParams("rangername"), newEndanger.getId());
      newSighting.save();
      model.put("template","templates/wildlifeList.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
