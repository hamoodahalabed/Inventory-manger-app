# Product Inventory Management System

This is a console-based Java application for managing a retail store's inventory, providing functionality for tracking, updating, and optimizing product stocks.

## Features

### Product Tracking
- **Attributes:**
  - `productId`: Unique identifier.
  - `name`: Product name.
  - `price`: Price per unit.
  - `quantity`: Current quantity in stock.
  - `reorderPoint`: Stock level to trigger a reorder.
  - `reorderAmount`: Quantity to reorder when stock reaches the reorder point.

### Inventory Operations
- **Add Products:** Prevents duplicate product IDs.
- **Update Quantities:** Handles non-existent products and invalid updates.
- **Retrieve Product Information:** Fetch details using product ID.
- **List All Products:** View all products in the inventory.
- **Remove Products:** Deletes products by ID.

### Stock Optimization
- **`recommendReorders()`:**
  - Identifies products needing restocking (quantity ≤ reorderPoint).
  - Returns a list of products to reorder.
- **`findTopNProductsByValue(int n)`:**
  - Calculates total value (`price * quantity`) of each product.
  - Returns a list of the top `n` products by value, sorted in descending order.


## Demonstration
The application provides an interactive terminal interface to:
- Add new products.
- Update product quantities.
- Retrieve specific or all products.
- Remove products.
- Show reordering recommendations.
- Display top `n` products by total value.
