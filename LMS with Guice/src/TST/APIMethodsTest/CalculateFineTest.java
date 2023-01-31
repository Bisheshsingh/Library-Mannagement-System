package TST.APIMethodsTest;

import FIN.FINE.Fine;
import com.google.inject.Injector;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculateFineTest implements Test{
    private Fine fine;

    public CalculateFineTest(Injector injector) {
        this.fine = injector.getInstance(Fine.class);;
    }

    private void Check1() {
        System.out.println("\nCalculateFineTest() Check 1: Fine calculation check Initializing...");
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> endDates=null;
        Date currentDate=null;
        try {
            endDates = Arrays.asList(
                    ft.parse("2023-01-02"),
                    ft.parse("2023-01-10")
            );
            currentDate = ft.parse("2023-01-31");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        assertEquals(fine.Calculate(endDates,currentDate,100.0),5000.0,0.0);
        System.out.println("CalculateFineTest() Check 1 Passed!");
    }
    @Override
    public void run() {
       Check1();
    }

}
