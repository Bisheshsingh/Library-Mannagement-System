package LOG.AUTH;

import LOG.USER.User;
import LOG.UserInfo;

public interface Authentication {
    public boolean Verify(UserInfo user);
}
