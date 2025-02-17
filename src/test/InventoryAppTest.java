package test;

import model.Product;
import service.InventoryService;

public class InventoryAppTest {
    private final InventoryService inventoryService;

    public InventoryAppTest() {
        this.inventoryService = InventoryService.getInstance();
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
        inventoryService.addProduct(new Product("P1", "Spark Plug", 15.00, 200, 50, 500));
        inventoryService.addProduct(new Product("P2", "Tire", 120.00, 40, 10, 100));
        inventoryService.addProduct(new Product("P3", "Windshield Wiper Blade", 25.00, 60, 20, 150));
        inventoryService.addProduct(new Product("P4", "Radiator Coolant", 12.00, 80, 20, 200));
        System.out.println();
    }

    private void listAllProducts() {
        System.out.println("Listing all products...");
        inventoryService.listAllProducts();
        System.out.println();
    }

    private void updateProductQuantity() {
        System.out.println("Updating product quantity...");
        inventoryService.updateProductQuantity("P2", 15);
        inventoryService.updateProductQuantity("P3", 10);
        System.out.println();
    }

    private void retrieveProduct() {
        System.out.println("Retrieving a product...");
        inventoryService.getProduct("P1");
        System.out.println();
    }

    private void removeProduct() {
        System.out.println("Removing a product...");
        inventoryService.removeProduct("P4");
        System.out.println();
    }

    private void listAllProductsAfterRemoval() {
        System.out.println("Listing all products after removal...");
        inventoryService.listAllProducts();
        System.out.println();
    }

    private void recommendReorders() {
        System.out.println("Recommending reorders...");
        inventoryService.recommendReorders();
        System.out.println();
    }

    private void findTopNProductsByValue(int n) {
        System.out.println("Finding top " + n + " products by value...");
        inventoryService.findTopNProductsByValue(n);
        System.out.println();
    }
}