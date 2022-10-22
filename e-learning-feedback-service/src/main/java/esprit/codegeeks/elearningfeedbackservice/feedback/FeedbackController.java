package esprit.codegeeks.elearningfeedbackservice.feedback;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final feedbackService feedbackService;
    @PostMapping
    public Feedback addFeedback(@RequestBody Feedback feedback){
        return feedbackService.save(feedback);
    }

    @GetMapping
    public List<Feedback> getAll(){
        return feedbackService.findAll();
    }

    @GetMapping("/{course_id}")
    public List<Feedback> findAllByNoteIs(@PathVariable (value = "course_id") Long course_id){
        return feedbackService.findAllByNoteIs(course_id);
    }
    @DeleteMapping("/{id}")
    public List<Feedback>  removeFeedback(@PathVariable long id){
        feedbackService.deleteFeedback(id);
        return feedbackService.findAll();
    }



}
