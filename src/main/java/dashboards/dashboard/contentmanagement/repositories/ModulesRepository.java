package dashboards.dashboard.contentmanagement.repositories;

import dashboards.dashboard.contentmanagement.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulesRepository extends JpaRepository<Module, Long> {
}
