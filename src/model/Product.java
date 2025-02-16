package model;

public class Product {
    private String productId;
    private String name;
    private double price;
    private int quantity;
    private int reorderPoint;
    private int reorderAmount;

    public Product(String productId, String name, double price, int quantity, int reorderPoint, int reorderAmount) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.reorderPoint = reorderPoint;
        this.reorderAmount = reorderAmount;
    }

    public Product(Product other) {
        this.productId = other.productId;
        this.name = other.name;
        this.price = other.price;
        this.quantity = other.quantity;
        this.reorderPoint = other.reorderPoint;
        this.reorderAmount = other.reorderAmount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(int reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public int getReorderAmount() {
        return reorderAmount;
    }

    public void setReorderAmount(int reorderAmount) {
        this.reorderAmount = reorderAmount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", reorderPoint=" + reorderPoint +
                ", reorderAmount=" + reorderAmount +
                '}';
    }
}
