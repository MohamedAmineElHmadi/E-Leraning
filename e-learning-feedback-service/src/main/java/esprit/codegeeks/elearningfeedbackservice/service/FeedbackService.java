package esprit.codegeeks.elearningfeedbackservice.service;

import esprit.codegeeks.elearningfeedbackservice.domain.Feedback;
import esprit.codegeeks.elearningfeedbackservice.repository.FeedbackRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FeedbackService {

  private final FeedbackRepo feedbackRepo;

    public Feedback addFeedback(Feedback feedback){
        return feedbackRepo.save(feedback);
    }
    public List<Feedback> getAll(){
        return feedbackRepo.findAll();
    }

    public Feedback getFeedbackById(long id){
        return feedbackRepo.findById(id).get();
    }
    public void deleteFeedback(long id){
        feedbackRepo.deleteById(id);
    }


}
