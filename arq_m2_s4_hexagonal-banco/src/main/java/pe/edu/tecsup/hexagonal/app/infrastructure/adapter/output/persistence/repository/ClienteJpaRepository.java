package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.entity.ClienteEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, String> {

    Optional<ClienteEntity> findByDocumento(String documento);


    boolean existsByDocumento(String documento);

    boolean existsByEmail(String email);
    List<ClienteEntity> findByNombreContainingIgnoreCase(String nombre);
}
