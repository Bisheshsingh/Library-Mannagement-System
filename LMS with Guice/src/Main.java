import DBM.H2DB;
import TST.APITest.Tester_1;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
    @Test
    public void APITesting(){
        Result result = JUnitCore.runClasses(Tester_1.class);
        System.out.println("\n----------------------------------------------\n");

        System.out.println("Test Results : "+(result.wasSuccessful() ? "Passed" : "Failed"));

        if(result.wasSuccessful()){
            clear();
            System.out.println("\n----------------------------------------------\n");
            return;
        }

        System.out.println("\nFailure Count : "+result.getFailures().size());
        System.out.println("\nFailure Tracks :-\n");

        for (Failure failure : result.getFailures()) {
            System.out.println("Description :"+failure.getDescription());
            System.out.println("Message :"+failure.getMessage());
            System.out.println("Trace :"+failure.getTrace()+"\n\n");
        }

        System.out.println("----------------------------------------------\n");
        throw new RuntimeException("Failed");
    }
    public static void clear(){
        System.out.println("\nClearing Database Initializing...");

        H2DB.getInstance("UserInfo")
                .delete("ID","456")
                .close();

        H2DB.getInstance("LoginInfo")
                .delete("ID","456")
                .close();

        H2DB.getInstance("BookInfo")
                .delete("ID","9334")
                .close();

        H2DB.getInstance("BookInfo")
                .delete("ID","12344")
                .close();

        H2DB.getInstance("BorrowInfo")
                .delete("BookID","123")
                .close();

        System.out.println("Clearing Database Passed!");
    }
    public static void main(String[] args){
       clear();
    }
}