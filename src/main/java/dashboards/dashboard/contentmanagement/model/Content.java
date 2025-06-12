package dashboards.dashboard.contentmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Content type is required")
    @Enumerated(EnumType.STRING)
    private ContentType type;

    @NotBlank(message = "Content data is required")
    @Column(columnDefinition = "TEXT")
    private String contentData;

    @NotNull(message = "Content order is required")
    private int contentOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private Module module;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public enum ContentType {
        TEXT,
        VIDEO,
        PDF,
        QUIZ,
        ASSIGNMENT
    }
}
