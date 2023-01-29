package TST.APITest;

import org.junit.Test;

public interface Tester {
    public void TestLogin();
    public void TestRegister();
    public void TestAdd_Book();
    public void TestUpdate_Book();
    public void TestGetAllBooks();
    public void TestShow_Available_Books();
    public void TestSearch_Book_By_ID();
    public void TestSearch_Book_By_Name();
    public void TestSearch_Book_By_Auhors();
    public void TestCalculate_Fine();
    public void TestView_Order();
    public void TestAccept_Order();
    public void TestReject_Order();
    public void TestPlace_Order();
}
