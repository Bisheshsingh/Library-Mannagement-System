package LOG.DB;

import LOG.USER.User;
import LOG.UserInfo;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

public class LoginCustomData implements DBLogin{
    private List<UserInfo> userinfos;

    public LoginCustomData(){
        userinfos=new ArrayList<UserInfo>();
    }

    @Override
    public List<UserInfo> LoadData() {
        return this.userinfos;
    }

    @Override
    @Inject
    public void update(@Named("UserinfoDB") List<UserInfo> userinfos) {
        this.userinfos=userinfos;
    }
}
