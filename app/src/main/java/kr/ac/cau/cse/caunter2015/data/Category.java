package kr.ac.cau.cse.caunter2015.data;

public class Category {
    private int id;
    private String name;
    private int eventId;

    public Category(int id, String name, int eventId) {
        this.id = id;
        this.name = name;
        this.eventId = eventId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEventId() {
        return eventId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}

