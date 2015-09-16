package kr.ac.cau.cse.caunter2015.data;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Event {
    private int id;
    private String name;
    private String startDate;
    private String endDate;

    public Event(int id, String name, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

}
