package com.example.zoolatech;

class USPSDelivery implements DeliveryMethod {

    @Override
    public double calculateShippingCost(ShoppingCart cart) {
        return cart.getProducts()
                .stream()
                .map(Product::getWeight)
                .mapToDouble(value -> value)
                .sum();
    }
}
