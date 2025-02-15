package exception;

public class EmptyInventoryException extends InventoryException {
    public EmptyInventoryException(String message) {
        super(message);
    }
}