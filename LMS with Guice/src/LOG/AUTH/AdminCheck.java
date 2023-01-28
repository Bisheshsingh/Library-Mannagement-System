package LOG.AUTH;

import LOG.USER.User;
import LOG.USERLOGININFO.UserLoginInfo;

public class AdminCheck implements Authentication{
    public boolean Verify(Object u) {
        User user=((User) u);
        return String.valueOf(user.getID()).length()==4;
    }
}
