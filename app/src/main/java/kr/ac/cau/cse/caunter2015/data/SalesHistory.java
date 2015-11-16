package kr.ac.cau.cse.caunter2015.data;


import java.util.ArrayList;
import java.util.HashMap;

public class SalesHistory {
    private int id;
    private ArrayList<ProductSales> salesList;
    private String date;
    private int eventId;

    public SalesHistory() {}

    public SalesHistory(int id, ArrayList<ProductSales> salesList, String date, int eventId) {
        this.id = id;
        this.salesList = salesList;
        this.date = date;
        this.eventId = eventId;
    }
    public int getId() {
        return id;
    }

    public ArrayList<ProductSales> getSalesList() {
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

    public void setSalesList(ArrayList<ProductSales> salesList) {
        this.salesList = salesList;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
