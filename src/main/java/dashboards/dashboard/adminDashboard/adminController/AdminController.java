package dashboards.dashboard.adminDashboard.adminController;

import dashboards.dashboard.adminDashboard.dto.AssignedRoleDTO;
import dashboards.dashboard.adminDashboard.dto.CreateUserDTO;
import dashboards.dashboard.adminDashboard.dto.EditUserDTO;
import dashboards.dashboard.adminDashboard.entity.Users;
import dashboards.dashboard.adminDashboard.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    // Get users by ID (Check profile)
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long userId) {
        return usersRepo.findById(userId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

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

    // Edit user
    @PutMapping("/{id}")
    public ResponseEntity<String> editUser(@PathVariable("id") Long userId, @RequestBody EditUserDTO editUserDTO) {
        Optional<Users> optionalUser = usersRepo.findById(userId);

        if(optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setName(editUserDTO.getName());
            user.setLastname(editUserDTO.getLastname());
            user.setEmail(editUserDTO.getEmail());
            user.setRole(editUserDTO.getRole());
            user.setUser_group(editUserDTO.getUser_group());
            usersRepo.save(user);
            return ResponseEntity.ok("User updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found, please try again");
        }
    }

    // Create user
    @PostMapping("/add-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserDTO createUserDTO) {
        Users user = new Users();
        user.setName(createUserDTO.getName());
        user.setLastname(createUserDTO.getLastname());
        user.setEmail(createUserDTO.getEmail());
        user.setRole(createUserDTO.getRole());
        user.setUser_group(createUserDTO.getUser_group());
        user.setCreatedAt(new Date());
        usersRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created correctly!");
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId) {
        Optional<Users> optionalUser = usersRepo.findById(userId);

        if(optionalUser.isPresent()) {
            usersRepo.delete(optionalUser.get());
            return ResponseEntity.ok("User deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
    }
}
