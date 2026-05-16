package pe.edu.tecsup.hexagonal.app.application.port.input;

import java.math.BigDecimal;

public interface  ConsultarSaldoUseCase {

    BigDecimal consultarSaldo(String cuentaId);
}
