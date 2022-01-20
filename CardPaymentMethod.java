package com.example.zoolatech;

public class CardPaymentMethod implements PaymentMethod {

    private static final double PAYMENT_FEE = 10.0;

    private PaymentSystemMock paymentSystemMock;

    @Override
    public double calculateTotal(ShoppingCart shoppingCart) {
        double sum = shoppingCart.getProducts()
                .stream()
                .map(Product::getPrice)
                .mapToDouble(value -> value)
                .sum();
        return sum + PAYMENT_FEE;
    }

    @Override
    public boolean pay(ShoppingCart shoppingCart) {
        double total = shoppingCart.calculateTotal();
        double shippingCost = shoppingCart.calculateShippingCost();
        return paymentSystemMock.pay(shippingCost, total);
    }
}
