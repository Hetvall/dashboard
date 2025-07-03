package dashboards.dashboard.contentmanagement.services;

import dashboards.dashboard.contentmanagement.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dashboards.dashboard.contentmanagement.repositories.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public Course update(Long id, Course updatedCourse) {
        return courseRepository.findById(id).map(existingCourse -> {
            existingCourse.setTitle(updatedCourse.getTitle());
            existingCourse.setDescription(updatedCourse.getDescription());
            return courseRepository.save(existingCourse);
        }).orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
