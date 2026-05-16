package pe.edu.tecsup.hexagonal.app.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cuenta {

    private String cuentaId;
    private String clienteId;
    private String numeroCuenta;
    private BigDecimal saldo;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;


    public void depositar(BigDecimal monto) {
             saldo = saldo.add(monto);
    }

    public void retirar(BigDecimal monto) {

        if (saldo.compareTo(monto) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        saldo = saldo.subtract(monto);
    }

    public BigDecimal obtenerSaldo() {
        return saldo;
    }
}
