package dashboards.dashboard.adminDashboard.adminController;

import dashboards.dashboard.adminDashboard.model.Users;
import dashboards.dashboard.adminDashboard.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    @Autowired
    UsersRepository usersRepo;

    @GetMapping
    public List<Users> getAll() {return usersRepo.findAll();}
}
