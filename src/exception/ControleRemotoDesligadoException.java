package exception;

public class ControleRemotoDesligadoException extends Exception {
    public ControleRemotoDesligadoException() {
        super("Operação não permitida! ");
    }
}
