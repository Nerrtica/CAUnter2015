package kr.ac.cau.cse.caunter2015.database;


import android.content.ContentValues;

import kr.ac.cau.cse.caunter2015.data.ProductSales;

public class ProductSalesTable {
    public static final String TABLE_NAME = "ProductSales";
    private static final String HISTORY_ID_COLUMN = "historyId";
    private static final String PRODUCT_ID_COLUMN = "productId";
    private static final String AMOUNT_COLUMN = "amount";

    public String createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                HISTORY_ID_COLUMN + " INTEGER, " +
                PRODUCT_ID_COLUMN + " INTEGER, " +
                AMOUNT_COLUMN + " INTEGER not null, " +
                "PRIMARY KEY(" + HISTORY_ID_COLUMN + ", " + PRODUCT_ID_COLUMN + ")," +
                "FOREIGN KEY(" + HISTORY_ID_COLUMN + ") REFERENCES SalesHistory(id) ON DELETE CASCADE," +
                "FOREIGN KEY(" + PRODUCT_ID_COLUMN + ") REFERENCES Product(id) ON DELETE CASCADE);";
        return sql;
    }

    public ContentValues insert(ProductSales productSales) {
        ContentValues values = new ContentValues();
        values.put(HISTORY_ID_COLUMN, productSales.getHistoryId());
        values.put(PRODUCT_ID_COLUMN, productSales.getProduct().getId());
        values.put(AMOUNT_COLUMN, productSales.getAmount());
        return values;
    }
}
