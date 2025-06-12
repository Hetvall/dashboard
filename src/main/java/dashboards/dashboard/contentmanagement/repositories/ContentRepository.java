package dashboards.dashboard.contentmanagement.repositories;

import dashboards.dashboard.contentmanagement.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
}