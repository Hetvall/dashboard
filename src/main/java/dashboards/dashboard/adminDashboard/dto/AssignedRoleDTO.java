package dashboards.dashboard.adminDashboard.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssignedRoleDTO {
    private Long userId;
    private String role;
}
