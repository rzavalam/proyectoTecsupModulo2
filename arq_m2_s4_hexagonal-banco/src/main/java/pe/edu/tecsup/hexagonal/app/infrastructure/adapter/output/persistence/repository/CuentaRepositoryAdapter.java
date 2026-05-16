package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.hexagonal.app.application.port.output.CuentaRepositoryPort;
import pe.edu.tecsup.hexagonal.app.domain.model.Cuenta;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.entity.ClienteEntity;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.entity.CuentaEntity;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.mapper.CuentaMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CuentaRepositoryAdapter implements CuentaRepositoryPort {

    private final CuentaJpaRepository repository;
    private final CuentaMapper cuentaMapper;

    @Override
    public Cuenta guardar(Cuenta cuenta) {
        CuentaEntity entity = toEntity(cuenta);
        CuentaEntity saved = repository.save(entity);
        return toDomain(saved);
    }


    @Override
    public Optional<Cuenta> buscarPorId(String id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Cuenta> buscarPorCliente(String clienteId) {
        return repository.findByClienteId(clienteId)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cuenta> obtenerUltimaCuenta() {
        return repository.findTopByOrderByCuentaIdDesc().map(cuentaMapper::toDomain);
    }

    @Override
    public Optional<Cuenta> obtenerUltimoNumeroCuenta() {

        return repository.findTopByOrderByNumeroCuentaDesc().map(cuentaMapper::toDomain);
    }

    private Cuenta toDomain(CuentaEntity entity) {

        Cuenta cuenta = new Cuenta();

        cuenta.setCuentaId(entity.getCuentaId());

        cuenta.setClienteId(
                entity.getCliente() != null ? entity.getCliente().getId() : null
        );

        cuenta.setNumeroCuenta(entity.getNumeroCuenta());
        cuenta.setSaldo(entity.getSaldo());
        cuenta.setEstado(entity.getEstado());

        return cuenta;
    }

    private CuentaEntity toEntity(Cuenta cuenta) {

        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(cuenta.getClienteId());

        CuentaEntity entity = new CuentaEntity();

        entity.setCuentaId(cuenta.getCuentaId());
        entity.setCliente(cliente);
        entity.setNumeroCuenta(cuenta.getNumeroCuenta());
        entity.setSaldo(cuenta.getSaldo());
        entity.setEstado(cuenta.getEstado());

        return entity;
    }
}
