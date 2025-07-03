package dashboards.dashboard.contentmanagement.services;

import dashboards.dashboard.contentmanagement.model.Content;
import dashboards.dashboard.contentmanagement.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import dashboards.dashboard.contentmanagement.model.ContentType;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    // Crear nuevo contenido
    @Transactional
    public Content save(Content content) {
        return contentRepository.save(content);
    }

    // Obtener todos los contenidos
    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    // Buscar contenido por ID
    public Optional<Content> findById(Long id) {
        return contentRepository.findById(id);
    }

    // Actualizar contenido existente
    @Transactional
    public Content update(Long id, Content updatedContent) {
        return contentRepository.findById(id).map(existingContent -> {
            // Actualizar solo los campos que no son nulos
            if (updatedContent.getTitle() != null) {
                existingContent.setTitle(updatedContent.getTitle());
            }
            if (updatedContent.getDescription() != null) {
                existingContent.setDescription(updatedContent.getDescription());
            }
            if (updatedContent.getUrl() != null) {
                existingContent.setUrl(updatedContent.getUrl());
            }
            if (updatedContent.getType() != null) {
                existingContent.setType(updatedContent.getType());
            }
            if (updatedContent.getCourse() != null) {
                existingContent.setCourse(updatedContent.getCourse());
            }
            if (updatedContent.getModule() != null) {
                existingContent.setModule(updatedContent.getModule());
            }
            // El updatedAt se maneja automáticamente por @PreUpdate en la entidad
            return contentRepository.save(existingContent);
        }).orElseThrow(() -> new RuntimeException("Contenido no encontrado con ID: " + id));
    }

    // Eliminar contenido por ID
    @Transactional
    public void delete(Long id) {
        contentRepository.deleteById(id);
    }
}
