package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginPositiveTest() throws InterruptedException {
        Thread.sleep(5000);
        //app.getUser().skipLogo();
        app.getUser().login(new User().setEmail("neuer123@gmail.com").setPassword("Neuer2021"));
        Thread.sleep(5000);
        Assert.assertTrue(app.getEvent().isContainerPresent());
    }

}
