package command.commands;

import service.InventoryService;

public class ListAllProductsCommand implements InventoryCommand {

    @Override
    public void execute() {
        InventoryService.getInstance().listAllProducts();
    }
}