package dashboards.dashboard.contentmanagement.services;

import dashboards.dashboard.contentmanagement.model.Module;
import dashboards.dashboard.contentmanagement.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public Module save(Module module) {
        return moduleRepository.save(module);
    }

    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    public Optional<Module> findById(Long id) {
        return moduleRepository.findById(id);
    }

    public Module update(Long id, Module updatedModule) {
        return moduleRepository.findById(id).map(existingModule -> {
            existingModule.setTitle(updatedModule.getTitle());
            existingModule.setDescription(updatedModule.getDescription());
            existingModule.setModuleOrder(updatedModule.getModuleOrder());
            existingModule.setCourse(updatedModule.getCourse()); // Si permites cambiar el curso
            return moduleRepository.save(existingModule);
        }).orElseThrow(() -> new RuntimeException("Módulo no encontrado con ID: " + id));
    }

    public void delete(Long id) {
        moduleRepository.deleteById(id);
    }
}
