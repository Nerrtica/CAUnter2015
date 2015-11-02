package kr.ac.cau.cse.caunter2015.eventsetupactivity.model;

import java.sql.Timestamp;

/**
 * Created by Julian on 2015-08-02.
 * by Junyeon Julian Weon, CAUCSE, CAUnter2015 Team.
 */
public class EventData {
    private int eventID;
    private String eventName;
    private Timestamp eventStart, eventEnds;

    public EventData(int ID, String name, Timestamp sDate, Timestamp eDate) {
        this.eventID = ID;
        this.eventName = name;
        this.eventStart = sDate;
        this.eventEnds = eDate;
    }

    public void setEventName(String newName) { this.eventName = newName; }

    public void editStart(Timestamp newDate) { this.eventStart = newDate; }

    public void editEnds(Timestamp newDate) { this.eventEnds = newDate; }

    public String getName() { return this.eventName; }

    public Timestamp getStart() { return this.eventStart; }

    public Timestamp getEnds() { return this.eventEnds; }
}
