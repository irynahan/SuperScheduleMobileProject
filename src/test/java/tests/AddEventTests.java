package tests;

import model.Event;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddEventTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.getEvent().isContainerPresent()) {
            app.getUser().defaultLogin();
        }
    }


    @Test
    public void eventCreationPositiveTestInCurrentMonth() {
        int quantityBeforeAdd;
        int quantityAfterAdd;

        quantityBeforeAdd = app.getEvent().getTotalEvents();

        app.getEvent().tapOnPlusButton();
        app.getEvent().tapOnPencil();

        app.getEvent().pause(3000);
        app.getEvent().swipeDayToLeft();

        app.getEvent().fillEventCreationForm(new Event()
                .setEventTitle("Event")
                .setType("2")
                .setBreaks(3)
                .setWage("300"));
        app.getEvent().tapOnSaveButton();

        app.getEvent().pause(3000);

        quantityAfterAdd = app.getEvent().getTotalEvents();

        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd+1);
    }

    @Test
    public void eventCreationPositiveTestInCurrentMonthWithDateInFutureWithoutType() {
        int quantityBeforeAdd;
        int quantityAfterAdd;

        quantityBeforeAdd = app.getEvent().getTotalEvents();
        app.getEvent().tapOnPlusButton();
        app.getEvent().tapOnPencil();

        app.getEvent().pause(3000);
        app.getEvent().selectDay("future","MARCH","24");

        app.getEvent().fillEventCreationForm(new Event()
                .setEventTitle("Event")
                .setBreaks(1)
                .setWage("200"));
        app.getEvent().tapOnSaveButton();
        app.getEvent().pause(3000);
        quantityAfterAdd = app.getEvent().getTotalEvents();
        Assert.assertEquals(quantityAfterAdd, quantityBeforeAdd + 1);
    }

    @Test
    public void eventCreationPositiveTestWithDateInPastWithoutType() {

        app.getEvent().tapOnPlusButton();
        app.getEvent().tapOnPencil();

        app.getEvent().pause(3000);
        app.getEvent().selectDay("past","FEBRUARY","28");

        app.getEvent().fillEventCreationForm(new Event()
                .setEventTitle("Event")
                .setBreaks(1)
                .setWage("50"));
        app.getEvent().tapOnSaveButton();

    }

    @AfterMethod
    public void deleteEvent(){
        app.getEvent().tapOnEvent();
        app.getEvent().pause(5000);
        app.getEvent().tapOnDeleteEvent();
    }
}
