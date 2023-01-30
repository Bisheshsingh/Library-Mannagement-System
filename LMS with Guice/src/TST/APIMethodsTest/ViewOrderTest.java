package TST.APIMethodsTest;

import API.GuiceConfig;
import API.LMSAPI;
import com.google.inject.Guice;

public class ViewOrderTest implements Test{
    private LMSAPI api;
    public ViewOrderTest() {
        this.api = Guice.createInjector(new GuiceConfig()).getInstance(LMSAPI.class);
    }

    public void Check1(){

    }

    @Override
    public void run() {
       Check1();
    }
}
