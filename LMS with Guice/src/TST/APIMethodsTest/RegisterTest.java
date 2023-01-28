package TST.APIMethodsTest;

import API.GuiceConfig;
import API.LMSAPI;
import API.MSG;
import LOG.AUTH.RegisterCheck;
import com.google.inject.Guice;

import static org.junit.Assert.assertTrue;

public class RegisterTest implements Test{
    private LMSAPI api;
    public RegisterTest(){
        api= Guice.createInjector(new GuiceConfig()).getInstance(LMSAPI.class);
    }

    private void Check1(){
        System.out.println("\nRegisterTest() 1: If ID already exists Initializing...");

        try {
            api.Register(1234, "Bishesh", "Admin");
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(e.toString().equals(MSG.ItemDoesExist().toString()));
            System.out.println("RegisterTest() 1 Passed!");
        }
    }

    private void Check2(){
        System.out.println("\nRegisterTest() 2: If ID is added or not Initializing...");

        try {
            api.Register(456, "Sunil", "Student");
            api.Login(456, "Student");
            System.out.println("Register Check 2 Passed!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private  void Check3(){
        System.out.println("\nRegisterTest() 3: Invalid Parameters Initializing...");

        try {
            api.Register(-67799, "Sunil", "Student");
            api.Register(234, null, "Student");
            api.Register(789, "Sunil", "");

            assertTrue(false);
        } catch (Exception e) {
            System.out.println("Register Check 3 Passed!");
        }
    }

    @Override
    public void run() {
        Check1();
        Check2();
        Check3();
    }
}
