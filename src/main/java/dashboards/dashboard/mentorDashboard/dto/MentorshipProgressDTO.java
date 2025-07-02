package dashboards.dashboard.mentorDashboard.dto;

public class MentorshipProgressDTO {
    private String name;
    private int progress;

    public MentorshipProgressDTO() {}

    public MentorshipProgressDTO(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
} 