package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.input.rest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.tecsup.hexagonal.app.application.port.input.ConsultarSaldoUseCase;
import pe.edu.tecsup.hexagonal.app.application.port.input.CrearCuentaUseCase;
import pe.edu.tecsup.hexagonal.app.application.port.input.TransferirDineroUseCase;
import pe.edu.tecsup.hexagonal.app.domain.exception.ClienteNoExisteException;
import pe.edu.tecsup.hexagonal.app.domain.exception.CuentaNoEncontradaException;
import pe.edu.tecsup.hexagonal.app.domain.exception.DatosCuentaInvalidosException;
import pe.edu.tecsup.hexagonal.app.domain.exception.SaldoInsuficienteException;
import pe.edu.tecsup.hexagonal.app.domain.model.Cuenta;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.input.rest.dto.CrearCuentaRequest;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.input.rest.dto.CuentaResponse;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.input.rest.dto.TransferenciaRequest;
import pe.edu.tecsup.hexagonal.app.infrastructure.adapter.output.persistence.mapper.CuentaMapper;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/cuentas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class CuentaCambioController {

    private final CrearCuentaUseCase crearCuentaUseCase;
    private final ConsultarSaldoUseCase consultarSaldoUseCase;
    private final TransferirDineroUseCase transferirDineroUseCase;
    private final CuentaMapper mapper;

    @PostMapping
    public ResponseEntity<Object> crearCuenta(
            @RequestBody CrearCuentaRequest request) {

        try {
            log.info("Creando cuenta para cliente: {}",  request.getClienteId());
            Cuenta nuevaCuenta =  crearCuentaUseCase.crearCuenta(request.getClienteId(),request.getSaldo());
            log.info("Cuenta creada correctamente con ID: {}",nuevaCuenta.getCuentaId());

            return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(nuevaCuenta));

        }catch (ClienteNoExisteException e) {
            log.warn("Datos inválidos para crear cuenta: {}", e.getMessage());

            log.warn("Datos inválidos para crear cuenta: {}", e.getMessage());

            return ResponseEntity
                    .badRequest()
                    .body("El cliente no existe");

        } catch (DatosCuentaInvalidosException e) {
            log.warn("Datos inválidos para crear cuenta: {}",e.getMessage());
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            log.error( "Error inesperado creando cuenta",e);

            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{cuentaId}/saldo")
    public ResponseEntity<BigDecimal> consultarSaldo(@PathVariable String cuentaId) {

        try {
            log.info("Consultando saldo cuenta: {}",cuentaId);
            BigDecimal saldo =  consultarSaldoUseCase.consultarSaldo(cuentaId);
            return ResponseEntity.ok(saldo);

        } catch (CuentaNoEncontradaException e) {
            log.warn("Cuenta no encontrada: {}", cuentaId);
            return ResponseEntity.notFound().build();

        } catch (Exception e) {
            log.error("Error inesperado consultando saldo",e);
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/transferir")
    public ResponseEntity<String> transferir( @RequestBody TransferenciaRequest request)
    {
        try {  transferirDineroUseCase.transferir(request.getCuentaOrigenId(), request.getCuentaDestinoId(),request.getMonto());

            return ResponseEntity.ok("Transferencia realizada correctamente");

        } catch (DatosCuentaInvalidosException e) {
            log.warn("Datos inválidos en transferencia");
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (CuentaNoEncontradaException e) {
            log.warn("Cuenta no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (SaldoInsuficienteException e) {
            log.warn("saldo insuficiente");
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            log.error("Error inesperado en transferencia",e);

            return ResponseEntity.internalServerError().body("Error interno");
        }
    }
}
