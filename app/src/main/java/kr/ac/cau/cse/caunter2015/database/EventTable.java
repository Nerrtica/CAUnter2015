package kr.ac.cau.cse.caunter2015.database;


import android.content.ContentValues;

import kr.ac.cau.cse.caunter2015.data.Event;

public class EventTable {
    public static final String TABLE_NAME = "Event";
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String START_DATE_COLUMN = "startDate";
    private static final String END_DATE_COLUMN = "endDate";

    public String createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME_COLUMN + " TEXT not null, " +
                START_DATE_COLUMN + "TEXT not null, " +
                END_DATE_COLUMN + "TEXT not null);";
        return sql;
    }

    public ContentValues insert(Event event) {
        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, event.getName());
        values.put(START_DATE_COLUMN, event.getStartDate());
        values.put(END_DATE_COLUMN, event.getEndDate());
        return values;
    }

    public String selectAll() {
        String sql = "SELECT * FROM " + TABLE_NAME + ";";
        return sql;
    }
}
