package dashboards.dashboard.adminDashboards.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUserDTO {
    private String name;
    private String lastname;
    private String email;
    private String userGroup;
    private String role;
}