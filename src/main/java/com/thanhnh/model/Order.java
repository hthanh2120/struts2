package com.thanhnh.model;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;

@Data
public class Order extends ActionSupport {

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
