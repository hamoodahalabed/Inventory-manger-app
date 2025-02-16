package command;

import command.commands.InventoryCommand;

public class CommandInvoker {

    private CommandInvoker() {
    }

    private static final class InstanceHolder {
        private static final CommandInvoker instance = new CommandInvoker();
    }

    public static CommandInvoker getInstance() {
        return CommandInvoker.InstanceHolder.instance;
    }

    public void executeCommand(InventoryCommand command) {
        command.execute();
    }
}
