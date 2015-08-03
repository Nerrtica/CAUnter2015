package kr.ac.cau.cse.caunter2015.data;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class SalesHistory {
    private int id;
    private ArrayList<HashMap<Product, Integer>> salesList;
    private GregorianCalendar date;

    public int getId() {
        return id;
    }

    public ArrayList<HashMap<Product, Integer>> getSalesList() {
        return salesList;
    }

    public GregorianCalendar getDate() {
        return date;
    }
}
