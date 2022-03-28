package fw;

import io.appium.java_client.AppiumDriver;
import model.Event;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.TestBase;

import java.util.List;

public class EventHelper extends HelperBase {

    public EventHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isContainerPresent() {
        return isElementPresent(By.id("nav_list_fr_container"));
    }

    public void tapOnPlusButton() {
        tap(By.id("fab_main"));
    }

    public void tapOnPencil() {
        tap(By.id("fab_add_event"));
    }

    public void fillEventCreationForm(Event event) {
        waitForElementAndType(By.id("info_title_input"),5, event.getEventTitle());
        type(By.id("info_type_input"), event.getType());
        hideKeyboard();
        chooseBreaks(event.getBreaks());
        pause(2000);
        addWage(event.getWage());
    }

    private void chooseBreaks(int breaks) {
        if(breaks > 0) {
            for (int i = 0; i < breaks; i++) {
                tap(By.id("info_break_plus_btn"));
            }
        }
    }

    public void addWage(String wage) {
        tap(By.id("info_wage_edit"));
        type(By.id("info_wage_input"),wage);
        hideKeyboard();
        pause(5000);
        tap(By.id("info_wage_save"));
    }

    public void tapOnSaveButton() {
        tap(By.id("info_save_btn"));
    }

    public int getTotalEvents() {
        List<WebElement> id =  driver.findElements(By.id("row_container_main"));
        int idCount = id.size();
        System.out.println("Total events quantity" + idCount);
        return idCount;

    }

    public void selectDay(String time, String month, String day) {
        if(!getSelectedMonth().equals(month)) {

            if (time.equals("past")){

                swipeToRightUntilNeededMonth(month);

                if(!getSelectedDay().equals(day)){
                    swipeToRightUntilNeededDay(day);
                }
            } else if (time.equals("future")) {
                swipeToLeftUntilNeededMonth(month);
                if(!getSelectedDay().equals(day)){
                    swipeToLeftUntilNeededDay(day);
                }
            }
        } else if (!getSelectedDay().equals(day)){
            if(time.equals("past")){
                swipeToRightUntilNeededDay(day);
            } else if (time.equals("future")){
                swipeToLeftUntilNeededDay(day);
            }
        }

    }

    private void swipeToLeftUntilNeededDay(String day) {
        while (!getSelectedDay().equals(day)){
            moveElementToLeft(By.id("info_viewPager"));
            getSelectedDay();
        }
    }

    private void swipeToLeftUntilNeededMonth( String month) {
        while (!getSelectedMonth().equals(month)){
            moveElementToLeft(By.id("info_viewPager"));
            getSelectedMonth();
        }

    }

    private void swipeToRightUntilNeededDay(String day) {
        while (!getSelectedDay().equals(day)){
            moveElementToRight(By.id("info_viewPager"));
            getSelectedDay();
        }

    }

    private void swipeToRightUntilNeededMonth(String month) {
        while (!getSelectedMonth().equals(month)){
            moveElementToRight(By.id("info_viewPager"));
            getSelectedMonth();
        }

    }

    private String getSelectedDay() {
        WebElement selectedDay = driver.findElement(By.id("date_container_layout"));
        return selectedDay.findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/row_day_number_txt']")).getText();
    }

    public String getSelectedMonth() {
        WebElement selectedDay = driver.findElement(By.id("date_container_layout"));
        return selectedDay.findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/row_month_txt']")).getText();
    }

    public void tapOnEvent() {
        if(isEventPresent()){
            tap(By.id("row_container_main"));
        }
    }

    private boolean isEventPresent() {
        return driver.findElement(By.id("row_container_main")).isDisplayed();
    }

    public void tapOnDeleteEvent() {
        tap(By.id("delete_menu"));
    }

}
