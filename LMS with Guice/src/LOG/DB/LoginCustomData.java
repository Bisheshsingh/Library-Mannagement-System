package LOG.DB;

import LOG.USERLOGININFO.UserLoginInfo;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

public class LoginCustomData implements DBLogin {
    private List<UserLoginInfo> userinfos;

    public LoginCustomData(){
        this.userinfos=new ArrayList<UserLoginInfo>();
    }

    @Override
    public List<UserLoginInfo> LoadData() {
        return this.userinfos;
    }
    @Override
    @Inject
    public void update(@Named("UserinfoDB") List<UserLoginInfo> userinfos) {
        this.userinfos=userinfos;
    }
}
