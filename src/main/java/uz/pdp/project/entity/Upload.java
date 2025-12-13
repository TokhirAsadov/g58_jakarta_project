package uz.pdp.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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

    @Builder(builderMethodName = "childBuilder")
    public Upload(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String originalName, String preparedName, String extension, Long size, String mimeType) {
        super(id, createdAt, updatedAt);
        this.originalName = originalName;
        this.preparedName = preparedName;
        this.extension = extension;
        this.size = size;
        this.mimeType = mimeType;
    }
}
