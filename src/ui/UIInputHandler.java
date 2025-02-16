package ui;

import command.CommandInvoker;
import command.commands.*;
import exception.InventoryException;
import model.Product;

import java.util.Scanner;
import java.util.logging.Logger;

public class UIInputHandler {
    private static final Logger logger = Logger.getLogger(UIInputHandler.class.getName());

    private static final class InstanceHolder {
        private static final UIInputHandler instance = new UIInputHandler();
    }

    public static UIInputHandler getInstance() {
        return UIInputHandler.InstanceHolder.instance;
    }

    private final CommandInvoker commandInvoker = CommandInvoker.getInstance();

    private UIInputHandler() {
    }


    public void addProduct(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Product Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Reorder Point: ");
        int reorderPoint = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Reorder Amount: ");
        int reorderAmount = Integer.parseInt(scanner.nextLine());

        Product product = new Product(productId, name, price, quantity, reorderPoint, reorderAmount);
        InventoryCommand command = new AddProductCommand(product);

        try {
            commandInvoker.executeCommand(command);
        } catch (InventoryException e) {
            logger.severe("Error while adding product: " + e.getMessage());
        }
    }


    public void updateProductQuantity(Scanner scanner) {
        System.out.print("Enter Product ID to update quantity: ");
        String productId = scanner.nextLine();
        System.out.print("Enter new quantity: ");
        int newQuantity = Integer.parseInt(scanner.nextLine());

        InventoryCommand command = new UpdateProductQuantityCommand(productId, newQuantity);
        commandInvoker.executeCommand(command);
    }

    public void removeProduct(Scanner scanner) {
        System.out.print("Enter Product ID to remove: ");
        String productId = scanner.nextLine();

        InventoryCommand command = new RemoveProductCommand(productId);
        commandInvoker.executeCommand(command);
    }

    public void getProduct(Scanner scanner) {
        System.out.print("Enter Product ID to retrieve: ");
        String productId = scanner.nextLine();

        InventoryCommand command = new GetProductByIdCommand(productId);
        commandInvoker.executeCommand(command);
    }

    public void listAllProducts() {
        InventoryCommand command = new ListAllProductsCommand();
        commandInvoker.executeCommand(command);
    }

    public void recommendReorders() {
        InventoryCommand command = new RecommendReordersCommand();
        commandInvoker.executeCommand(command);
    }

    public void findTopNProductsByValue(Scanner scanner) {
        System.out.print("Enter the number of top products to retrieve: ");
        int n = Integer.parseInt(scanner.nextLine());

        InventoryCommand command = new FindTopNProductsCommand(n);
        commandInvoker.executeCommand(command);
    }
}
