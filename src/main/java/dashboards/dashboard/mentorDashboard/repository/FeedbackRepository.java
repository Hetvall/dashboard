package dashboards.dashboard.mentorDashboard.repository;

import dashboards.dashboard.mentorDashboard.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
