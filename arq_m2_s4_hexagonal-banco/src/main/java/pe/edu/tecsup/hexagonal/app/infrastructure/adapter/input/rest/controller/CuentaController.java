package pe.edu.tecsup.hexagonal.app.infrastructure.adapter.input.rest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pe.edu.tecsup.hexagonal.app.application.port.input.ConsultarSaldoUseCase;
import pe.edu.tecsup.hexagonal.app.application.port.input.CrearCuentaUseCase;
import pe.edu.tecsup.hexagonal.app.application.port.input.TransferirDineroUseCase;
import pe.edu.tecsup.hexagonal.app.domain.model.Cuenta;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class CuentaController {

    private final CrearCuentaUseCase crearCuentaUseCase;
    private final ConsultarSaldoUseCase consultarSaldoUseCase;
    private final TransferirDineroUseCase transferirDineroUseCase;


    @PostMapping
    public String crearCuenta(@RequestParam String clienteId, @RequestParam BigDecimal saldoInicial)
    {
        Cuenta cuenta = crearCuentaUseCase.crearCuenta(clienteId, saldoInicial);
        return "Cuenta creada con ID: "
                + cuenta.getCuentaId();
    }

    @GetMapping("/{id}/saldo")
    public BigDecimal consultarSaldo(@PathVariable String cuentaId) {

        return consultarSaldoUseCase.consultarSaldo(cuentaId);
    }

    @PostMapping("/transferir")
    public String transferir( @RequestParam String cuentaOrigenId, @RequestParam String cuentaDestinoId, @RequestParam BigDecimal monto) {

        transferirDineroUseCase.transferir(cuentaOrigenId, cuentaDestinoId, monto);

        return "Transferencia realizada";
    }
}
