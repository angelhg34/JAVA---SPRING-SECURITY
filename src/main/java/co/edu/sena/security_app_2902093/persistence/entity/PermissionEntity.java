package co.edu.sena.security_app_2902093.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permissions")
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true,nullable = false,updatable = false)
    private String name;


}
