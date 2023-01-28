package LOG.DB;
import LOG.USERLOGININFO.UserLoginInfo;

import java.util.List;

public interface DBLogin {
    List<UserLoginInfo> LoadData();

    void update(List<UserLoginInfo> userinfos);
}
