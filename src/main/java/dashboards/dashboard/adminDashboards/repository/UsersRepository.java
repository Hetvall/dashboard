package dashboards.dashboard.adminDashboards.repository;

import dashboards.dashboard.adminDashboards.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<dashboards.dashboard.adminDashboards.entity.Users, Long> {
    boolean existsByEmail(String email);
}