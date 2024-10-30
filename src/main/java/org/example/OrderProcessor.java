package org.example;

public class OrderProcessor {
    private int totalProcessedOrders = 0;
    private int discountThreshold = 1000;
    private double taxRate = 0.15;

    public void processOrder(String customerId, double orderAmount, String customerType) {
        if (customerType.equals("Regular")) {
            applyDiscount(orderAmount, 5);
        } else if (customerType.equals("VIP")) {
            applyDiscount(orderAmount, 10);
        } else if (customerType.equals("Employee")) {
            applyDiscount(orderAmount, 20);
        } else {
            System.out.println("Unknown customer type: " + customerType);
        }
        totalProcessedOrders++;
        double taxedAmount = calculateTax(orderAmount);
        System.out.println("Processed order for customer " + customerId + ". Final amount after tax: " + taxedAmount);
    }

    private double applyDiscount(double amount, int discountPercentage) {
        if (amount > discountThreshold) {
            amount -= amount * discountPercentage / 100;
        }
        return amount;
    }

    private double calculateTax(double amount) {
        return amount + amount * taxRate;
    }

    public void printTotalOrders() {
        System.out.println("Total orders processed: " + totalProcessedOrders);
    }

    public double calculateTotalRevenue(double[] orderAmounts) {
        double revenue = 0;
        for (int i = 0; i < orderAmounts.length; i++) {
            revenue += orderAmounts[i];
        }
        return revenue;
    }

    public double findHighestOrder(double[] orderAmounts) {
        double maxOrder = 0;
        for (int i = 0; i < orderAmounts.length; i++) {
            if (orderAmounts[i] > maxOrder) {
                maxOrder = orderAmounts[i];
            }
        }
        return maxOrder;
    }
}