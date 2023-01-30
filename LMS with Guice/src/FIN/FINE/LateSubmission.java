package FIN.FINE;

import LIB.USER.User;

import java.util.Date;

public class LateSubmission implements Fine {
    @Override
    public Double Calculate(User user, Date date, double cost) {
        return 0.0;
    }
}
