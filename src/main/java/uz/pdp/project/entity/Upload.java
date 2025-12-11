package uz.pdp.project.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "uploads")
public class Upload extends Auditable{
    private String originalName;

    private String preparedName;

    private String extension; // .pdf, .png, .jpeg

    private Long size;

    private String mimeType; // content-type: document/json
}
