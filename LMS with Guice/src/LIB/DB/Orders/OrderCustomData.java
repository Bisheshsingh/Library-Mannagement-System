package LIB.DB.Orders;

import LIB.ORDER.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderCustomData implements DBOrders{
    private List<Order> orders;
    public OrderCustomData(){
        this.orders= new ArrayList<Order>();
    }
    @Override
    public void add(List<Order> orders) {
        orders.forEach(this.orders::add);
    }

    @Override
    public void delete(List<Order> orders) {
        orders.forEach(this.orders::remove);
    }

    @Override
    public List<Order> LoadData() {
        return orders;
    }
}
