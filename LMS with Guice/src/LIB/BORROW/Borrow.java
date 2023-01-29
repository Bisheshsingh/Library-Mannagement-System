package LIB.BORROW;

import java.util.Date;

public class Borrow {
    private Date StartDate,EndDate;
    private int BookID;
    private int UserID;

    public Borrow(Date startDate, Date endDate, int bookID,int userID) {
        StartDate = startDate;
        EndDate = endDate;
        BookID = bookID;
        UserID=userID;
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

    public int getUserID() {
        return UserID;
    }
}
