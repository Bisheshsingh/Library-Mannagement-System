package TST.APIMethodsTest;

import API.GuiceConfig;
import API.LMSAPI;
import LIB.BOOK.Book;
import com.google.inject.Guice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchByAuthorsTest implements Test{
    private LMSAPI api;
    public SearchByAuthorsTest(){
        api= Guice.createInjector(new GuiceConfig()).getInstance(LMSAPI.class);
    }

    private void Check1(){
        System.out.println("\nSearchByAuthorsTest() Check 1: Invalid Params");
        List<Book> books = api.Search_Book_By_Auhors(null);

        if(books==null || books.isEmpty()){
            System.out.println("SearchByAuthorsTest() Check 1 Passed!");
        }else{
            System.out.println("SearchByAuthorsTest() Check 1 Failed!");
        }
    }

    private void Check2(){
        System.out.println("\nSearchByAuthorsTest() Check 2: Search result validation");

        List<Book> books=api.Search_Book_By_Auhors(Arrays.asList("lk"));

        boolean status=true;
        for(Book book : books){
            status &= book.getAuthors().contains("lk");
        }

        if(books.isEmpty()){
            System.out.println("SearchByAuthorsTest() Check 2 Failed!");
        } else if (status) {
            System.out.println("SearchByAuthorsTest() Check 2 Passed!");
        }else{
            System.out.println("SearchByAuthorsTest() Check 2 Failed!");
        }
    }
    @Override
    public void run() {
        Check1();
        Check2();
    }
}
