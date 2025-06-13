package dashboards.dashboard.mentorDashboard.repository;

import dashboards.dashboard.mentorDashboard.model.Mentorship;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MentorshipRepository extends JpaRepository<Mentorship, Long> {
    List<Mentorship> findByMentorId(Long mentorId);
}



