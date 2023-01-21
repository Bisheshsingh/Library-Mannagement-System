package LIB.DB.Users;

import LOG.USER.User;

import java.util.List;

public interface DBUsers {
    void update(List<User> users);

    List<User> LoadData();
}
