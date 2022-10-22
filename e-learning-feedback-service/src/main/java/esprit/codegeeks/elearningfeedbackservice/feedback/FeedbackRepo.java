package esprit.codegeeks.elearningfeedbackservice.feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepo  extends JpaRepository<Feedback,Long> {
    List<Feedback> findFeedbacksByCourse_id(Long course_id);
}
