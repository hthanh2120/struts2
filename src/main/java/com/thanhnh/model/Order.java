package com.thanhnh.model;

import lombok.Data;

@Data
public class Order {

    String id;
    String clientName;
    int amount;

    public Order() {
    }

    public Order(String id, String clientName, int amount) {
        this.id = id;
        this.clientName = clientName;
        this.amount = amount;
    }
}
