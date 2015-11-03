package kr.ac.cau.cse.caunter2015.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import kr.ac.cau.cse.caunter2015.data.Category;
import kr.ac.cau.cse.caunter2015.data.Event;
import kr.ac.cau.cse.caunter2015.data.Product;
import kr.ac.cau.cse.caunter2015.data.SalesHistory;


public class DBManager extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CaunterDB";
    private static final String EVENT_TYPE = "Event";
    private static final String CATEGORY_TYPE = "Category";
    private static final String PRODUCT_TYPE = "Product";
    private static final String SALES_HISTORY_TYPE = "SalesHistory";
    private static final String PRODUCT_SALES_TYPE = "ProductSales";

    public static final int NEW_ID = -1;

    private EventTable eventTable;
    private CategoryTable categoryTable;
    private ProductTable productTable;
    private SalesHistoryTable salesHistoryTable;
    private ProductSalesTable productSalesTable;

    private SQLiteDatabase db;
    private Context context;

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        db = getWritableDatabase();

        eventTable = new EventTable();
        categoryTable = new CategoryTable();
        productTable = new ProductTable();
        salesHistoryTable = new SalesHistoryTable();
        productSalesTable = new ProductSalesTable();

        initTable();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private void initTable() {
        db.execSQL(eventTable.createTable());
        db.execSQL(categoryTable.createTable());
        db.execSQL(productTable.createTable());
        db.execSQL(salesHistoryTable.createTable());
        db.execSQL(productSalesTable.createTable());
    }

    public void insert(Event event) throws Exception {
        if(event.getId() != NEW_ID) {
            long id = db.insert(eventTable.TABLE_NAME, null, eventTable.insert(event));
            event.setId((int) id);
        } else {
            throw new Exception("Wrong ID");
        }
    }
    public void insert(Category category) throws Exception {
        if(category.getId() != NEW_ID) {
            long id = db.insert(categoryTable.TABLE_NAME, null, categoryTable.insert(category));
            category.setId((int) id);
        } else {
            throw new Exception("Wrong ID");
        }
    }
    public void insert(Product product) throws Exception {
        if(product.getId() != NEW_ID) {
            long id = db.insert(productTable.TABLE_NAME, null, productTable.insert(product));
            product.setId((int) id);
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
            returnValue.add(new Category(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
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
