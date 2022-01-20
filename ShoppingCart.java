package com.example.zoolatech;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> products = new ArrayList<>();
    private DeliveryMethod deliveryMethod;
    private PaymentMethod paymentMethod;

    public List<Product> getProducts() {
        return products;
    }

    public CheckoutResult checkout() {
        if (deliveryMethod == null) {
            return CheckoutResult.DELIVERY_METHOD_NOT_SET;
        } else if (paymentMethod == null) {
            return CheckoutResult.PAYMENT_METHOD_NOT_SET;
        } else if (products == null || products.isEmpty()) {
            return CheckoutResult.CART_IS_EMPTY;
        }

        paymentMethod.pay(this);
        return CheckoutResult.OK;
    }

    public double calculateShippingCost() {
        return deliveryMethod.calculateShippingCost(this);
    }

    public double calculateTotal() {
        return paymentMethod.calculateTotal(this);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
