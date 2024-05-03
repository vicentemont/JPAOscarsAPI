package io.vicente.app.rest.controllers;

import io.vicente.app.rest.model.Oscar;
import io.vicente.app.rest.persistence.MovieRepo;
import io.vicente.app.rest.persistence.OscarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private OscarRepo oscarRepo;

    @Autowired
    private MovieRepo movieRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/oscars/search")
    public List<Oscar> findOscars(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String tmdb_id,
            @RequestParam(required = false) String imdb_id,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String year
    ) {
        if (title != null) {
            // Search by movie title
            return oscarRepo.findByMovieTitle(title);
        } else if (tmdb_id != null) {
            // Search by TMDB ID
            return oscarRepo.findByMovieTMDBId(tmdb_id);
        } else if (imdb_id != null) {
            // Search by IMDB ID
            return oscarRepo.findByMovieIMDBId(imdb_id);
        } else if (category != null) {
            // Search by IMDB ID
            return oscarRepo.findByCategory(category);
        } else if (year != null) {
            // Search by IMDB ID
            return oscarRepo.findByYear(year);
        } else {
            // If no parameter is provided, return an empty list or handle the error
            return List.of(); // You can also throw an exception or return a custom response
        }
    }

    @PostMapping(value = "/addOscar")
    public String setOscar(@RequestBody Oscar oscar){
        oscarRepo.save(oscar);
        return "oscar added...";

    }

    @PostMapping(value = "/addOscarList")
    public String setOscar(@RequestBody List<Oscar> oscarList){
        oscarRepo.saveAll(oscarList);
        return "oscar list was added...";

    }

    @PutMapping(value = "/editOscar")
    public String editOscar(@RequestBody Oscar oscar){
        oscarRepo.save(oscar);
        return "oscar updated...";
    }

    @DeleteMapping(value = "/deleteOscar")
    public String deleteOscar(@RequestBody long oscarToDeleteId){
        oscarRepo.deleteById(oscarToDeleteId);
        return "oscar " + oscarToDeleteId + " deleted...";
    }


}
