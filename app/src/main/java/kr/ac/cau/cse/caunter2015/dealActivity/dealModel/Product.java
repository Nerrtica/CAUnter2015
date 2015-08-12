package kr.ac.cau.cse.caunter2015.dealActivity.dealModel;

public class Product {
    private int productId;
    private String productName;
    private int categoryId;
    private int price;
    private int startStock;
    private int stock;
    private int totalPrice;

    public Product(int productId, String productName, int categoryId, int price, int startStock, int stock, int totalPrice) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.price = price;
        this.startStock = startStock;
        this.stock = stock;
        this.totalPrice = totalPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getPrice() {
        return price;
    }

    public int getStartStock() {
        return startStock;
    }

    public int getStock() {
        return stock;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
