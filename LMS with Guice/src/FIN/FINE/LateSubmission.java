package FIN.FINE;

import java.util.Date;
import java.util.List;

public class LateSubmission implements Fine {
    private int DateGap(Date d1,Date d2){
        int gap = (int) ((d1.getTime()-d2.getTime())/(24*60*60*1000));
        return gap;
    }
    @Override
    public double Calculate(List<Date> endDates, Date date, double cost) {
        double totalcost=0.0;
        for(Date d : endDates){
            if(d.before(date)){
                totalcost += DateGap(date,d)*cost;
            }
        }

        return totalcost;
    }
}
