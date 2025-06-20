package dashboards.dashboard.studentdashboard.controller;

import dashboards.dashboard.studentdashboard.model.Grade;
import dashboards.dashboard.studentdashboard.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin(origins = "*") // permite solicitudes desde el front (útil para Angular)
public class GradeController {

    private final GradeService gradeService;

    // Inyección del servicio
    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    // Endpoint GET para obtener todas las calificaciones
    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    // POST - Guardar una calificación
    @PostMapping
    public Grade saveGrade(@RequestBody Grade grade) {
        return gradeService.saveGrade(grade); // Aquí se aplica la lógica de status
    }
}
