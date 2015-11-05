package kr.ac.cau.cse.caunter2015.database;


public class SalesHistoryTable {
    private static final String SALES_HISTORY_TYPE = "SalesHistory";

    public String createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS " + SALES_HISTORY_TYPE +" (" +
                "id         INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date       TEXT   not null, " +
                "eventId    INTEGER not null, " +
                "FOREIGN KEY(eventId) REFERENCES Event(id));";
        return sql;
    }
}
