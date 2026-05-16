package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.input.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferenciaRequest {

    private String cuentaOrigenId;
    private String cuentaDestinoId;
    private BigDecimal monto;
}
