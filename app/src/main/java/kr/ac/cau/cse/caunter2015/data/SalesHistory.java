package kr.ac.cau.cse.caunter2015.data;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class SalesHistory {
    private int id;
    private HashMap<Product, Integer> salesList;
    private String date;
    private int eventId;

    public SalesHistory() {}

    public SalesHistory(int id, HashMap<Product, Integer> salesList, String date, int eventId) {
        this.id = id;
        this.salesList = salesList;
        this.date = date;
        this.eventId = eventId;
    }
    public int getId() {
        return id;
    }

    public HashMap<Product, Integer> getSalesList() {
        return salesList;
    }

    public String getDate() {
        return date;
    }

    public int getEventId() {
        return eventId;
    }

    public void setId(int id) {
        this.id = id;
    }
}
