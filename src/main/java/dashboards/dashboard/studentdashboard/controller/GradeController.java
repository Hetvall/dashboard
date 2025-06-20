package dashboards.dashboard.studentdashboard.controller;

import dashboards.dashboard.studentdashboard.model.Grade;
import dashboards.dashboard.studentdashboard.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin(origins = "*") // permite solicitudes desde cualquier origen (útil para Angular)
public class GradeController {

    private final GradeService gradeService;

    // Inyección del servicio
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    // Endpoint para obtener todas las calificaciones
    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }
}
