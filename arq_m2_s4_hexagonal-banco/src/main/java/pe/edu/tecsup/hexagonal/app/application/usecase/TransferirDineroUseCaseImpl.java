package pe.edu.tecsup.hexagonal.app.application.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.tecsup.hexagonal.app.application.port.input.TransferirDineroUseCase;
import pe.edu.tecsup.hexagonal.app.application.port.output.CuentaRepositoryPort;
import pe.edu.tecsup.hexagonal.app.application.port.output.NotificacionPort;
import pe.edu.tecsup.hexagonal.app.domain.exception.SaldoInsuficienteException;
import pe.edu.tecsup.hexagonal.app.domain.model.Cuenta;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Transactional
@Slf4j
public class TransferirDineroUseCaseImpl  implements TransferirDineroUseCase {

    private final CuentaRepositoryPort repository;
    private final NotificacionPort notificacionPort;


    @Override
    public void transferir(String origen, String destino, BigDecimal monto)
    {

        Cuenta cuentaOrigen = repository.buscarPorId(origen)
                .orElseThrow(() -> new RuntimeException("Cuenta origen no encontrada"));

        Cuenta cuentaDestino = repository.buscarPorId(destino)
                .orElseThrow(() -> new RuntimeException("Cuenta destino no encontrada"));

        if (cuentaOrigen.getSaldo().compareTo(monto) < 0) {
            throw new SaldoInsuficienteException();
        }
        cuentaOrigen.retirar(monto);

        cuentaDestino.depositar(monto);

        repository.guardar(cuentaOrigen);
        repository.guardar(cuentaDestino);

        notificacionPort.enviarNotificacion( "Transferencia realizada de " + origen  + " hacia " + destino + " por S/ " + monto +" correctamente ");

    }
}
