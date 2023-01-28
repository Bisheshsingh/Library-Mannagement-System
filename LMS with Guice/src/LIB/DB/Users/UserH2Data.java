package LIB.DB.Users;

import DBM.H2DB;
import LOG.USER.Student;
import LOG.USER.User;
import LOG.USERLOGININFO.UserLoginInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserH2Data implements DBUsers{
    private final String dbname="UserInfo";
    private final List<String> params=Arrays.asList("ID","Name");

    @Override
    public void update(List<User> users) {
        users.forEach(u -> {
            try{
                H2DB.getInstance(dbname)
                       .add(Arrays.asList(
                            String.valueOf(u.getID()),
                            u.getName()
                       ));
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
