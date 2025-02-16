package service;

import exception.*;
import inventory.InventoryManager;
import inventory.InventoryManagerImpl;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class InventoryService {
    private static final Logger logger = Logger.getLogger(InventoryService.class.getName());
    private final InventoryManager inventoryManager;

    public InventoryService() {
        this.inventoryManager = InventoryManagerImpl.getInstance();
    }

    private static final class InstanceHolder {
        private static final InventoryService instance = new InventoryService();
    }

    public static InventoryService getInstance() {
        return InventoryService.InstanceHolder.instance;
    }

    public void addProduct(Product product) {
        validProductOrThrow(product);
        try {
            inventoryManager.addProduct(product);
            System.out.println("Product added successfully: " + product.getName());
        } catch (ProductAlreadyExistsException e) {
            handleException(e, "Error adding product.");
        }
    }

    public void updateProductQuantity(String productId, int newQuantity) {
        if (newQuantity < 0) {
            System.out.println("Error: Quantity cannot be negative. Quantity: " + newQuantity);
            return;
        }
        try {
            inventoryManager.updateProductQuantity(productId, newQuantity);
            System.out.println("Product quantity updated for this product id: {" + productId + "} to be " + newQuantity + "pieces.");
        } catch (NoProductsFoundException e) {
            handleException(e, "Error updating product quantity.");
        }
    }

    public void removeProduct(String productId) {
        try {
            inventoryManager.removeProduct(productId);
            System.out.println("Product with id: " + productId + " removed.");
        } catch (NoProductsFoundException e) {
            handleException(e, "Error removing product.");
        }
    }

    public void getProduct(String productId) {
        try {
            Optional<Product> product = inventoryManager.getProduct(productId);
            product.ifPresentOrElse(System.out::println, () -> System.out.println("Product not found."));
        } catch (NoProductsFoundException e) {
            handleException(e, "Error fetching product.");
        }
    }

    public void listAllProducts() {
        try {
            List<Product> products = inventoryManager.getInventoryList();
            if (products.isEmpty()) {
                System.out.println("No products available in inventory.");
            } else {
                products.forEach(System.out::println);
            }
        } catch (EmptyInventoryException e) {
            handleException(e, "Error listing products.");
        }
    }

    public void recommendReorders() {
        try {
            List<Product> productsToReorder = inventoryManager.recommendReorders();
            if (productsToReorder.isEmpty()) {
                System.out.println("No products need to be reordered.");
            } else {
                productsToReorder.forEach(p -> System.out.println("Reorder: " + p.getName()));
            }
        } catch (EmptyInventoryException e) {
            handleException(e, "Error recommending reorders.");
        }
    }

    public void findTopNProductsByValue(int n) {
        try {
            List<Product> topProducts = inventoryManager.findTopNProductsByValue(n);
            if (topProducts.isEmpty()) {
                System.out.println("No top products found.");
            } else {
                System.out.println("Top " + n + " products by value:");
                topProducts.forEach(p -> System.out.println(p.getName() + " - Value: " + p.getPrice() * p.getQuantity()));
            }
        } catch (EmptyInventoryException e) {
            handleException(e, e.getMessage());
        }
    }

    private void validProductOrThrow(Product product) {
        List<String> validationErrors = new ArrayList<>();
        if (product.getProductId() == null || product.getProductId().isEmpty()) {
            validationErrors.add("Product ID cannot be empty");
        }
        if (product.getName() == null || product.getName().isEmpty()) {
            validationErrors.add("Product name cannot be empty");
        }
        if (product.getPrice() <= 0) {
            validationErrors.add("Product price must be greater than zero");
        }
        if (product.getQuantity() < 0) {
            validationErrors.add("Product quantity cannot be negative");
        }
        if (product.getReorderPoint() < 0) {
            validationErrors.add("Reorder point cannot be negative");
        }
        if (product.getReorderAmount() < 0) {
            validationErrors.add("Reorder amount cannot be negative");
        }
        if (!validationErrors.isEmpty()) {
            throw new ProductAdditionException(String.join(", ", validationErrors + "."));
        }
    }

    private void handleException(InventoryException e, String customMessage) {
        logger.severe(customMessage + " Details: " + e.getMessage());
        System.out.println("An error occurred: " + customMessage);
    }
}
