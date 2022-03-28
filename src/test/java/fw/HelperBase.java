package fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {

    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type (By locator, String text){
        if (text != null) {
            if(!text.equals(driver.findElement(locator).getText())) {
                pause(3000);
                tap(locator);
                pause(2000);
                driver.findElement(locator).clear();
                pause(2000);
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    public void waiForElementAndTap(By locator, int timeOut) {
        new WebDriverWait(driver,timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementAndType(By locator, int timeOut, String text) {
        if (text != null) {
            waiForElementAndTap(locator,timeOut);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }


    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void swipeDayToLeft() {
        TouchAction action = new TouchAction(driver);
        //get activity points
        Dimension size = driver.manage().window().getSize();
        int y = size.height/5;
        int startX = (int) (size.width * 0.8);
        int stopX = (int) (size.width * 0.2);

        action.longPress(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(stopX,y))
                .release()
                .perform();

    }
    public void moveElementToRight(By locator){
        TouchAction action = new TouchAction(driver);
        //get activity points
        Dimension size = driver.manage().window().getSize();

        int leftPoint = (int) (size.width*0.2);
        int rightPoint = (int) (size.width*0.5);

        WebElement element = driver.findElement(locator);

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY)/2;

        action.longPress(PointOption.point(leftPoint,middleY))
                .moveTo(PointOption.point(rightPoint, middleY))
                .release().perform();


    }

    public void moveElementToLeft(By locator){
        TouchAction action = new TouchAction(driver);
        //get activity points
        Dimension size = driver.manage().window().getSize();

        int leftPoint = (int) (size.width*0.2);
        int rightPoint = (int) (size.width*0.5);

        WebElement element = driver.findElement(locator);

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY)/2;

        action.longPress(PointOption.point(rightPoint,middleY))
                .moveTo(PointOption.point(leftPoint, middleY))
                .release().perform();
    }

    public void swipeUp() {
        TouchAction action = new TouchAction(driver);
        //get activity points
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;

        int startY= (int) (size.height * 0.8);
        int stopY = (int) (size.height * 0.2);

        action.longPress(PointOption.point(x, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(x,stopY))
                .release()
                .perform();

    }
}
