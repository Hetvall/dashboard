package dashboards.dashboard.adminDashboard.repository;

import dashboards.dashboard.adminDashboard.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
    List<Courses> findByNameContainingIgnoreCase(String name);
}
