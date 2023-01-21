package API;

import java.rmi.AlreadyBoundException;

public class MSG {
    public static Exception IllegalAccess() {
        return new IllegalAccessException("User is not Authorized to access this");
    }

    public static Exception ItemDoesNotExist() {
        return new IndexOutOfBoundsException("Item not found");
    }

    public static Exception ItemDoesExist() {
        return new AlreadyBoundException("Item exists already");
    }
}
