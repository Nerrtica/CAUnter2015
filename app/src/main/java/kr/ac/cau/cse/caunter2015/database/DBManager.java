package kr.ac.cau.cse.caunter2015.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBManager {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CaunterDB";

    public static final String EVENT_TABLE_NAME = "Event";
    public static final String CATEGORY_TABLE_NAME = "Category";
    public static final String PRODUCT_TABLE_NAME = "Product";
    public static final String SALES_HISTORY_TABLE_NAME = "SalesHistory";
    public static final String PRODUCT_SALES_TABLE_NAME = "ProductSales";


    private SQLiteDatabase db;
    private OpenHelper helper;

    private Context context;


    private class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper (Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {

            Log.i("database", "SQLiteOpenHelper onCreate start.");
            initEventTable(db);
            initCategoryTable(db);
            initProductTable(db);
            initSalesHistoryTable(db);
            initProductSalesTable(db);
            Log.i("database", "SQLiteOpenHelper onCreate end.");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("database", "SQLiteOpenHelper onUpgrade.");
        }
    }

    public DBManager(Context context){
        this.context = context;
        this.helper = new OpenHelper(context);
        db = helper.getWritableDatabase();
    }

    private void initEventTable(SQLiteDatabase db) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + EVENT_TABLE_NAME + " (" +
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
    private void initCategoryTable(SQLiteDatabase db) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + CATEGORY_TABLE_NAME + " (" +
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
    private void initProductTable(SQLiteDatabase db) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + PRODUCT_TABLE_NAME + " (" +
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
    private void initSalesHistoryTable(SQLiteDatabase db) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + SALES_HISTORY_TABLE_NAME +" (" +
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
    private void initProductSalesTable(SQLiteDatabase db) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + PRODUCT_SALES_TABLE_NAME + " (" +
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


}
