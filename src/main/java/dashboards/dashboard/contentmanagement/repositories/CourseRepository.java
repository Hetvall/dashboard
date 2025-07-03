package dashboards.dashboard.contentmanagement.repositories;

import dashboards.dashboard.contentmanagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
 //intentando si se puede borrar el findbyid, porque el JPA ya lo tiene por defecto
}
