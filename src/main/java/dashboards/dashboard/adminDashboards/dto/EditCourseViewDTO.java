package dashboards.dashboard.adminDashboards.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EditCourseViewDTO {
    private String name;
    private String modality;
    private String certification;
    private String duration;
    private String description;
    private BigDecimal price;
}