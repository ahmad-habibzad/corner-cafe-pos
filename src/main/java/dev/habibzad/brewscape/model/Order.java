package dev.habibzad.brewscape.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private static int ID_GENERATOR = 1001;
    // TODO Add cashier name, notes
    // TODO Create a DAO layer

    private final int orderId;
    private String customerName;
    private List<Product> orderedProducts;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timeStamp;
    private String status;

    public Order(String customerName, List<Product> orderedProducts) {
        this.orderId = ID_GENERATOR++;
        this.customerName = customerName;
        this.orderedProducts = orderedProducts;
        this.timeStamp = LocalDateTime.now();
        this.status = "Ordered";
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderedProducts(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getOrderId() {
        return orderId;
    }
}
