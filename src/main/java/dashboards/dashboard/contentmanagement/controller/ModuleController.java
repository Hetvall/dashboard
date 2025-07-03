package dashboards.dashboard.contentmanagement.controller;

import dashboards.dashboard.contentmanagement.model.Module;
import dashboards.dashboard.contentmanagement.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    // Crear módulo
    @PostMapping
    public ResponseEntity<Module> createModule(@RequestBody Module module) {
        Module savedModule = moduleService.save(module);
        return ResponseEntity.ok(savedModule);
    }

    // Obtener todos los módulos
    @GetMapping
    public ResponseEntity<List<Module>> getAllModules() {
        return ResponseEntity.ok(moduleService.findAll());
    }

    // Obtener módulo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        return moduleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar módulo
    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module updatedModule) {
        try {
            Module module = moduleService.update(id, updatedModule);
            return ResponseEntity.ok(module);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar módulo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
