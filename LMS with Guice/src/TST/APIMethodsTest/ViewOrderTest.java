package TST.APIMethodsTest;

import API.LMSAPI;
import API.MSG;
import LIB.USER.Student;
import com.google.inject.Injector;

import static org.junit.Assert.assertTrue;

public class ViewOrderTest implements Test{
    private LMSAPI api;
    public ViewOrderTest(Injector injector) {
        this.api = injector.getInstance(LMSAPI.class);
    }

    public void Check1(){
        System.out.println("\nViewOrderTest() Check 1: Admin Check Initializing...");

        try {
            api.View_Order(new Student(126,"Student"));
        } catch (IllegalAccessException e) {
            assertTrue(e.getMessage().equals(MSG.IllegalAccess().getMessage()));
            System.out.println("ViewOrderTest() Check 1 Passed!");
        }
    }

    @Override
    public void run() {
       Check1();
    }
}
