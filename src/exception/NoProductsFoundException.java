package exception;

public class NoProductsFoundException extends InventoryException {
    public NoProductsFoundException(String message) {
        super(message);
    }
}
