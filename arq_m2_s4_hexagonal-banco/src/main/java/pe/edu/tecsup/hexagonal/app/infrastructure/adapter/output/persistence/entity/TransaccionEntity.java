package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaccion")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransaccionEntity {
    @Id
    @Column(name = "transaccion_id")
    private String transaccionId;

    @ManyToOne
    @JoinColumn(name = "cuenta_origen_id")
    private CuentaEntity cuentaOrigen;

    @ManyToOne
    @JoinColumn(name = "cuenta_destino_id")
    private CuentaEntity cuentaDestino;

    private BigDecimal monto;

    private BigDecimal comision;

    private String tipo;

    private String estado;

    private String descripcion;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

}
