package LIB.DB.Orders;

import LIB.ORDER.Order;
import LIB.ORDER.RequestBook;
import LIB.ORDER.RequestReturnBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderCustomData implements DBOrders{
    private List<Order> orders;
    public OrderCustomData(){
        this.orders= new ArrayList<Order>();
    }
    @Override
    public void update(List<Order> orders) {
        this.orders=orders;
    }

    @Override
    public List<Order> LoadData() {
        return orders;
    }
}
