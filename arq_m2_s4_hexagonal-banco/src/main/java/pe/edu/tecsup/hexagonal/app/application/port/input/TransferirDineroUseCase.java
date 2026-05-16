package pe.edu.tecsup.hexagonal.app.application.port.input;

import java.math.BigDecimal;

public interface  TransferirDineroUseCase {


    void transferir( String cuentaOrigenId, String cuentaDestinoId, BigDecimal monto);
}
