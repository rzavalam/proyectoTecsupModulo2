package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.hexagonal.app.application.port.output.NotificacionPort;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ConsoleNotificationAdapter implements NotificacionPort {


    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("[NOTIFICACION] " + mensaje);
    }
}
