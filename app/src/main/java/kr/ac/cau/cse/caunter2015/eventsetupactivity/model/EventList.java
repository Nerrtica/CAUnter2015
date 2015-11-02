package kr.ac.cau.cse.caunter2015.eventsetupactivity.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import kr.ac.cau.cse.caunter2015.database.DBManager;
import kr.ac.cau.cse.caunter2015.data.*;

/**
 * Created by Julian on 2015-08-13.
 */
public class EventList {
    public enum sortOption{BY_NAME,BY_START,BY_ENDS};
    private ArrayList<EventData> list = new ArrayList<EventData>();
    private sortOption option = sortOption.BY_NAME;
    private boolean asc=true;

    public EventList() {
        initList();
    }

    private void initList() {
        DBManager db = new DBManager(null);
        ArrayList<Event> dbEvent = db.selectALLEvent();

    }

    private void deleteEvent(EventData o) {
        //drop the event from DB
        this.list.remove(o);
    }

    private void addEvent(EventData o) {
        this.list.add(o);
        listSort();
    }

    public void setAsc() {
        this.asc=true;
    }

    public void setDsc() {
        this.asc=false;
    }

    public void setOption(sortOption newOption) {
        this.option = newOption;
    }

    private void listSort() {
        Comparator<EventData> comparator=null;
        switch(this.option) {
            case BY_NAME:
                comparator = EventComparator.ByNameAsc;
                break;
            case BY_START:
                comparator = EventComparator.ByStartAsc;
                break;
            case BY_ENDS:
                comparator = EventComparator.ByEndAsc;
        }
        if(!this.asc) {
            comparator = EventComparator.descendingComparator(comparator);
        }
        Collections.sort(this.list,comparator);
    }
}
