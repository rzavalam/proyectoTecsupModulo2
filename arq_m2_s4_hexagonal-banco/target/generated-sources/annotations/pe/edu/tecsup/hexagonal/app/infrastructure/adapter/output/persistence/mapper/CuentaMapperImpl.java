package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pe.edu.tecsup.hexagonal.app.domain.model.Cuenta;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.input.rest.dto.CrearCuentaRequest;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.input.rest.dto.CuentaResponse;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.entity.ClienteEntity;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.entity.CuentaEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-15T19:17:03-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class CuentaMapperImpl implements CuentaMapper {

    @Override
    public Cuenta toDomain(CuentaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Cuenta.CuentaBuilder cuenta = Cuenta.builder();

        cuenta.clienteId( entityClienteId( entity ) );
        cuenta.cuentaId( entity.getCuentaId() );
        cuenta.numeroCuenta( entity.getNumeroCuenta() );
        cuenta.saldo( entity.getSaldo() );
        cuenta.estado( entity.getEstado() );
        cuenta.fechaCreacion( entity.getFechaCreacion() );
        cuenta.fechaActualizacion( entity.getFechaActualizacion() );

        return cuenta.build();
    }

    @Override
    public Cuenta toDomain(CrearCuentaRequest request) {
        if ( request == null ) {
            return null;
        }

        Cuenta.CuentaBuilder cuenta = Cuenta.builder();

        cuenta.clienteId( request.getClienteId() );
        cuenta.saldo( request.getSaldo() );

        return cuenta.build();
    }

    @Override
    public CuentaEntity toEntity(Cuenta cuenta) {
        if ( cuenta == null ) {
            return null;
        }

        CuentaEntity cuentaEntity = new CuentaEntity();

        cuentaEntity.setCliente( cuentaToClienteEntity( cuenta ) );
        cuentaEntity.setCuentaId( cuenta.getCuentaId() );
        cuentaEntity.setNumeroCuenta( cuenta.getNumeroCuenta() );
        cuentaEntity.setSaldo( cuenta.getSaldo() );
        cuentaEntity.setEstado( cuenta.getEstado() );

        return cuentaEntity;
    }

    @Override
    public CuentaResponse toResponse(Cuenta cuenta) {
        if ( cuenta == null ) {
            return null;
        }

        CuentaResponse.CuentaResponseBuilder cuentaResponse = CuentaResponse.builder();

        cuentaResponse.cuentaId( cuenta.getCuentaId() );
        cuentaResponse.clienteId( cuenta.getClienteId() );
        cuentaResponse.numeroCuenta( cuenta.getNumeroCuenta() );
        cuentaResponse.saldo( cuenta.getSaldo() );
        cuentaResponse.estado( cuenta.getEstado() );
        cuentaResponse.fechaCreacion( cuenta.getFechaCreacion() );
        cuentaResponse.fechaActualizacion( cuenta.getFechaActualizacion() );

        return cuentaResponse.build();
    }

    @Override
    public List<Cuenta> toDomain(List<CuentaEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Cuenta> list = new ArrayList<Cuenta>( entities.size() );
        for ( CuentaEntity cuentaEntity : entities ) {
            list.add( toDomain( cuentaEntity ) );
        }

        return list;
    }

    @Override
    public List<CuentaResponse> toResponse(List<Cuenta> cuentas) {
        if ( cuentas == null ) {
            return null;
        }

        List<CuentaResponse> list = new ArrayList<CuentaResponse>( cuentas.size() );
        for ( Cuenta cuenta : cuentas ) {
            list.add( toResponse( cuenta ) );
        }

        return list;
    }

    private String entityClienteId(CuentaEntity cuentaEntity) {
        if ( cuentaEntity == null ) {
            return null;
        }
        ClienteEntity cliente = cuentaEntity.getCliente();
        if ( cliente == null ) {
            return null;
        }
        String id = cliente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected ClienteEntity cuentaToClienteEntity(Cuenta cuenta) {
        if ( cuenta == null ) {
            return null;
        }

        ClienteEntity.ClienteEntityBuilder clienteEntity = ClienteEntity.builder();

        clienteEntity.id( cuenta.getClienteId() );

        return clienteEntity.build();
    }
}
