package dashboards.dashboard.studentdashboard.service;

import dashboards.dashboard.studentdashboard.model.Grade;
import dashboards.dashboard.studentdashboard.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    // Constructor con inyección de dependencias
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    // Método para obtener todas las calificaciones
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }
}
