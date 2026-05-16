package pe.edu.tecsup.hexagonal.app.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    private String id;
    private String nombre;
    private String email;
    private String documento;
    private LocalDateTime fechaCreacion;
}
