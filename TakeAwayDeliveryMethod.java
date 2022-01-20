package com.example.zoolatech;

public class TakeAwayDeliveryMethod implements DeliveryMethod {

    @Override
    public double calculateShippingCost(ShoppingCart cart) {
        return 0;
    }
}
