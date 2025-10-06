package SeleniumCursoCORE;


import org.junit.After;

import static SeleniumCursoCORE.DriverFactory.killDriver;

public class BaseTest {

    @After
    public void finalizar(){
    killDriver();}


}
