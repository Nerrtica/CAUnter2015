package kr.ac.cau.cse.caunter2015.database;


import android.content.ContentValues;

import kr.ac.cau.cse.caunter2015.data.Product;

public class ProductTable {
    public static final String TABLE_NAME = "Product";
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String CATEGORY_ID_COLUMN = "categoryId";
    private static final String PRICE_COLUMN = "price";
    private static final String START_STOCK_COLUMN = "startStock";
    private static final String STOCK_COLUMN = "stock";


    public String createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                ID_COLUMN + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME_COLUMN + "TEXT not null, " +
                CATEGORY_ID_COLUMN + "INTEGER not null, " +
                PRICE_COLUMN + "INTEGER not null, " +
                START_STOCK_COLUMN + "INTEGER not null, " +
                STOCK_COLUMN + "INTEGER not null, " +
                "FOREIGN KEY(" + CATEGORY_ID_COLUMN + ") REFERENCES Category(id));";
        return sql;
    }

    public ContentValues insert(Product product) {
        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, product.getName());
        values.put(CATEGORY_ID_COLUMN, product.getCategoryId());
        values.put(PRICE_COLUMN, product.getPrice());
        values.put(START_STOCK_COLUMN, product.getInitialStock());
        values.put(STOCK_COLUMN, product.getCurrentStock());
        return values;
    }

    public String selectAllByForeignKey(int key) {
        String sql = "SELECT * FROM " + TABLE_NAME
                + "WHERE " + CATEGORY_ID_COLUMN + " = " + key + ";";
        return sql;
    }
}
