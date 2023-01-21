package FIN;

import LOG.USER.User;

import java.util.Date;

public interface Fine {
    Double Calculate(User user, Date date, double cost);
}
