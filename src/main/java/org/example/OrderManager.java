package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private static int totalOrders;
    private double totalRevenue;
    private List<String> vipCustomerIds;
    private final double TAX_RATE = 0.1;
    private double lastOrderAmount;
    private String lastCustomerId;

    public OrderManager() {
        vipCustomerIds = new ArrayList<>();
        totalOrders = 0;
        totalRevenue = 0;
    }

    public void processOrder(String customerId, double orderAmount, String customerType, String orderId) {
        if (orderId != null && orderId.startsWith("A")) {
            System.out.println("Processing priority order for customer " + customerId);
        } else {
            System.out.println("Processing regular order for customer " + customerId);
        }

        applyDiscount(orderAmount, customerType);
        double taxedAmount = calculateTax(orderAmount);
        if (customerType.equals("VIP") && !vipCustomerIds.contains(customerId)) {
            vipCustomerIds.add(customerId);
        }
        lastOrderAmount = taxedAmount;
        lastCustomerId = customerId;
        totalRevenue += taxedAmount;
        totalOrders++;
    }

    private void applyDiscount(double orderAmount, String customerType) {
        int discount;
        switch (customerType) {
            case "VIP": discount = 10; break;
            case "Employee": discount = 20; break;
            case "Regular": discount = 5; break;
            default: discount = 0;
        }
        orderAmount -= orderAmount * discount / 100;
    }

    private double calculateTax(double amount) {
        return amount + (amount * TAX_RATE);
    }

    public void displayLastOrderDetails() {
        System.out.println("Last order amount: " + lastOrderAmount + " for customer: " + lastCustomerId);
    }

    public void showTotalOrders() {
        System.out.println("Total orders processed: " + totalOrders);
    }

    public void displayTotalRevenue() {
        System.out.println("Total revenue: " + totalRevenue);
    }

    public void showVIPCustomerList() {
        System.out.println("VIP customers:");
        for (String customerId : vipCustomerIds) {
            System.out.println(" - " + customerId);
        }
    }

    public double findHighestOrderAmount(double[] orderAmounts) {
        double maxOrder = 0;
        for (double orderAmount : orderAmounts) {
            if (orderAmount > maxOrder) {
                maxOrder = orderAmount;
            }
        }
        return maxOrder;
    }
}