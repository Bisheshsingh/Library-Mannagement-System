package FIN.FINE;

import java.util.Date;
import java.util.List;

public interface Fine {
    double Calculate(List<Date> endDates, Date date, double cost);
}
