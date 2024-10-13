public class Main {
    public static void main(String[] args) {
        ShoppingFacade Shoppingfacade = new ShoppingFacade();

        String productID = "mk09";
        String paymentInfo = "1111-2222-3333-4444";
        String shippingAddress = "Astana, KZ";

        Shoppingfacade.placeOrder(productID, paymentInfo, shippingAddress);
    }
}