package model;

public class Event {
    private String eventTitle;
    private String type;
    private int breaks;
    private String wage;

    public Event setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
        return this;
    }

    public Event setType(String type) {
        this.type = type;
        return this;
    }

    public Event setBreaks(int breaks) {
        this.breaks = breaks;
        return this;
    }

    public Event setWage(String wage) {
        this.wage = wage;
        return  this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventTitle='" + eventTitle + '\'' +
                ", type='" + type + '\'' +
                ", breaks=" + breaks +
                ", wage='" + wage + '\'' +
                '}';
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getType() {
        return type;
    }

    public int getBreaks() {
        return breaks;
    }

    public String getWage() {
        return wage;
    }
}