package dashboards.dashboard.contentmanagement.repositories;

import dashboards.dashboard.contentmanagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Course, Long> {
}

