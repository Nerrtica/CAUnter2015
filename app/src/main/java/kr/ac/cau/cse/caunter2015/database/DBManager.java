package kr.ac.cau.cse.caunter2015.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import kr.ac.cau.cse.caunter2015.data.Category;
import kr.ac.cau.cse.caunter2015.data.Event;
import kr.ac.cau.cse.caunter2015.data.Product;
import kr.ac.cau.cse.caunter2015.data.ProductSales;
import kr.ac.cau.cse.caunter2015.data.SalesHistory;


public class DBManager extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CaunterDB";

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
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
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
            long id = db.insert(EventTable.TABLE_NAME, null, eventTable.insert(event));
            event.setId((int) id);
        } else {
            throw new Exception("Error: Insert into Event table - Wrong ID");
        }
    }
    public void insert(Category category) throws Exception {
        if(category.getId() != NEW_ID) {
            long id = db.insert(CategoryTable.TABLE_NAME, null, categoryTable.insert(category));
            category.setId((int) id);
        } else {
            throw new Exception("Error: Insert into Category table - Wrong ID");
        }
    }
    public void insert(Product product) throws Exception {
        if(product.getId() != NEW_ID) {
            long id = db.insert(ProductTable.TABLE_NAME, null, productTable.insert(product));
            product.setId((int) id);
        } else {
            throw new Exception("Error: Insert into Product table - Wrong ID");
        }
    }

    public void insert(SalesHistory salesHistory) throws Exception {
        if(salesHistory.getId() != NEW_ID) {
            long id = db.insert(SalesHistoryTable.TABLE_NAME, null, salesHistoryTable.insert(salesHistory));
            salesHistory.setId((int) id);
            ArrayList<ProductSales> salesList = salesHistory.getSalesList();
            for (int i = 0; i < salesList.size(); i++) {
                salesList.get(i).setHistoryId((int) id);
                db.insert(ProductSalesTable.TABLE_NAME, null, productSalesTable.insert(salesList.get(i)));
            }
        } else {
            throw new Exception("Error: Insert into SalesHistory table - Wrong ID");
        }
    }

    public ArrayList<Event> selectEvent() {
        Cursor cursor = db.rawQuery(eventTable.selectAll(), null);
        ArrayList<Event> returnValue = new ArrayList<>();
        while(cursor.moveToNext()) {
            returnValue.add(new Event(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            break;
        }
        cursor.close();
        return returnValue;
    }
    public ArrayList<Category> selectCategory(int foreignId) {
        Cursor cursor = db.rawQuery(categoryTable.selectAllByForeignKey(foreignId), null);
        ArrayList<Category> returnValue = new ArrayList<>();
        while(cursor.moveToNext()) {
            returnValue.add(new Category(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
        }
        return returnValue;
    }
    public ArrayList<Product> selectProduct(int foreignId) {
        Cursor cursor = db.rawQuery(productTable.selectAllByForeignKey(foreignId), null);
        ArrayList<Product> returnValue = new ArrayList<>();
        while(cursor.moveToNext()) {
            returnValue.add(
                    new Product(
                            cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)
                    )
            );
        }
        return returnValue;
    }
    public ArrayList<SalesHistory> selectSalesHistory(int foreignId) {
        Cursor cursor = db.rawQuery(salesHistoryTable.selectAllByForeignKey(foreignId), null);
        ArrayList<SalesHistory> returnValue = new ArrayList<>();
        while(cursor.moveToNext()) {
            SalesHistory salesHistory = new SalesHistory();
            salesHistory.setId(cursor.getInt(0));
            salesHistory.setDate(cursor.getString(1));
            salesHistory.setEventId(cursor.getInt(2));
            salesHistory.setSalesList(
                selectProductSales(salesHistory.getId())
            );

            returnValue.add(salesHistory);
        }

        return returnValue;
    }
    private ArrayList<ProductSales> selectProductSales(int foreignId) {
        Cursor cursor = db.rawQuery(productSalesTable.selectAllByForeignKey(foreignId), null);
        ArrayList<ProductSales> returnValue = new ArrayList<>();
        while(cursor.moveToNext()) {
            returnValue.add(
                    new ProductSales(
                            cursor.getInt(0), cursor.getInt(1), cursor.getInt(2)
                    )
            );
        }

        return returnValue;
    }
    public void delete(Event event) throws Exception {
        int result = db.delete(EventTable.TABLE_NAME, "id=?", new String[]{String.valueOf(event.getId())});
        if(result == 0 ) {
            throw new Exception("Error: Delete from Event table - no such data");
        }
    }

    public void delete(Category category) throws Exception {
        int result = db.delete(CategoryTable.TABLE_NAME, "id=?", new String[]{String.valueOf(category.getId())});
        if(result == 0) {
            throw new Exception("Error: Delete from Category table - no such data");
        }
    }
    public void delete(Product product) throws Exception {
        int result = db.delete(ProductTable.TABLE_NAME, "id=?", new String[]{String.valueOf(product.getId())});
        if(result == 0) {
            throw new Exception("Error: Delete from Product table - no such data");
        }
    }
    public void delete(SalesHistory salesHistory) throws Exception {
        int result = db.delete(SalesHistoryTable.TABLE_NAME, "id=?", new String[]{String.valueOf(salesHistory.getId())});
        if(result == 0) {
            throw new Exception("Error: Delete from Product table - no such data");
        }
    }

    public void delete(ProductSales productSales) throws Exception {
        int result = db.delete(ProductSalesTable.TABLE_NAME, "historyId=? AND productId=?", new String[]{String.valueOf(productSales.getHistoryId()), String.valueOf(productSales.getProductId())});
        if(result == 0) {
            throw new Exception("Error: Delete from Product table - no such data");
        }
    }
}
