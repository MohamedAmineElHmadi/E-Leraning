package esprit.codegeeks.elearningfeedbackservice.repository;
import esprit.codegeeks.elearningfeedbackservice.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Long> {

}

