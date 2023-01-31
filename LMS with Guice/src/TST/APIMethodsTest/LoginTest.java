package TST.APIMethodsTest;

import API.LMSAPI;
import API.MSG;
import LIB.USER.User;
import com.google.inject.Injector;

import static org.junit.Assert.*;

public class LoginTest implements Test{
    private LMSAPI api;
    public LoginTest(Injector injector){
        api = injector.getInstance(LMSAPI.class);
    }
    private void Check1(){
        System.out.println("\nLoginTest() Check 1: Wrong ID/Password Initializing...");
        User user;
        try {
            user = api.Login(12345, "Admin");
            assertNull(user);
        } catch (Exception e) {
            assertTrue(e.getMessage().equals(MSG.IllegalAccess().getMessage()));
            System.out.println("LoginTest() Check 1 Passed!");
        }
    }

    private void Check2(){
        System.out.println("\nLoginTest() Check 2: Invalid Parameters Initializing...");
        try {
            api.Login(-8292, "Admin");
            api.Login(123, null);
            assertFalse(true);
        } catch (Exception e) {
            System.out.println("LoginTest() Check 2 Passed!");
        }
    }

    private void Check3(){
        System.out.println("\nLoginTest() Check 3: Correct ID/Password Initializing...");
        try {
            api.Login(1234, "Admin");
            System.out.println("LoginTest() Check 3 Passed!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
        Check1();
        Check2();
        Check3();
    }
}
