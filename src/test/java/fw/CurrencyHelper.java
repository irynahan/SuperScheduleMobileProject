package fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CurrencyHelper extends HelperBase{

    public CurrencyHelper(AppiumDriver driver) {
        super(driver);
    }

    public void chooseCurrency(String currency) {
        pause(4000);
        tap(By.id("wizard_settings_currency_arrow"));
        selectCurrency(currency);

    }

    private void selectCurrency(String currency) {
        if (!getSelectedCurrency().equals(currency)){
            swipeUp();
            tap(By.xpath("//android.widget.TextView[@text='" + currency + "']"));
        }
    }



    private String getSelectedCurrency() {
        WebElement element = driver.findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_root']"));
        return element.findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_title']")).getText();
    }
}
