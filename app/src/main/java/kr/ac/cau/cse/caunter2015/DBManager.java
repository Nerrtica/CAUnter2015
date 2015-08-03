package kr.ac.cau.cse.caunter2015;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBManager {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CaunterDB";

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
            String sql = "CREATE TABLE IF NOT EXISTS Event (" +
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
            String sql = "CREATE TABLE IF NOT EXISTS Category (" +
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
            String sql = "CREATE TABLE IF NOT EXISTS Product (" +
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
            String sql = "CREATE TABLE IF NOT EXISTS SalesHistory (" +
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
            String sql = "CREATE TABLE IF NOT EXISTS ProductSales (" +
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
