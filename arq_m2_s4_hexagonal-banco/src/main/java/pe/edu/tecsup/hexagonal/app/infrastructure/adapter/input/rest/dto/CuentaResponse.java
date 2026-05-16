package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.input.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.tecsup.hexagonal.app.domain.model.Cliente;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuentaResponse {
    private String cuentaId;
    private String clienteId;
    private String numeroCuenta;
    private BigDecimal saldo;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
