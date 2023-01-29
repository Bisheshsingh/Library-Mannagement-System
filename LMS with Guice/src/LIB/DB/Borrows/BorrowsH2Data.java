package LIB.DB.Borrows;

import DBM.H2DB;
import LIB.BORROW.Borrow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowsH2Data implements DBBorrows{
    private final String dbname="BorrowInfo";
    private final List<String> params= Arrays.asList("BookID","UserID","StartDate","EndDate");
    @Override
    public void add(List<Borrow> borrows) {
        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
        borrows.forEach(b -> {
            try{
                H2DB.getInstance(dbname)
                        .add(Arrays.asList(
                                String.valueOf(b.getBookID()),
                                String.valueOf(b.getUserID()),
                                ft.format(b.getStartDate()),
                                ft.format(b.getEndDate())
                        )).close();
            }catch (Exception e){

            }
        });
    }

    @Override
    public void delete(List<Borrow> borrows) {
        borrows.forEach(b -> {
            try{
                H2DB.getInstance(dbname)
                        .delete("BookID",String.valueOf(b.getBookID())).close();
            }catch (Exception e){

            }
        });
    }

    @Override
    public List<Borrow> LoadData() {
        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");

        List<Borrow> list = H2DB.getInstance(dbname)
                .access(params)
                .stream()
                .map(ls-> {
                    try {
                        return new Borrow(
                                ft.parse(ls.get(2)),
                                ft.parse(ls.get(3)),
                                Integer.parseInt(ls.get(0)),
                                Integer.parseInt(ls.get(1))
                        );
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());

        return list;
    }
}

