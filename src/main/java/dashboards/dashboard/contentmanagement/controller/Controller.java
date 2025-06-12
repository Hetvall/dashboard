package dashboards.dashboard.contentmanagement.controller;

import dashboards.dashboard.contentmanagement.model.Content;
import dashboards.dashboard.contentmanagement.model.Course;
import dashboards.dashboard.contentmanagement.model.Module;
import dashboards.dashboard.contentmanagement.repositories.ContentRepository;
import dashboards.dashboard.contentmanagement.repositories.CoursesRepository;
import dashboards.dashboard.contentmanagement.repositories.ModulesRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Content Management", description = "APIs for managing courses, modules, and content")
public class Controller {

    @Autowired
    private CoursesRepository courseRepo;

    @Autowired
    private ModulesRepository moduleRepo;

    @Autowired
    private ContentRepository contentRepo;

    // Course endpoints
    @Operation(summary = "Create a new course")
    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseRepo.save(course));
    }

    @Operation(summary = "Get all courses")
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseRepo.findAll());
    }

    @Operation(summary = "Get a course by ID")
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return courseRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update a course")
    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @Valid @RequestBody Course updatedCourse) {
        return courseRepo.findById(id)
                .map(existingCourse -> {
                    existingCourse.setTitle(updatedCourse.getTitle());
                    existingCourse.setDescription(updatedCourse.getDescription());
                    return ResponseEntity.ok(courseRepo.save(existingCourse));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a course")
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        return courseRepo.findById(id)
                .map(course -> {
                    courseRepo.delete(course);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Module endpoints
    @Operation(summary = "Create a new module in a course")
    @PostMapping("/courses/{courseId}/modules")
    public ResponseEntity<Module> createModule(
            @PathVariable Long courseId,
            @Valid @RequestBody Module module) {
        return courseRepo.findById(courseId)
                .map(course -> {
                    course.addModule(module);
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(moduleRepo.save(module));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all modules in a course")
    @GetMapping("/courses/{courseId}/modules")
    public ResponseEntity<List<Module>> getModulesByCourse(@PathVariable Long courseId) {
        return courseRepo.findById(courseId)
                .map(course -> ResponseEntity.ok(course.getModules()))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update a module")
    @PutMapping("/modules/{id}")
    public ResponseEntity<Module> updateModule(
            @PathVariable Long id,
            @Valid @RequestBody Module updatedModule) {
        return moduleRepo.findById(id)
                .map(existingModule -> {
                    existingModule.setTitle(updatedModule.getTitle());
                    existingModule.setDescription(updatedModule.getDescription());
                    existingModule.setModuleOrder(updatedModule.getModuleOrder());
                    return ResponseEntity.ok(moduleRepo.save(existingModule));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a module")
    @DeleteMapping("/modules/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        return moduleRepo.findById(id)
                .map(module -> {
                    moduleRepo.delete(module);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Content endpoints
    @Operation(summary = "Add content to a module")
    @PostMapping("/modules/{moduleId}/content")
    public ResponseEntity<Content> addContentToModule(
            @PathVariable Long moduleId,
            @Valid @RequestBody Content content) {
        return moduleRepo.findById(moduleId)
                .map(module -> {
                    module.addContent(content);
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(contentRepo.save(content));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all content in a module")
    @GetMapping("/modules/{moduleId}/content")
    public ResponseEntity<List<Content>> getContentByModule(@PathVariable Long moduleId) {
        return moduleRepo.findById(moduleId)
                .map(module -> ResponseEntity.ok(module.getContents()))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update content")
    @PutMapping("/content/{id}")
    public ResponseEntity<Content> updateContent(
            @PathVariable Long id,
            @Valid @RequestBody Content updatedContent) {
        return contentRepo.findById(id)
                .map(existingContent -> {
                    existingContent.setType(updatedContent.getType());
                    existingContent.setContentData(updatedContent.getContentData());
                    existingContent.setContentOrder(updatedContent.getContentOrder());
                    return ResponseEntity.ok(contentRepo.save(existingContent));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete content")
    @DeleteMapping("/content/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
        return contentRepo.findById(id)
                .map(content -> {
                    contentRepo.delete(content);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
