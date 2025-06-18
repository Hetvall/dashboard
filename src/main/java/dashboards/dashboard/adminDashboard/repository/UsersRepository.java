package dashboards.dashboard.adminDashboard.repository;

import dashboards.dashboard.adminDashboard.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
