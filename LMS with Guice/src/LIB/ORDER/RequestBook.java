package LIB.ORDER;

import java.util.Date;

public class RequestBook implements Order{
    private int UserID,BookID;
    private Date StartDate,EndDate;

    public RequestBook(int userID, int bookID, Date startDate, Date endDate) {
        UserID = userID;
        BookID = bookID;
        StartDate = startDate;
        EndDate = endDate;
    }

    @Override
    public int getBookID() {
        return BookID;
    }

    @Override
    public Date getStartDate() {
        return StartDate;
    }

    @Override
    public Date getEndDate() {
        return EndDate;
    }

    @Override
    public int getUserID() {
        return UserID;
    }
}
