package dashboards.dashboard.adminDashboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;
    private String name;
    private String lastname;
    private String email;

    @Column(name = "user_group")
    private String userGroup;

    private String role;

    @Column(name = "created_at")
    private Date createdAt;
}
