package dashboards.dashboard.mentorDashboard.mentorController;

import dashboards.dashboard.mentorDashboard.dto.FeedbackRequest;

import dashboards.dashboard.mentorDashboard.model.Feedback;
import dashboards.dashboard.mentorDashboard.model.Mentorship;
import dashboards.dashboard.mentorDashboard.model.MentorUsers;


import dashboards.dashboard.mentorDashboard.repository.MentorshipRepository;
import dashboards.dashboard.mentorDashboard.repository.UserRepository;
import dashboards.dashboard.mentorDashboard.repository.FeedbackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mentors")
public class MentorController {
    @GetMapping
    public String index() {
        return "Bienvenido al endpoint de mentores. Usa /mentors/{id}/students o /{id}/feedback";
    }

    @Autowired
    private MentorshipRepository mentorshipRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private FeedbackRepository feedbackRepo;

    @GetMapping("/{id}/students")
    public ResponseEntity<?> getStudentsByMentor(@PathVariable Long id) {
        try {
            System.out.println("Mentor ID recibido: " + id);

            List<Mentorship> mentorships = mentorshipRepo.findByMentorId(id);
            System.out.println("Mentorías encontradas: " + mentorships);

            List<Long> studentIds = mentorships.stream()
                    .map(Mentorship::getStudentId)
                    .collect(Collectors.toList());
            System.out.println("IDs de estudiantes: " + studentIds);

            List<MentorUsers> students = userRepo.findByIdIn(studentIds);
            System.out.println("Estudiantes encontrados: " + students);

            return ResponseEntity.ok(students);
        } catch (Exception e) {
            e.printStackTrace();  // Imprime el error real
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }


    @PostMapping("/{id}/feedback")
    public ResponseEntity<String> sendFeedback(@PathVariable Long id, @RequestBody FeedbackRequest request) {
        if (request.getStudentId() == null || request.getContent() == null || request.getContent().isBlank()) {
            return ResponseEntity.badRequest().body("studentId y content son requeridos");
        }

        Feedback feedback = new Feedback();
        feedback.setMentorId(id);
        feedback.setStudentId(request.getStudentId());
        feedback.setContent(request.getContent());

        feedbackRepo.save(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body("Feedback enviado correctamente");
    }
}
