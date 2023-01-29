package LIB.DB.Orders;

import DBM.H2DB;
import LIB.ORDER.Order;
import LIB.ORDER.RequestBook;
import LIB.ORDER.RequestReturnBook;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderH2Data implements DBOrders{
    private final String dbname = "OrderInfo";
    private final List<String> params= Arrays.asList("Type","UserID","BookID","StartDate","EndDate");
    @Override
    public void add(List<Order> orders) {
        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
        orders.forEach(u -> {
            try{
                H2DB.getInstance(dbname)
                        .add(Arrays.asList(
                                u.getClass().toString(),
                                String.valueOf(u.getUserID()),
                                String.valueOf(u.getBookID()),
                                ft.format(u.getStartDate()),
                                ft.format(u.getEndDate())
                        )).close();
            }catch (Exception e){

            }
        });
    }

    @Override
    public void delete(List<Order> orders) {
        orders.forEach(u -> {
            try{
                H2DB.getInstance(dbname)
                        .delete("BookID",String.valueOf(u.getBookID())).close();
            }catch (Exception e){

            }
        });
    }
    @Override
    public List<Order> LoadData() {
        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");

        List<Order> list = H2DB.getInstance(dbname)
                .access(params)
                .stream()
                .map(ls -> {
                    if(ls.get(0).equals(RequestBook.class.toString())){
                        try {
                            return new RequestBook(
                                    Integer.parseInt(ls.get(1)),
                                    Integer.parseInt(ls.get(2)),
                                    ft.parse(ls.get(3)),
                                    ft.parse(ls.get(4))
                            );
                        }catch (Exception e){
                            throw new RuntimeException(e);
                        }
                    }else{
                        try {
                            return new RequestReturnBook(
                                    Integer.parseInt(ls.get(1)),
                                    Integer.parseInt(ls.get(2)),
                                    ft.parse(ls.get(3)),
                                    ft.parse(ls.get(4))
                            );
                        }catch (Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                })
                .collect(Collectors.toList());

        return list;
    }
}
