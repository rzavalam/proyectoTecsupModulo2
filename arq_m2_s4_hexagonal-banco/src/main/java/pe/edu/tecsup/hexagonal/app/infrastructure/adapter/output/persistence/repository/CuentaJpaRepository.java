package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.entity.CuentaEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaJpaRepository extends JpaRepository<CuentaEntity, String> {

    // Buscar por número de cuenta
    Optional<CuentaEntity> findByNumeroCuenta(String numeroCuenta);

    // Verificar si existe número de cuenta
    boolean existsByNumeroCuenta(String numeroCuenta);

    // Buscar cuentas por cliente
    List<CuentaEntity> findByClienteId(String clienteId);

    // Buscar cuentas activas
    List<CuentaEntity> findByEstado(String estado);

    // Buscar cuentas por cliente y estado
    List<CuentaEntity> findByClienteIdAndEstado(String clienteId, String estado);

    // Buscar cuentas con saldo mayor a X
    List<CuentaEntity> findBySaldoGreaterThan(Double saldo);

    Optional<CuentaEntity> findTopByOrderByCuentaIdDesc();

    Optional<CuentaEntity> findTopByOrderByNumeroCuentaDesc();

    // Query personalizada: cuentas por cliente (LIKE flexible)
    @Query("SELECT c FROM CuentaEntity c WHERE c.cliente.id = :clienteId")
    List<CuentaEntity> buscarPorCliente(@Param("clienteId") String clienteId);

    // Query: cuentas activas con saldo disponible
    @Query("SELECT c FROM CuentaEntity c WHERE c.estado = 'ACTIVO' AND c.saldo > 0")
    List<CuentaEntity> findCuentasActivasConSaldo();

}
