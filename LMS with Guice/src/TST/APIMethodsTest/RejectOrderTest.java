package TST.APIMethodsTest;

import API.LMSAPI;
import com.google.inject.Injector;

public class RejectOrderTest implements Test{
    private LMSAPI api;
    public RejectOrderTest(Injector injector){
        api = injector.getInstance(LMSAPI.class);
    }
    @Override
    public void run() {

    }
}
