package LOG.AUTH;

import API.GuiceConfig;
import LOG.DB.LoginCustomData;
import com.google.inject.Guice;
import com.google.inject.Injector;
import LOG.DB.DBLogin;
import LOG.USERLOGININFO.UserLoginInfo;

import java.util.List;
import java.util.stream.Collectors;

public class RegisterCheck implements Authentication{
    private DBLogin logdata;

    public RegisterCheck(){
        Injector injector= Guice.createInjector(new GuiceConfig());
        this.logdata=injector.getInstance(DBLogin.class);
    }
    public boolean Check_User(int id){
        List<UserLoginInfo> users=logdata.LoadData().stream()
                .filter(user->user.getID()==id)
                .collect(Collectors.toList());

        return users.isEmpty();
    }

    public void Add_User(UserLoginInfo userInfo){
        List<UserLoginInfo> userinfos=logdata.LoadData();

        userinfos.add(userInfo);
        logdata.update(userinfos);
    }
    @Override
    public boolean Verify(Object u) {
        UserLoginInfo user=((UserLoginInfo) u);

        boolean res=Check_User(user.getID());

        if(res==true){
            Add_User(user);
        }
        return res;
    }
}
