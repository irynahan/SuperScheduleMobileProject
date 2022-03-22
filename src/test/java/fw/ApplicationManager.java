package fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;

    UserHelper user;
    EventHelper event;

    public UserHelper getUser() {
        return user;
    }

    public EventHelper getEvent() {
        return event;
    }

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "qa23mob");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("app", "C:/projects/Tools/AndStudio/v.0.0.3.apk" );
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        user = new UserHelper(driver);
        event = new EventHelper(driver);

    }

    public void stop() {
        driver.quit();
    }
}
