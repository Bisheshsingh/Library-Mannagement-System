package LIB.DB.Books;

import DBM.H2DB;
import LIB.BOOK.Book;
import LIB.BOOK.Novel;
import LOG.USERLOGININFO.UserLoginInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookH2Data implements DBBooks{
    private final String dbname="BookInfo";
    private final List<String> params= Arrays.asList("ID","Name","Authors","IsAvailable");
    @Override
    public void update(List<Book> books) {
        books.forEach(b -> {
            try{
                Optional<String> ba = b.getAuthors().stream().reduce((c,d)->c+","+d);
                H2DB.getInstance(dbname)
                        .add(Arrays.asList(
                                String.valueOf(b.getID()),
                                b.getName(),
                                ba.get(),
                                String.valueOf(b.isAvailable())
                        ));
            }catch (Exception e){

            }
        });
    }

    @Override
    public List<Book> LoadData() {
        List<Book> list = H2DB.getInstance(dbname)
                .access(params)
                .stream()
                .map(ls->new Novel(
                        Integer.parseInt(ls.get(0)),
                        ls.get(1),
                        ls.get(2).split(","),
                        Boolean.parseBoolean(ls.get(3))
                )).collect(Collectors.toList());

        return list;
    }
}
