package dashboards.dashboard.mentorDashboard.repository;

import dashboards.dashboard.mentorDashboard.model.MentorUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<MentorUsers, Long> {
    List<MentorUsers> findByIdIn(List<Long> ids);
}
