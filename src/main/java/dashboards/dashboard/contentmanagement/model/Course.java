package dashboards.dashboard.contentmanagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "courses")
public class Course {

    // Getters y Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @JsonManagedReference("content-course")
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Content> contents = new ArrayList<>();

    @JsonManagedReference("module-course")
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Module> modules = new ArrayList<>();


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Constructor vacío
    public Course() {
    }

}
