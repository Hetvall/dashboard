package dashboards.dashboard.studentdashboard.repository;

import dashboards.dashboard.studentdashboard.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    // Si más adelante necesitas consultas personalizadas, las puedes agregar aquí
}