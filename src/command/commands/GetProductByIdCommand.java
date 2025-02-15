package command.commands;

import service.InventoryService;

public class GetProductByIdCommand implements InventoryCommand {
    private final String productId;

    public GetProductByIdCommand(String productId) {
        this.productId = productId;
    }

    @Override
    public void execute() {
        InventoryService.getInstance().getProduct(productId);
    }
}