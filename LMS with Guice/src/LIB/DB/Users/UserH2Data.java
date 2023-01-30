package LIB.DB.Users;

import DBM.H2DB;
import LIB.USER.Student;
import LIB.USER.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserH2Data implements DBUsers{
    private final String dbname="UserInfo";
    private final List<String> params=Arrays.asList("ID","Name");

    @Override
    public void add(List<User> users) {
        users.forEach(u -> {
            try{
                H2DB.getInstance(dbname)
                       .add(Arrays.asList(
                            String.valueOf(u.getID()),
                            u.getName()
                       )).close();
            }catch (Exception e){

            }
        });
    }

    @Override
    public void delete(List<User> users) {
        users.forEach(u -> {
            try{
                H2DB.getInstance(dbname)
                        .delete("ID",String.valueOf(u.getID())).close();
            }catch (Exception e){

            }
        });
    }

    @Override
    public List<User> LoadData() {
        List<User> list = H2DB.getInstance(dbname)
                .access(params)
                .stream()
                .map(ls->new Student(
                        Integer.parseInt(ls.get(0)),
                        ls.get(1)
                )).collect(Collectors.toList());

        return list;
    }
}
