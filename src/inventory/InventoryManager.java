package inventory;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface InventoryManager {
    List<Product> getInventoryList();

    void addProduct(Product product);

    void updateProductQuantity(String productId, int newQuantity);

    void removeProduct(String productId);

    Optional<Product> getProduct(String productId);

    List<Product> recommendReorders();

    List<Product> findTopNProductsByValue(int n);
}
