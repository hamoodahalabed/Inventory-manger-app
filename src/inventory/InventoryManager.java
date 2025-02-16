package inventory;

import exception.EmptyInventoryException;
import exception.NoProductsFoundException;
import exception.ProductAlreadyExistsException;
import model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class InventoryManager implements IInventoryManager {

    private final Map<String, Product> inventory;

    private InventoryManager() {
        inventory = new HashMap<>(); // or we can use ConcurrentHashMap if the application is multithreaded
    }

    private static final class InstanceHolder {
        private static final InventoryManager instance = new InventoryManager();
    }

    public static InventoryManager getInstance() {
        return InstanceHolder.instance;
    }

    @Override
    public List<Product> getInventoryList() {
        ensureInventoryIsNotEmptyOrThrow();
        return inventory.values().stream()
                .map(this::cloneProduct)  // Create a new instance of Product to prevent modification of original inventory
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(Product product) {
        ensureProductDoesNotExistOrThrow(product.getProductId());
        inventory.put(product.getProductId(), product);
    }

    @Override
    public void updateProductQuantity(String productId, int newQuantity) {
        ensureProductExistsOrThrow(productId);
        Product product = inventory.get(productId);
        product.setQuantity(newQuantity);

    }

    @Override
    public void removeProduct(String productId) {
        ensureProductExistsOrThrow(productId);
        inventory.remove(productId);
    }

    @Override
    public Optional<Product> getProduct(String productId) {
        return Optional.ofNullable(Optional.ofNullable(inventory.get(productId))
                .orElseThrow(() -> new NoProductsFoundException("Product not found with ID: " + productId)));
    }

    // These methods (recommendReorders, findTopNProductsByValue) return a defensive copy of
    // the products to ensure that any modifications to the list
    // do not affect the original inventory data.
    @Override
    public List<Product> recommendReorders() {
        ensureInventoryIsNotEmptyOrThrow();
        return inventory.values().stream()
                .filter(p -> p.getQuantity() <= p.getReorderPoint())
                .map(this::cloneProduct)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findTopNProductsByValue(int n) {
        ensureInventoryIsNotEmptyOrThrow();
        return inventory.values().stream()
                .sorted(Comparator.comparingDouble((Product p) -> p.getPrice() * p.getQuantity()).reversed())
                .limit(n)
                .map(this::cloneProduct)
                .collect(Collectors.toList());
    }

    private Product cloneProduct(Product product) {
        return new Product(product);
    }

    private void ensureInventoryIsNotEmptyOrThrow() {
        if (inventory.isEmpty()) {
            throw new EmptyInventoryException("Inventory is empty.");
        }
    }

    private void ensureProductExistsOrThrow(String productId) {
        if (!inventory.containsKey(productId)) {
            throw new NoProductsFoundException("Product not found with ID: " + productId);
        }
    }

    private void ensureProductDoesNotExistOrThrow(String productId) {
        if (inventory.containsKey(productId)) {
            throw new ProductAlreadyExistsException("Product with ID " + productId + " already exists.");
        }
    }
}