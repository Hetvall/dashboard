package dashboards.dashboard.mentorDashboard.dto;

import lombok.Data;

@Data
public class FeedbackRequest {
    private Long studentId;
    private String content;
}
