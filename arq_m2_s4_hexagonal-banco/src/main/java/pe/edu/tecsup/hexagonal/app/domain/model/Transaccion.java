package pe.edu.tecsup.hexagonal.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Transaccion {

    private String transaccionId;
    private String cuentaOrigenId;
    private String cuentaDestinoId;
    private BigDecimal monto;
    private BigDecimal comision;
    private String tipo;
    private String estado;
    private String descripcion;
    private LocalDateTime fechaCreacion;


}
