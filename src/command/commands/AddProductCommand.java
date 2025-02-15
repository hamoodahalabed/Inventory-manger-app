package command.commands;

import model.Product;
import service.InventoryService;

public class AddProductCommand implements InventoryCommand {
    private final Product product;

    public AddProductCommand(Product product) {
        this.product = product;
    }

    @Override
    public void execute() {
        InventoryService.getInstance().addProduct(product);
    }
}