package kr.ac.cau.cse.caunter2015.data;

public class Product {
    private int id;
    private String name;
    private int categoryId;
    private int price;
    private int initialStock;
    private int currentStock;

    public Product(int id, String name, int categoryId, int price, int initialStock, int currentStock) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.initialStock = initialStock;
        this.currentStock = currentStock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getPrice() {
        return price;
    }

    public int getInitialStock() {
        return initialStock;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setInitialStock(int initialStock) {
        this.initialStock = initialStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }
}
