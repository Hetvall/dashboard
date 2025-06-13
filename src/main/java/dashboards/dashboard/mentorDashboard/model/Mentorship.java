package dashboards.dashboard.mentorDashboard.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mentorships")
@Data
public class Mentorship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long mentorId;
    private Long studentId;
}
