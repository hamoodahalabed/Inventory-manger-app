package exception;

public class ProductAlreadyExistsException extends InventoryException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
