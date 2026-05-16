package pe.edu.tecsup.hexagonal.app.domain.exception;

public class DatosCuentaInvalidosException extends RuntimeException{

    public DatosCuentaInvalidosException() {
        super("Los datos de la cuenta son inválidos");
    }
}
