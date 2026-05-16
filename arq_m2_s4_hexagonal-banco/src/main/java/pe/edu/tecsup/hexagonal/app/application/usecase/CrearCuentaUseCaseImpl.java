package pe.edu.tecsup.hexagonal.app.application.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.tecsup.hexagonal.app.application.port.input.CrearCuentaUseCase;
import pe.edu.tecsup.hexagonal.app.application.port.output.ClienteRepositoryPort;
import pe.edu.tecsup.hexagonal.app.application.port.output.CuentaRepositoryPort;
import pe.edu.tecsup.hexagonal.app.domain.exception.DatosCuentaInvalidosException;
import pe.edu.tecsup.hexagonal.app.domain.model.Cliente;
import pe.edu.tecsup.hexagonal.app.domain.model.Cuenta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Transactional
@RequiredArgsConstructor
@Slf4j
public class CrearCuentaUseCaseImpl implements CrearCuentaUseCase {

    private final CuentaRepositoryPort cuentaRepositoryPort;
    private final ClienteRepositoryPort clienteRepositoryPort;



    @Override
    @Transactional
    public Cuenta crearCuenta(String clienteId, BigDecimal saldoInicial) {

        log.info("Creando cuenta para cliente: {}", clienteId);

        Cliente cliente =
                clienteRepositoryPort
                        .buscarPorId(clienteId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Cliente no encontrado"
                                )
                        );

        if (saldoInicial == null || saldoInicial.compareTo(BigDecimal.ZERO) < 0) {
            throw new DatosCuentaInvalidosException();
        }

        Cuenta cuenta = new Cuenta();

        //cuenta.setCuentaId( UUID.randomUUID().toString());
        cuenta.setCuentaId(generarCuentaId());

        cuenta.setClienteId(clienteId);

        cuenta.setNumeroCuenta( generarNumeroCuenta());

        cuenta.setSaldo(saldoInicial);

        cuenta.setEstado("ACTIVO");

        cuenta.setFechaCreacion( LocalDateTime.now());

        cuenta.setFechaActualizacion( LocalDateTime.now());

        return cuentaRepositoryPort.guardar(cuenta);
    }

    private String generarNumeroCuenta2() {
        long numero = (long) (Math.random() * 9000000000L) + 1000000000L;
        return String.valueOf(numero);
    }


    private synchronized String generarCuentaId() {

        Optional<Cuenta> ultimaCuenta = cuentaRepositoryPort.obtenerUltimaCuenta();

        if (ultimaCuenta.isEmpty()) {
            return "CTA001";
        }

        String ultimoCodigo = ultimaCuenta.get().getCuentaId();

        int numero =Integer.parseInt(ultimoCodigo.replace("CTA", ""));

        numero++;

        return String.format("CTA%03d", numero);
    }


    private synchronized String generarNumeroCuenta() {

        Optional<Cuenta> ultimaCuenta =  cuentaRepositoryPort.obtenerUltimoNumeroCuenta();

        if (ultimaCuenta.isEmpty()) {
            return "0001-000001";
        }

        String ultimoNumero =   ultimaCuenta.get().getNumeroCuenta();

        // 0001-000123
        String[] partes = ultimoNumero.split("-");

        int correlativo = Integer.parseInt(partes[1]);
        correlativo++;

        return String.format("%s-%06d", partes[0], correlativo);
    }
}
