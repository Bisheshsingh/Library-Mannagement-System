package LOG.USER;

import java.util.Date;

public class Borrow {
    private Date StartDate,EndDate;
    private int BookID;

    public Borrow(Date startDate, Date endDate, int bookID) {
        StartDate = startDate;
        EndDate = endDate;
        BookID = bookID;
    }

    public int getBookID() {
        return BookID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }
}
