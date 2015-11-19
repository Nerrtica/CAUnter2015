package kr.ac.cau.cse.caunter2015.database;


import android.content.ContentValues;

import kr.ac.cau.cse.caunter2015.data.SalesHistory;

public class SalesHistoryTable {
    public static final String TABLE_NAME = "SalesHistory";
    private static final String ID_COLUMN = "id";
    private static final String DATE_COLUMN = "date";
    private static final String EVENT_ID_COLUMN = "eventId";


    public String createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +" (" +
                ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DATE_COLUMN + " TEXT not null, " +
                EVENT_ID_COLUMN + " INTEGER not null, " +
                "FOREIGN KEY(" + EVENT_ID_COLUMN + ") REFERENCES Event(id) ON DELETE CASCADE);";
        return sql;
    }

    public ContentValues insert(SalesHistory salesHistory) {
        ContentValues values = new ContentValues();
        values.put(DATE_COLUMN, salesHistory.getDate());
        values.put(EVENT_ID_COLUMN, salesHistory.getEventId());
        return values;
    }

    public String selectAllByForeignKey(int key) {
        String sql = "SELECT * FROM " + TABLE_NAME
                + "WHERE " + EVENT_ID_COLUMN + " = " + key + ";";
        return sql;
    }
}
