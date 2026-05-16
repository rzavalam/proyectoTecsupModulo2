package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pe.edu.tecsup.hexagonal.app.domain.model.Cuenta;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.input.rest.dto.CrearCuentaRequest;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.input.rest.dto.CuentaResponse;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.entity.CuentaEntity;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ClienteMapper {

    /*ClienteMapper INSTANCE =   Mappers.getMapper(ClienteMapper.class);

    Cuenta toDomain(CuentaEntity entity);
    // Request to Domain ========================
    @BeanMapping(ignoreByDefault = true)
    @Mapping( target = "clienteId",  ignore = true)
    @Mapping( target = "saldo",  source = "saldo")
    //Cuenta toDomain(CrearCuentaRequest request);

    // Domain to Entity
    //@Mapping( target = "cliente", ignore = true)
    @Mapping(target = "cuentaId", source = "cuentaId")
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "numeroCuenta", source = "numeroCuenta")
    @Mapping(target = "saldo", source = "saldo")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    //CuentaEntity toEntity(Cuenta cuenta);

    // Domain to Response
    @Mapping(target = "cuentaId", source = "cuentaId")
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "numeroCuenta", source = "numeroCuenta")
    @Mapping(target = "saldo", source = "saldo")
    @Mapping(target = "estado", source = "estado")
   // CuentaResponse toResponse(Cuenta cuenta);

    // List mappings
    //List<Cuenta> toDomain(List<CuentaEntity> entities);

    List<CuentaResponse> toResponse(List<Cuenta> cuentas);*/
}
