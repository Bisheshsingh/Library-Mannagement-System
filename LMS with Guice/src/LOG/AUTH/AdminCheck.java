package LOG.AUTH;

import LOG.USER.User;

public class AdminCheck{
    public boolean Verify(User user) {
        return String.valueOf(user.getID()).length()==4;
    }
}
