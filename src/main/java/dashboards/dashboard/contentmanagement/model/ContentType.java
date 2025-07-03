package dashboards.dashboard.contentmanagement.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum ContentType {
    video("video"),
    text("text"),
    quiz("quiz");

    private final String value;

    ContentType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
