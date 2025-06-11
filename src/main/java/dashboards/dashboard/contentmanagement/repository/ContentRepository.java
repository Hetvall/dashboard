package dashboards.dashboard.contentmanagement.repository;
import dashboards.dashboard.contentmanagement.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, String> {
}