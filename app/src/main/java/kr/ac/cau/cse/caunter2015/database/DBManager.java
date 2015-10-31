package kr.ac.cau.cse.caunter2015.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import kr.ac.cau.cse.caunter2015.data.Category;
import kr.ac.cau.cse.caunter2015.data.Event;
import kr.ac.cau.cse.caunter2015.data.Product;


public class DBManager extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CaunterDB";
    public static final String EVENT_TYPE = "Event";
    public static final String CATEGORY_TYPE = "Category";
    public static final String PRODUCT_TYPE = "Product";
    public static final String SALES_HISTORY_TYPE = "SalesHistory";
    private static final String PRODUCT_SALES_TYPE = "ProductSales";

    private SQLiteDatabase db;
    private Context context;

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        db = getWritableDatabase();
        initTable();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private void initTable() {
        initEventTable();
        initCategoryTable();
        initProductTable();
        initSalesHistoryTable();
        initProductSalesTable();
    }
    private void initEventTable() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + EVENT_TYPE + " (" +
                    "id         INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name       TEXT    not null, " +
                    "startDate  TEXT    not null, "+
                    "endDate    TEXT    not null);";
            db.execSQL(sql);
        } catch (Exception e){
            Log.e("database", "create Event table failed. :" + e);
            e.printStackTrace();
        }
    }
    private void initCategoryTable() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + CATEGORY_TYPE + " (" +
                    "id         INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name       TEXT    not null, " +
                    "eventId    INTEGER not null, " +
                    "FOREIGN KEY(eventId) REFERENCES Event(id));";
            db.execSQL(sql);
        } catch (Exception e){
            Log.e("database", "create Category table failed. :" + e);
            e.printStackTrace();
        }
    }
    private void initProductTable() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + PRODUCT_TYPE + " (" +
                    "id         INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name       TEXT    not null, " +
                    "categoryId INTEGER not null, " +
                    "price      INTEGER not null, " +
                    "startStock INTEGER not null, " +
                    "stock      INTEGER not null, " +
                    "FOREIGN KEY(categoryId) REFERENCES Category(id));";
            db.execSQL(sql);
        } catch (Exception e){
            Log.e("database", "create Product table failed. :" + e);
            e.printStackTrace();
        }
    }
    private void initSalesHistoryTable() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + SALES_HISTORY_TYPE +" (" +
                    "id         INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "date       TEXT   not null, " +
                    "eventId    INTEGER not null, " +
                    "FOREIGN KEY(eventId) REFERENCES Event(id));";
            db.execSQL(sql);
        } catch (Exception e){
            Log.e("database", "create SalesHistory table failed. :" + e);
            e.printStackTrace();
        }
    }
    private void initProductSalesTable() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + PRODUCT_SALES_TYPE + " (" +
                    "historyId  INTEGER, " +
                    "productId  INTEGER, " +
                    "amount     INTEGER not null, " +
                    "PRIMARY KEY(historyId, productId)," +
                    "FOREIGN KEY(historyId) REFERENCES SalesHistory(id)," +
                    "FOREIGN KEY(productId) REFERENCES Product(id));";
            db.execSQL(sql);
        } catch (Exception e){
            Log.e("database", "create SalesHistory table failed. :" + e);
            e.printStackTrace();
        }
    }



    public ArrayList<Event> selectALLEvent() {
        String sql = "SELECT * FROM " + EVENT_TYPE + ";";
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Event> returnValue = null;
        while(cursor.moveToNext()) {
            returnValue.add(new Event(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            break;
        }
        cursor.close();
        return returnValue;
    }
    public ArrayList<Category> selectCategory(int eventId) {
        String sql = "Select * FROM " + CATEGORY_TYPE + "WHERE eventId = " + eventId + ";";
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Category> returnValue = null;
        while(cursor.moveToNext()) {
            returnValue.add(new Category(cursor.getInt(0), cursor.getString(1)));
        }
        return returnValue;
    }
    public ArrayList<Product> selectProduct(int eventId) {
        String sql = "SELECT * FROM " + PRODUCT_TYPE + "WHERE eventId = " + eventId + ";";
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Product> returnValue = null;
        while(cursor.moveToNext()) {
            returnValue.add(
                    new Product(
                            cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)
                    )
            );
        }
        return returnValue;
    }

}
