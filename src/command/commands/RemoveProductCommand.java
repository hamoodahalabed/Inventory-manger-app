package command.commands;

import service.InventoryService;

public class RemoveProductCommand implements InventoryCommand {
    private final String productId;

    public RemoveProductCommand(String productId) {
        this.productId = productId;
    }

    @Override
    public void execute() {
        InventoryService.getInstance().removeProduct(productId);
    }
}