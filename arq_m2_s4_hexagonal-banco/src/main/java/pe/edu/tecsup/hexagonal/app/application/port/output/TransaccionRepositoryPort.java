package pe.edu.tecsup.hexagonal.app.application.port.output;

import pe.edu.tecsup.hexagonal.app.domain.model.Transaccion;

public interface TransaccionRepositoryPort {
    void guardar(Transaccion transaccion);
}
