package kr.ac.cau.cse.caunter2015.database;


import android.content.ContentValues;

import kr.ac.cau.cse.caunter2015.data.Category;

public class CategoryTable {
    public static final String TABLE_NAME = "Category";
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String EVENT_ID_COLUMN = "eventId";


    public String createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                ID_COLUMN + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME_COLUMN + "TEXT    not null, " +
                EVENT_ID_COLUMN + "INTEGER not null, " +
                "FOREIGN KEY("+ EVENT_ID_COLUMN +") " +
                "REFERENCES Event(id));";
        return sql;
    }

    public ContentValues insert(Category category) {
        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, category.getName());
        values.put(EVENT_ID_COLUMN, category.getEventId());
        return values;
    }
}
