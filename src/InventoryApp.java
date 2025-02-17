import test.InventoryAppTest;

public class InventoryApp {
    public static void main(String[] args) {
//        Menu inventoryMenuManager = Menu.getInstance();
//        inventoryMenuManager.start();

        // Run tests
        InventoryAppTest test = new InventoryAppTest();
        test.runTests();
    }
}
