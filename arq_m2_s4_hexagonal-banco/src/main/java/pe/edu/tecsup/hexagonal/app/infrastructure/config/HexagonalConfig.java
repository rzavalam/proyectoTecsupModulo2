package pe.edu.tecsup.hexagonal.app.infrastructure.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.edu.tecsup.hexagonal.app.application.port.input.*;
import pe.edu.tecsup.hexagonal.app.application.port.output.ClienteRepositoryPort;
import pe.edu.tecsup.hexagonal.app.application.port.output.CuentaRepositoryPort;
import pe.edu.tecsup.hexagonal.app.application.port.output.NotificacionPort;
import pe.edu.tecsup.hexagonal.app.application.usecase.*;

@Configuration
public class HexagonalConfig {

    @Bean
    public CrearCuentaUseCase crearCuentaUseCase(
            CuentaRepositoryPort cuentaRepositoryPort,
            ClienteRepositoryPort clienteRepositoryPort) {

        return new CrearCuentaUseCaseImpl(
                cuentaRepositoryPort,
                clienteRepositoryPort
        );
    }

    @Bean
    public ConsultarSaldoUseCase consultarSaldoUseCase(
            CuentaRepositoryPort cuentaRepositoryPort) {

        return new ConsultarSaldoUseCaseImpl(cuentaRepositoryPort);
    }

    @Bean
    public TransferirDineroUseCase transferirDineroUseCase(
            CuentaRepositoryPort cuentaRepositoryPort,
            NotificacionPort notificacionPort) {

        return new TransferirDineroUseCaseImpl(
                cuentaRepositoryPort,
                notificacionPort
        );
    }

}
