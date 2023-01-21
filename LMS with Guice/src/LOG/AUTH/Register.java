package LOG.AUTH;

import API.APIFactoryClass;
import LOG.DB.LoginCustomData;
import com.google.inject.Guice;
import com.google.inject.Injector;
import LOG.DB.DBLogin;
import LOG.UserInfo;

import java.util.List;
import java.util.stream.Collectors;

public class Register implements Authentication{
    private DBLogin logdata;

    public Register(){
        Injector injector= Guice.createInjector(new APIFactoryClass());
        this.logdata=injector.getInstance(DBLogin.class);//new LoginCustomData();
    }
    public boolean Check_User(int id){
        List<UserInfo> users=logdata.LoadData().stream()
                .filter(user->user.getID()==id)
                .collect(Collectors.toList());

        return users.isEmpty();
    }

    private void Add_User(UserInfo userInfo){
        List<UserInfo> userinfos=logdata.LoadData();
        userinfos.add(userInfo);
        logdata.update(userinfos);
    }
    @Override
    public boolean Verify(UserInfo user) {
        boolean res=Check_User(user.getID());

        if(res==true){
            Add_User(user);
        }
        return res;
    }
}
