package uz.pdp.project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book extends Auditable{

    private String title;

    private String description;

    private String author;

    @OneToOne(fetch = FetchType.LAZY)
    private Upload file;

    @Builder(builderMethodName = "childBuilder")
    public Book(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String title,String description, String author,  Upload file) {
        super(id, createdAt, updatedAt);
        this.title = title;
        this.description = description;
        this.author = author;
        this.file = file;
    }
}
