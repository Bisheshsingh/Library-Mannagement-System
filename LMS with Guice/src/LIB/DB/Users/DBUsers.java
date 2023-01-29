package LIB.DB.Users;

import LOG.USER.User;

import java.util.List;

public interface DBUsers {
    void add(List<User> users);
    void delete(List<User> users);

    List<User> LoadData();
}
