package test;

import command.CommandInvoker;
import command.commands.*;
import model.Product;

public class InventoryAppTest {
    private final CommandInvoker commandInvoker;

    public InventoryAppTest() {
        this.commandInvoker = CommandInvoker.getInstance();
    }

    public void runTests() {
        addProducts();
        listAllProducts();
        updateProductQuantity();
        retrieveProduct();
        removeProduct();
        listAllProductsAfterRemoval();
        recommendReorders();
        findTopNProductsByValue(2);
        findTopNProductsByValue(3);
    }

    private void addProducts() {
        System.out.println("Adding products...");
        commandInvoker.executeCommand(new AddProductCommand(new Product("P1", "Car Battery", 120.0, 30, 5, 50)));
        commandInvoker.executeCommand(new AddProductCommand(new Product("P2", "Brake Disc", 80.0, 10, 5, 40)));
        commandInvoker.executeCommand(new AddProductCommand(new Product("P3", "Engine Oil", 45.0, 0, 10, 30)));
        commandInvoker.executeCommand(new AddProductCommand(new Product("P4", "Air Filter", 25.0, 100, 20, 200)));
        System.out.println();

    }

    private void listAllProducts() {
        System.out.println("Listing all products...");
        commandInvoker.executeCommand(new ListAllProductsCommand());
        System.out.println();
    }

    private void updateProductQuantity() {
        System.out.println("Updating product quantity...");
        commandInvoker.executeCommand(new UpdateProductQuantityCommand("P2", 15));
        commandInvoker.executeCommand(new UpdateProductQuantityCommand("P3", 10));
        System.out.println();
    }

    private void retrieveProduct() {
        System.out.println("Retrieving a product...");
        commandInvoker.executeCommand(new GetProductByIdCommand("P1"));
        System.out.println();
    }

    private void removeProduct() {
        System.out.println("Removing a product...");
        commandInvoker.executeCommand(new RemoveProductCommand("P4"));
        System.out.println();
    }

    private void listAllProductsAfterRemoval() {
        System.out.println("Listing all products after removal...");
        commandInvoker.executeCommand(new ListAllProductsCommand());
        System.out.println();
    }

    private void recommendReorders() {
        System.out.println("Recommending reorders...");
        commandInvoker.executeCommand(new RecommendReordersCommand());
        System.out.println();
    }

    private void findTopNProductsByValue(int n) {
        System.out.println("Finding top " + n + " products by value...");
        commandInvoker.executeCommand(new FindTopNProductsCommand(n));
        System.out.println();
    }
}