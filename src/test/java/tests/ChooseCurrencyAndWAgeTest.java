package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChooseCurrencyAndWAgeTest extends TestBase{
    @BeforeMethod
    public void preconditions() {
        app.getUser().register();
    }

    @Test

    public void chooseCurrencyAndWAgeTest() {

        app.getCurrency().chooseCurrency("Bahamian Dollar");
        app.getWage().chooseWage("200");
        app.getUser().tapOnNextButton();
    }
}
