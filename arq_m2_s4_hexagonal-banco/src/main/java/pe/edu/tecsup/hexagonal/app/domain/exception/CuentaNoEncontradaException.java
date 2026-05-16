package pe.edu.tecsup.hexagonal.app.domain.exception;

public class CuentaNoEncontradaException extends RuntimeException{
    public CuentaNoEncontradaException() {
        super("La cuenta no fue encontrada");
    }
}
