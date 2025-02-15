package inventory;

import model.Product;

import java.util.List;

public interface IInventoryManager {
    List<Product>  getInventoryList();
    void addProduct(Product product);
    void updateProductQuantity(String productId, int newQuantity);
    void removeProduct(String productId);
    Product getProduct(String productId);
    List<Product> recommendReorders();
    List<Product> findTopNProductsByValue(int n);
}
