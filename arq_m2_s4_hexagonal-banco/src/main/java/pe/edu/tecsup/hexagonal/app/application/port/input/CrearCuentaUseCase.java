package pe.edu.tecsup.hexagonal.app.application.port.input;

import pe.edu.tecsup.hexagonal.app.domain.model.Cuenta;

import java.math.BigDecimal;

public interface  CrearCuentaUseCase {

    Cuenta crearCuenta(String clienteId, BigDecimal saldoInicial);
}
