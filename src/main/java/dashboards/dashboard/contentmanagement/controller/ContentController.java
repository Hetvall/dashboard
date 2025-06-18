package dashboards.dashboard.contentmanagement.controller;

import dashboards.dashboard.contentmanagement.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import dashboards.dashboard.contentmanagement.model.Content;


@RestController
@RequestMapping("/api/contents")
@CrossOrigin(origins = "*") // Habilita llamadas desde Angular (u otros clientes)
public class ContentController {

    @Autowired
    private ContentService contentService;

    // Obtener todos los contenidos
    @GetMapping
    public List<Content> getAllContents() {
        return contentService.findAll();
    }

    // Obtener contenido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Content> getContentById(@PathVariable Long id) {
        return contentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo contenido
    @PostMapping
    public ResponseEntity<Content> createContent(@RequestBody Content content) {
        Content savedContent = contentService.save(content);
        return ResponseEntity.ok(savedContent);
    }

    // Actualizar contenido existente
    @PutMapping("/{id}")
    public ResponseEntity<Content> updateContent(@PathVariable Long id, @RequestBody Content content) {
        try {
            Content updatedContent = contentService.update(id, content);
            return ResponseEntity.ok(updatedContent);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar contenido por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
        contentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
