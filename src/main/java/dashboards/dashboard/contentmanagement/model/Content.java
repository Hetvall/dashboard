package dashboards.dashboard.contentmanagement.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Content {
    private String title;
    private Long price;}
    //que otras variables?? mi contenido depende del admin, que otras variables o atributos tiene cada
    // curso?

