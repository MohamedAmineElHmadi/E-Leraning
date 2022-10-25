package esprit.codegeeks.elearningmicroservice.controller;

import esprit.codegeeks.elearningmicroservice.domain.Rating;
import esprit.codegeeks.elearningmicroservice.service.IRatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin("*")
@RequestMapping("/rating")
@RequiredArgsConstructor
@Slf4j
public class RatingController {

    private final IRatingService ratingService;

    @CrossOrigin("*")
    @GetMapping("/list")
    public String test() {
        return "hello";
    }
    @GetMapping("/course/{courseid}")
    public Integer getRatingForCourse(@PathVariable("courseid") Long courseid){
      return ratingService.getCoursesRating(courseid);

    }

    @CrossOrigin("*")
    @GetMapping("/{id}")
    public Rating getRating(@PathVariable("id") Long id) throws Exception {

        return ratingService.getRatingById(id).orElseThrow(()->new Exception("Personne n'existe pas"));

    }

    @CrossOrigin("*")
    @GetMapping
    public List<Rating> getRatings(){
        return ratingService.getratings();
    }

    @CrossOrigin("*")
    @PostMapping()
    public Rating addRating(@RequestBody Rating rating){
      return   ratingService.addRating(rating);
    }

    @CrossOrigin("*")
    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable("id") Long id){
        ratingService.deleteRating(id);
    }
}


