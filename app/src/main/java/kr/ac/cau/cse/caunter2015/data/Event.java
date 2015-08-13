package kr.ac.cau.cse.caunter2015.data;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Event {
    private int id;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private ArrayList<Product> productList;
    private ArrayList<Category> categoryList;
    private ArrayList<SalesHistory> salesHistoryList;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
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
