package pe.edu.tecsup.hexagonal.app.application.usecase;

import pe.edu.tecsup.hexagonal.app.application.port.input.ConsultarSaldoUseCase;
import pe.edu.tecsup.hexagonal.app.application.port.output.CuentaRepositoryPort;
import pe.edu.tecsup.hexagonal.app.domain.model.Cuenta;

import java.math.BigDecimal;

public class ConsultarSaldoUseCaseImpl implements ConsultarSaldoUseCase {

    private final CuentaRepositoryPort repository;

    public ConsultarSaldoUseCaseImpl(
            CuentaRepositoryPort repository) {

        this.repository = repository;
    }

    @Override
    public BigDecimal consultarSaldo(String cuentaId) {

        return repository.buscarPorId(cuentaId)
                .map(Cuenta::getSaldo)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }
}
