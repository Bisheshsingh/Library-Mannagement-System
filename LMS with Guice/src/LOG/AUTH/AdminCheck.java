package LOG.AUTH;

import LIB.USER.User;

public class AdminCheck implements Authentication{
    public boolean Verify(Object u) {
        User user=((User) u);
        return String.valueOf(user.getID()).length()==4;
    }
}
