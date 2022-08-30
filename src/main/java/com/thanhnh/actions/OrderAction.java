package com.thanhnh.actions;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import com.thanhnh.model.Order;
import com.thanhnh.service.OrdersService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Data
public class OrderAction extends ActionSupport {

    private List<Order> lst;
    private String id;
    private Order order;

    private OrdersService ordersService = new OrdersService();

    public String save() {
        if (order.getId() == null) {
            addActionMessage("Order saved successfully");
        } else {
            addActionMessage("Order updated successfully");
        }
        ordersService.save(order);
        return SUCCESS;
    }

    @Override
    public String execute() {
        lst = ordersService.getAll();
        return SUCCESS;
    }

    public String edit() {
        if (ordersService.get(id) == null) {
            addActionError("Order not found");
        } else {
            ordersService.update(id, order);
            addActionMessage("Order updated successfully");
        }
        return SUCCESS;
    }

    public String del() {
        if (ordersService.get(id) == null) {
            addActionError("Order not found");
        } else {
            ordersService.remove(id);
            addActionMessage("Order deleted successfully");
        }
        return SUCCESS;
    }

    public String findById() {
        if (ordersService.get(id) == null) {
            addActionMessage("Order not existed");
        } else {
            ordersService.get(id);
        }
        return SUCCESS;
    }

    public void validate() {
        if (StringUtils.isEmpty(order.getClientName())) {
            addFieldError("clientName", "Field name required");
        }
    }
}
