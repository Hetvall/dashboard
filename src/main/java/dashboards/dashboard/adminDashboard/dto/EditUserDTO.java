package dashboards.dashboard.adminDashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EditUserDTO {
    private String name;
    private String lastname;
    private String role;
    private String email;
    private String user_group;
}
