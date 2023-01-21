package LIB.DB.Users;

import LOG.USER.User;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

public class UserCustomData implements DBUsers{
    private List<User> users;

    public UserCustomData(){
        users=new ArrayList<>();
    }

    @Override
    @Inject
    public void update(@Named("UserDB") List<User> users) {
       this.users=users;
    }

    @Override
    public List<User> LoadData() {
        return this.users;
    }
}
