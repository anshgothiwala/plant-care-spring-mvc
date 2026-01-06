package plantcare.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import plantcare.dao.FeedbackDao;
import plantcare.model.Feedback;
import plantcare.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    @Transactional
    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.getAllFeedbacks();
    }

    @Override
    @Transactional
    public Feedback getFeedbackById(int id) {
        return feedbackDao.getFeedbackById(id);
    }

    @Override
    @Transactional
    public void saveFeedback(Feedback feedback) {
        feedbackDao.saveFeedback(feedback);
    }

    @Override
    @Transactional
    public void updateFeedback(Feedback feedback) {
        feedbackDao.updateFeedback(feedback);
    }

    @Override
    @Transactional
    public void deleteFeedback(int id) {
        feedbackDao.deleteFeedback(id);
    }
}
