package command.commands;

import service.InventoryService;

public class UpdateProductQuantityCommand implements InventoryCommand {
    private final String productId;
    private final int quantity;

    public UpdateProductQuantityCommand(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        InventoryService.getInstance().updateProductQuantity(productId, quantity);
    }
}