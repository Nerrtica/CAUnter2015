package kr.ac.cau.cse.caunter2015.database;


public class ProductSalesTable {
    private static final String PRODUCT_SALES_TYPE = "ProductSales";

    public String createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS " + PRODUCT_SALES_TYPE + " (" +
                "historyId  INTEGER, " +
                "productId  INTEGER, " +
                "amount     INTEGER not null, " +
                "PRIMARY KEY(historyId, productId)," +
                "FOREIGN KEY(historyId) REFERENCES SalesHistory(id)," +
                "FOREIGN KEY(productId) REFERENCES Product(id));";
        return sql;
    }
}
