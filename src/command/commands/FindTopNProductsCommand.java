package command.commands;

import service.InventoryService;

public class FindTopNProductsCommand implements InventoryCommand {
    private final int n;

    public FindTopNProductsCommand(int n) {
        this.n = n;
    }

    @Override
    public void execute() {
        InventoryService.getInstance().findTopNProductsByValue(n);
    }
}