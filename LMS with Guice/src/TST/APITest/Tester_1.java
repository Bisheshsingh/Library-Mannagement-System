package TST.APITest;

import API.GuiceConfig;
import API.LMSAPI;
import TST.APIMethodsTest.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class Tester_1 implements Tester {
    private LMSAPI api;
    private LoginTest loginTest;
    private RegisterTest registerTest;
    private AddBookTest addBookTest;
    private UpdateBookTest updateBookTest;
    private GetAllBooksTest getAllBooksTest;
    private ShowAvailableBooksTest showAvailableBooksTest;
    private SearchByIDTest searchByIDTest;
    private SearchByNameTest searchByNameTest;
    private SearchByAuthorsTest searchByAuthorsTest;
    private CalculateFineTest calculateFineTest;
    private ViewOrderTest viewOrderTest;
    private AcceptOrderTest acceptOrderTest;
    private RejectOrderTest rejectOrderTest;
    private PlaceOrderTest placeOrderTest;

    public Tester_1() {
        Injector injector = Guice.createInjector(new GuiceConfig());
        loginTest=new LoginTest(injector);
        registerTest=new RegisterTest(injector);
        addBookTest=new AddBookTest(injector);
        updateBookTest=new UpdateBookTest(injector);
        getAllBooksTest=new GetAllBooksTest(injector);
        showAvailableBooksTest=new ShowAvailableBooksTest(injector);
        searchByIDTest=new SearchByIDTest(injector);
        searchByAuthorsTest=new SearchByAuthorsTest(injector);
        searchByNameTest=new SearchByNameTest(injector);
        calculateFineTest=new CalculateFineTest(injector);
        viewOrderTest=new ViewOrderTest(injector);
        acceptOrderTest=new AcceptOrderTest(injector);
        rejectOrderTest=new RejectOrderTest(injector);
        placeOrderTest=new PlaceOrderTest(injector);
    }

    @Override
    @Test
    public void TestLogin() {
       loginTest.run();
    }

    @Override
    @Test
    public void TestRegister() {
        registerTest.run();
    }

    @Override
    @Test
    public void TestAdd_Book() {
        addBookTest.run();
    }

    @Override
    @Test
    public void TestUpdate_Book() {
        updateBookTest.run();
    }

    @Override
    @Test
    public void TestGetAllBooks() {
       getAllBooksTest.run();
    }

    @Override
    @Test
    public void TestShow_Available_Books() {
       showAvailableBooksTest.run();
    }

    @Override
    @Test
    public void TestSearch_Book_By_ID() {
       searchByIDTest.run();
    }

    @Override
    @Test
    public void TestSearch_Book_By_Name() {
       searchByNameTest.run();
    }

    @Override
    @Test
    public void TestSearch_Book_By_Auhors() {
       searchByAuthorsTest.run();
    }

    @Override
    @Test
    public void TestCalculate_Fine() {
       calculateFineTest.run();
    }

    @Override
    @Test
    public void TestView_Order() {
        viewOrderTest.run();
    }

    @Override
    @Test
    public void TestAccept_Order() {
        acceptOrderTest.run();
    }

    @Override
    @Test
    public void TestReject_Order() {
        rejectOrderTest.run();
    }

    @Override
    @Test
    public void TestPlace_Order() {
        placeOrderTest.run();
    }
}
