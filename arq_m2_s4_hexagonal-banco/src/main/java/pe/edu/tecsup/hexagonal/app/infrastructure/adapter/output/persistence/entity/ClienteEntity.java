package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClienteEntity {
    @Id
    private String id;

    private String nombre;

    private String email;

    private String documento;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
}
