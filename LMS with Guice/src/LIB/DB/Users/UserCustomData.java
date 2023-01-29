package LIB.DB.Users;

import LOG.USER.User;

import java.util.ArrayList;
import java.util.List;

public class UserCustomData implements DBUsers{
    private List<User> users;

    public UserCustomData(){
        users=new ArrayList<>();
    }

    @Override
    public void add(List<User> users) {
       users.forEach(this.users::add);
    }

    @Override
    public void delete(List<User> users) {
        users.forEach(this.users::remove);
    }

    @Override
    public List<User> LoadData() {
        return this.users;
    }
}
