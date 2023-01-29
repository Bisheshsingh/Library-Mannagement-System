package LOG.DB;

import DBM.H2DB;
import LOG.USER.Student;
import LOG.USER.User;
import LOG.USERLOGININFO.UserLoginInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoginH2Data implements DBLogin{
    private final String dbname="LoginInfo";
    private final List<String> params = Arrays.asList("ID","Password");
    @Override
    public List<UserLoginInfo> LoadData() {
        List<UserLoginInfo> list = H2DB.getInstance(dbname)
                .access(params)
                .stream()
                .map(ls->new UserLoginInfo(
                        Integer.parseInt(ls.get(0)),
                        ls.get(1)
                )).collect(Collectors.toList());

        return list;
    }

    @Override
    public void update(List<UserLoginInfo> userinfos) {
         userinfos.forEach(u -> {
            try{
                H2DB.getInstance(dbname)
                        .add(Arrays.asList(
                                String.valueOf(u.getID()),
                                u.getPassword()
                        )).close();
            }catch (Exception e){

            }
        });
    }
}
