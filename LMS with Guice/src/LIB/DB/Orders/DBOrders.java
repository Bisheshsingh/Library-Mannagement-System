package LIB.DB.Orders;

import LIB.ORDER.Order;

import java.util.List;

public interface DBOrders {
    void add(List<Order> Orders);
    void delete(List<Order> orders);

    List<Order> LoadData();
}
