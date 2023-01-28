package API;

import java.rmi.AlreadyBoundException;
import java.security.InvalidParameterException;

public class MSG {
    public static IllegalAccessException IllegalAccess() {
        return new IllegalAccessException("User is not Authorized to access this");
    }

    public static Exception ItemDoesNotExist() {
        return new IndexOutOfBoundsException("Item not found");
    }

    public static Exception ItemDoesExist() {
        return new AlreadyBoundException("Item exists already");
    }

    public static Exception InvaliParam() {
        return new InvalidParameterException("Invalid Parameters passed");
    }
}
