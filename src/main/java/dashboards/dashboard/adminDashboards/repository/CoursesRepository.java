package dashboards.dashboard.adminDashboards.repository;

import dashboards.dashboard.adminDashboards.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepository extends JpaRepository<dashboards.dashboard.adminDashboards.entity.Courses, Long> {
    List<Courses> findByNameContainingIgnoreCase(String name);
}