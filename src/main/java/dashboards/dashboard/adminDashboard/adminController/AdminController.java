package dashboards.dashboard.adminDashboard.adminController;

import dashboards.dashboard.adminDashboard.dto.AssignedRoleDTO;
import dashboards.dashboard.adminDashboard.model.Users;
import dashboards.dashboard.adminDashboard.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/users")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    @Autowired
    UsersRepository usersRepo;

    // Get users list
    @GetMapping
    public List<Users> getAll() {return usersRepo.findAll();}

    // Assigned role
    @PostMapping("/assign-role")
    public ResponseEntity<String> assignRoleToUser(@RequestBody AssignedRoleDTO assignedRoleDTO) {
        Optional<Users> optionalUser = usersRepo.findById(assignedRoleDTO.getUserId());

        if(optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setRole(assignedRoleDTO.getRole());
            usersRepo.save(user);
            return ResponseEntity.ok("Role assigned successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
