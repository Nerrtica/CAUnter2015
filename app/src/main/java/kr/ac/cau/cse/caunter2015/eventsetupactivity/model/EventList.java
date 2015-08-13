package kr.ac.cau.cse.caunter2015.eventsetupactivity.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import kr.ac.cau.cse.caunter2015.eventsetupactivity.model.EventData;

/**
 * Created by Julian on 2015-08-13.
 */
public class EventList {
    private enum sortOption{BY_NAME,BY_START,BY_ENDS};
    private ArrayList<EventData> list = new ArrayList<EventData>();
    private sortOption option = sortOption.BY_NAME;
    private boolean asc=true;

    private void initList() {
        //get recent Data from DB
    }

    private void deleteEvent(EventData o) {
        //drop the event from DB
        this.list.remove(o);
    }

    private void addEvent(EventData o) {
        this.list.add(o);
        listSort();
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
