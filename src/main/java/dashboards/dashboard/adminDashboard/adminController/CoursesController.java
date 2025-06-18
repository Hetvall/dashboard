package dashboards.dashboard.adminDashboard.adminController;

import dashboards.dashboard.adminDashboard.dto.CreateCourseDTO;
import dashboards.dashboard.adminDashboard.dto.EditCourseViewDTO;
import dashboards.dashboard.adminDashboard.entity.Courses;
import dashboards.dashboard.adminDashboard.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin-dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class CoursesController {
    @Autowired
    CoursesRepository coursesRepo;

    // Get courses list
    @GetMapping("/courses")
    public List<Courses> getAllCourses() {return coursesRepo.findAll();}

    // Create a new course
    @PostMapping("/courses/new")
    public ResponseEntity<String> createCourse(@RequestBody CreateCourseDTO createCourseDTO) {
        Courses courses = new Courses();

        courses.setName(createCourseDTO.getName());
        courses.setModality(createCourseDTO.getModality());
        courses.setCertification(createCourseDTO.getCertification());
        courses.setDuration(createCourseDTO.getDuration());
        courses.setDescription(createCourseDTO.getDescription());
        courses.setPrice(createCourseDTO.getPrice());
        courses.setCreatedAt(new Date());
        coursesRepo.save(courses);

        return ResponseEntity.status(HttpStatus.CREATED).body("Course created successfully!");
    }

    // Preload course content when clicking on "Editar Vista" by ID
    @GetMapping("/courses/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable Long id) {
        return coursesRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Save changes after clicking on "Actualizar curso"
    @PutMapping("/courses/{id}")
    public ResponseEntity<String> editCourseView(@PathVariable Long id, @RequestBody EditCourseViewDTO editCourseViewDTO) {
        Optional<Courses> optionalCourse = coursesRepo.findById(id);

        if(optionalCourse.isPresent()) {
            Courses courses= optionalCourse.get();
            courses.setName(editCourseViewDTO.getName());
            courses.setModality(editCourseViewDTO.getModality());
            courses.setCertification(editCourseViewDTO.getCertification());
            courses.setDescription(editCourseViewDTO.getDescription());
            courses.setPrice(editCourseViewDTO.getPrice());
            coursesRepo.save(courses);
            return ResponseEntity.ok("Course updated!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found, please try again");
        }
    }

    // Delete course
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Long id) {
        Optional<Courses> optionalCourses = coursesRepo.findById(id);

        if(optionalCourses.isPresent()) {
            coursesRepo.delete(optionalCourses.get());
            return ResponseEntity.ok("Course deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found, please try again!");
        }
    }

    // Search course by name
    @GetMapping("/courses/search")
    public List<Courses> searchCourses(@RequestParam String name) {
        return coursesRepo.findByNameContainingIgnoreCase(name);
    }
}
