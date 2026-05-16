package pe.edu.tecsup.hexagonal.app.domain.exception;

public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException() {
        super("Saldo insuficiente para realizar la transferencia");
    }

}
