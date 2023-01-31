package TST.APIMethodsTest;

import API.LMSAPI;
import LIB.BOOK.Book;
import LIB.BOOK.Novel;
import LIB.USER.Admin;
import com.google.inject.Injector;

import java.util.Arrays;

import static org.junit.Assert.assertNotEquals;

public class GetAllBooksTest implements Test{
    private LMSAPI api;
    public GetAllBooksTest(Injector injector){
        api = injector.getInstance(LMSAPI.class);
    }

    private void Check1(){
        System.out.println("\nGetAllBooksTest() Check 1: Updated or not after Add Initializing...");
        int originalBooksSize = api.GetAllBooks().size();

        Book book = new Novel(9334, "UT2", Arrays.asList("we","ey"));
        try {
            api.Add_Book(new Admin(1234,"Admin"),book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int modifiedBooksSize = api.GetAllBooks().size();
        assertNotEquals(modifiedBooksSize,originalBooksSize);

        System.out.println("GetAllBooksTest() Check 1 Passed!");
    }
    @Override
    public void run() {
       Check1();
    }
}
