package pe.edu.tecsup.hexagonal.app.application.port.output;

import pe.edu.tecsup.hexagonal.app.domain.model.Cliente;
import pe.edu.tecsup.hexagonal.app.domain.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {


    Cliente guardar(Cliente cliente);

    Optional<Cliente> buscarPorId(String id);

    Optional<Cliente> buscarPorDocumento(String documento);


    List<Cliente> buscarPorNombre(String nombre);


}
