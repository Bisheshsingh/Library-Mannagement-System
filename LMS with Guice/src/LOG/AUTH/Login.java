package LOG.AUTH;

import API.APIFactoryClass;
import LIB.DB.Users.DBUsers;
import LOG.DB.DBLogin;
import LOG.DB.LoginCustomData;
import LOG.USER.User;
import LOG.UserInfo;

import java.util.List;
import java.util.stream.Collectors;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Login implements Authentication{
    private DBLogin logindata;

    public Login(){
        Injector injector= Guice.createInjector(new APIFactoryClass());
        this.logindata=injector.getInstance(DBLogin.class);//new LoginCustomData();
    }

    private boolean Check_User(int id,String password){
        List<UserInfo> users=logindata.LoadData().stream()
                .filter(user->user.getID()==id)
                .collect(Collectors.toList());

        if(users.isEmpty() || !users.get(0).getPassword().equals(password)){
            return false;
        }

        return true;
    }

    @Override
    public boolean Verify(UserInfo user) {
        return Check_User(user.getID(), user.getPassword());
    }
}
