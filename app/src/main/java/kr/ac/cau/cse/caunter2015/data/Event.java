package kr.ac.cau.cse.caunter2015.data;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Event {
    private int id;
    private String name;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private ArrayList<Product> productList;
    private ArrayList<Category> categoryList;
    private ArrayList<SalesHistory> salesHistoryList;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public ArrayList<Category> getCategoryList() {
        return categoryList;
    }

    public ArrayList<SalesHistory> getSalesHistoryList() {
        return salesHistoryList;
    }
}
