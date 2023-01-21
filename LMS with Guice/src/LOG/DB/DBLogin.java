package LOG.DB;
import LOG.USER.User;
import LOG.UserInfo;

import java.util.List;

public interface DBLogin {
    List<UserInfo> LoadData();

    void update(List<UserInfo> userinfos);
}
