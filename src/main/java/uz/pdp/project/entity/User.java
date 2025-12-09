package uz.pdp.project.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.project.enums.UserStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class User extends Auditable{

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role = "USER";

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.IN_ACTIVE;

    @Builder(builderMethodName = "childBuilder")
    public User(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String email, String password, String role, UserStatus status) {
        super(id, createdAt, updatedAt);
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }
}
// salom
// dfasdfsfadf
// salom