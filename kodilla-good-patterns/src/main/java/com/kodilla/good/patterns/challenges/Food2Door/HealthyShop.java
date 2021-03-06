package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.HashMap;
import java.util.Map;

public class HealthyShop implements Supplier {

    private String name;
    private final Map<String, Integer> warehouseOfHealthyShop = new HashMap<>();

    public HealthyShop() {
        this.name = "Healthy Shop";
        putProductsInMap();
    }

    private void putProductsInMap() {
        warehouseOfHealthyShop.put("Chia seeds", 300);
        warehouseOfHealthyShop.put("Protein suplement", 4002);
        warehouseOfHealthyShop.put("Tomato", 800);
    }

    private void updateDepotStatus(String product, Integer quantityOfProducts) {
        Integer depotStatus = warehouseOfHealthyShop.get(product) - quantityOfProducts;
        warehouseOfHealthyShop.put(product, depotStatus);
    }

    public String getName() {
        return name;
    }

    public void process(Order order) {
        if (warehouseOfHealthyShop.containsKey(order.getTypeOfProduct()) && warehouseOfHealthyShop.get(order.getTypeOfProduct()) >= order.getQuantity()) {
            updateDepotStatus(order.getTypeOfProduct(), order.getQuantity());
            System.out.println("Your order number is: " + order.getOrderNumber());
            System.out.println("You ordered " + order.getTypeOfProduct() + " in quantity " + order.getQuantity());
            System.out.println("The order has been transferred for execution");
            System.out.println("Thank you and come back again");
        } else {
            System.out.println("The selected product is not available.");
        }
    }
}

