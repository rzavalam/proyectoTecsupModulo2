package pe.edu.tecsup.hexagonal.app.application.port.output;

import pe.edu.tecsup.hexagonal.app.domain.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface  CuentaRepositoryPort {


    Optional<Cuenta> buscarPorId(String id);

    Cuenta guardar(Cuenta cuenta);

    List<Cuenta> buscarPorCliente(String clienteId);

    Optional<Cuenta> obtenerUltimaCuenta();

    Optional<Cuenta> obtenerUltimoNumeroCuenta();
}
