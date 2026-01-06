package plantcare.service;

import java.util.List;
import plantcare.model.Feedback;

public interface FeedbackService {
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(int id);
    void saveFeedback(Feedback feedback);
    void updateFeedback(Feedback feedback);
    void deleteFeedback(int id);
}