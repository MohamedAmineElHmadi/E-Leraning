package esprit.codegeeks.elearningfeedbackservice.feedback;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class feedbackService {

    private final FeedbackRepo feedbackRepo;

    public Feedback save(Feedback feedback){
        return feedbackRepo.save(feedback);
    }
    public List<Feedback> findAll(){
        return feedbackRepo.findAll();
    }

    public Feedback findById(long id){
        return feedbackRepo.findById(id).get();
    }
    public void deleteFeedback(long id){
        feedbackRepo.deleteById(id);
    }

    public List<Feedback> findAllByNoteIs(Long course_id) {
     return    feedbackRepo.findFeedbacksByCourse_id(course_id);
    }
}
