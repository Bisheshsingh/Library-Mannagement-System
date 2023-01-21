package LIB.DB.Orders;

import LIB.ORDER.Order;
import LOG.USER.User;

import java.util.List;

public interface DBOrders {
    void update(List<Order> orders);

    List<Order> LoadData();
}
