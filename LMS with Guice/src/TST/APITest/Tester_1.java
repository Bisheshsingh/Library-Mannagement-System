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
        loginTest=injector.getInstance(LoginTest.class);
        registerTest=injector.getInstance(RegisterTest.class);
        addBookTest=injector.getInstance(AddBookTest.class);
        updateBookTest=injector.getInstance(UpdateBookTest.class);
        getAllBooksTest=injector.getInstance(GetAllBooksTest.class);
        showAvailableBooksTest=injector.getInstance(ShowAvailableBooksTest.class);
        searchByIDTest=injector.getInstance(SearchByIDTest.class);
        searchByAuthorsTest=injector.getInstance(SearchByAuthorsTest.class);
        searchByNameTest=injector.getInstance(SearchByNameTest.class);
        calculateFineTest=injector.getInstance(CalculateFineTest.class);
        viewOrderTest=injector.getInstance(ViewOrderTest.class);
        acceptOrderTest=injector.getInstance(AcceptOrderTest.class);
        rejectOrderTest=injector.getInstance(RejectOrderTest.class);
        placeOrderTest=injector.getInstance(PlaceOrderTest.class);
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
