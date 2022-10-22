package esprit.codegeeks.elearningfeedbackservice.controller;

import esprit.codegeeks.elearningfeedbackservice.domain.Feedback;
import esprit.codegeeks.elearningfeedbackservice.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;
    @PostMapping
    public Feedback addFeedback(@RequestBody Feedback feedback){
        return feedbackService.addFeedback(feedback);
    }

    @GetMapping
    public List<Feedback> getAll(){
        return feedbackService.getAll();
    }


    @DeleteMapping("/{id}")
    public List<Feedback>  removeFeedback(@PathVariable long id){
        feedbackService.deleteFeedback(id);
        return feedbackService.getAll();
    }



}
