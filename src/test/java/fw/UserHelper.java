package fw;

import io.appium.java_client.AppiumDriver;
import model.User;
import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(User user) {
        fillLoginForm(user);
        hideKeyboard();
        tap(By.id("login_btn"));
    }
    public void fillLoginForm(User user) {
        waitForElementAndType(By.id("log_email_input"), 10, user.getEmail());
        type(By.id("log_password_input"), user.getPassword());
    }
    public void skipLogo() {
        tap(By.xpath("//android.widget.ImageView[@content-desc='Logo']"));
        // tap(By.id("splash_logo_img"));
    }

    public void defaultLogin() throws InterruptedException {
        fillLoginForm(new User().setEmail("neuer7@gmail.com").setPassword("Neuer2027"));
        hideKeyboard();
        tap(By.id("login_btn"));
        Thread.sleep(3000);
    }
}
