import models.Place;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //get: show new post form
        get("/places/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "place-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new post form
        post("/places/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name"); //comes from form!
            String weather = request.queryParams("weather");
            String stayLength = request.queryParams("stayLength");
            String grade = request.queryParams("grade");
            Place newPlace = new Place(name, weather, stayLength, grade);
            model.put("place", newPlace);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show all posts
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Place> places = Place.getAll();
            model.put("places", places);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual post
        get("/places/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPlaceToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Place foundPlace = Place.findById(idOfPlaceToFind); //use it to find post
            model.put("place", foundPlace); //add it to model for template to display
            return new ModelAndView(model, "place-detail.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());

    }
}
