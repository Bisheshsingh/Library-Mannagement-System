package LOG.AUTH;

import API.GuiceConfig;
import LOG.DB.DBLogin;
import LOG.USERLOGININFO.UserLoginInfo;

import java.util.List;
import java.util.stream.Collectors;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class LoginCheck implements Authentication{
    private DBLogin logindata;

    public LoginCheck(){
        Injector injector= Guice.createInjector(new GuiceConfig());
        this.logindata=injector.getInstance(DBLogin.class);;
    }

    private boolean Check_User(int id,String password){
        List<UserLoginInfo> users=logindata.LoadData().stream()
                .filter(user->user.getID()==id)
                .collect(Collectors.toList());


        if(users.isEmpty() || !users.get(0).getPassword().equals(password)){
            return false;
        }

        return true;
    }

    @Override
    public boolean Verify(Object u) {
        UserLoginInfo user=((UserLoginInfo) u);
        return Check_User(user.getID(), user.getPassword());
    }
}
