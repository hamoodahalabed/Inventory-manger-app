package ui;

import java.util.Scanner;

public class Menu {
    private final UIInputHandler inputHandler = UIInputHandler.getInstance();

    private static final class InstanceHolder {
        private static final Menu instance = new Menu();
    }

    public static Menu getInstance() {
        return Menu.InstanceHolder.instance;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                displayMenu();
                String command = scanner.nextLine().trim().toLowerCase();

                if (command.equals("exit")) {
                    System.out.println("Exiting program...");
                    break;
                }

                try {
                    MenuOption option = MenuOption.fromCommand(command);
                    handleCommand(option, scanner);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Inventory Management System ---");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getDisplayText());
        }
        System.out.println("Type 'exit' to quit.");
        System.out.print("Choose an option: ");
    }

    private void handleCommand(MenuOption option, Scanner scanner) {
        switch (option) {
            case ADD_PRODUCT:
                inputHandler.addProduct(scanner);
                break;
            case UPDATE_QUANTITY:
                inputHandler.updateProductQuantity(scanner);
                break;
            case REMOVE_PRODUCT:
                inputHandler.removeProduct(scanner);
                break;
            case GET_PRODUCT:
                inputHandler.getProduct(scanner);
                break;
            case LIST_PRODUCTS:
                inputHandler.listAllProducts();
                break;
            case RECOMMEND_REORDERS:
                inputHandler.recommendReorders();
                break;
            case TOP_N_PRODUCTS:
                inputHandler.findTopNProductsByValue(scanner);
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + option);
        }
    }
}
