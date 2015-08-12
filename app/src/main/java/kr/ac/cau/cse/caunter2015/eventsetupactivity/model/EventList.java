package kr.ac.cau.cse.caunter2015.eventsetupactivity.model;

import java.util.ArrayList;

import kr.ac.cau.cse.caunter2015.eventsetupactivity.model.EventData;

/**
 * Created by Julian on 2015-08-13.
 */
public class EventList {
    private ArrayList<EventData> list = new ArrayList<EventData>();

    private void initList() {
        //get recent Data from DB
    }

    private void deleteEvent(EventData o) {
        //drop the event from DB
        this.list.remove(o);
    }

    private void addEvent(EventData o) {
        this.list.add(o);
    }
}
