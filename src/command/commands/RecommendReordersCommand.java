package command.commands;

import service.InventoryService;

public class RecommendReordersCommand implements InventoryCommand {

    @Override
    public void execute() {
        InventoryService.getInstance().recommendReorders();
    }
}