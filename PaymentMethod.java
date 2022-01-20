package com.example.zoolatech;

public interface PaymentMethod {

    double calculateTotal(ShoppingCart shoppingCart);

    boolean pay(ShoppingCart shoppingCart);
}
