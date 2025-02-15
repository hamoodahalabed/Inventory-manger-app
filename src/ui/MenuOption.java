package ui;

public enum MenuOption {
    ADD_PRODUCT("1", "Add Product"),
    UPDATE_QUANTITY("2", "Update Product Quantity"),
    REMOVE_PRODUCT("3", "Remove Product"),
    GET_PRODUCT("4", "Get Product"),
    LIST_PRODUCTS("5", "List All Products"),
    RECOMMEND_REORDERS("6", "Recommend Reorders"),
    TOP_N_PRODUCTS("7", "Find Top N Products by Value");

    private final String command;
    private final String displayText;

    MenuOption(String command, String displayText) {
        this.command = command;
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return command + ". " + displayText;
    }

    public static MenuOption fromCommand(String command) {
        for (MenuOption option : values()) {
            if (option.command.equals(command)) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid command: " + command);
    }
}