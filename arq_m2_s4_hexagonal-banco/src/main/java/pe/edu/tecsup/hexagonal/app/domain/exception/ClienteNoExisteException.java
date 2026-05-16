package pe.edu.tecsup.hexagonal.app.domain.exception;

public class ClienteNoExisteException extends RuntimeException{

    public ClienteNoExisteException() {
        super("Cliente no existe");
    }
}
