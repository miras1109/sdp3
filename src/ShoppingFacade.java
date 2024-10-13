public class ShoppingFacade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    public ShoppingFacade() {
        this.productCatalog = new ProductCatalog();
        this.paymentProcessor = new PaymentProcessor();
        this.inventoryManager = new InventoryManager();
        this.shippingService = new ShippingService();
    }
    public void placeOrder(String productID, String paymentInfo, String shippingAddress) {
        String product = productCatalog.findProduct(productID);

        if (!inventoryManager.checkInStock(productID)) {
            System.out.println("Product is out of stock");
            return;
        }

        if (!paymentProcessor.processPayment(paymentInfo)) {
            System.out.println("Payment failed");
            return;
        }

        double shippingCost = shippingService.calculateShipping(shippingAddress);
        System.out.println("Shipping cost: " + shippingCost);

        shippingService.ShippingProduct(productID, shippingAddress);

        System.out.println("Order placed!");
    }
}