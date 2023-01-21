package LIB.ORDER;

import java.util.Date;

public interface Order {
    int getBookID();
    Date getStartDate();
    Date getEndDate();
    int getUserID();
}
