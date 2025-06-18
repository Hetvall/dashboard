package dashboards.dashboard.adminDashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCourseDTO {
    private String name;
    private String modality;
    private String certification;
    private String duration;
    private String description;
    private BigDecimal price;
}
