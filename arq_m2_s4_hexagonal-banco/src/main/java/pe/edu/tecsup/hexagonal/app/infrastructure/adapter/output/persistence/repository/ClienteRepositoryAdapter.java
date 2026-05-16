package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.hexagonal.app.application.port.output.ClienteRepositoryPort;
import pe.edu.tecsup.hexagonal.app.domain.model.Cliente;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.entity.ClienteEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository repository;

    @Override
    public Cliente guardar(Cliente cliente) {
        ClienteEntity entity = toEntity(cliente);
        ClienteEntity saved = repository.save(entity);
        return toDomain(saved);
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    @Override
    public Optional<Cliente> buscarPorId(String id) {
        log.info("Entrando a buscar cliente {}", id);

        Optional<ClienteEntity> entity =
                repository.findById(id);

        log.info("Encontró cliente ?: {}",
                entity.isPresent());

        return entity.map(this::toDomain);
    }

    // =========================
    // BUSCAR POR DOCUMENTO
    // =========================
    @Override
    public Optional<Cliente> buscarPorDocumento(String documento) {
        return repository.findByDocumento(documento)
                .map(this::toDomain);
    }
    // =========================
    // LISTAR POR NOMBRE
    // =========================
    @Override
    public List<Cliente> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    // =========================
    // ENTITY → DOMAIN
    // =========================
    private Cliente toDomain(ClienteEntity entity) {
        Cliente cliente = new Cliente();
        cliente.setId(entity.getId());
        cliente.setNombre(entity.getNombre());
        cliente.setEmail(entity.getEmail());
        cliente.setDocumento(entity.getDocumento());
        return cliente;
    }

    // =========================
    // DOMAIN → ENTITY
    // =========================
    private ClienteEntity toEntity(Cliente cliente) {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(cliente.getId());
        entity.setNombre(cliente.getNombre());
        entity.setEmail(cliente.getEmail());
        entity.setDocumento(cliente.getDocumento());
        return entity;
    }
}
