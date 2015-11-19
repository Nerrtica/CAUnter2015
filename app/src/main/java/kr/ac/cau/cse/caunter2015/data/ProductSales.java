package kr.ac.cau.cse.caunter2015.data;

public class ProductSales {
    private int historyId;
    private int productId;
    private int amount;

    public ProductSales() {}

    public ProductSales(int historyId, int product, int amount) {
        this.historyId = historyId;
        this.productId = product;
        this.amount = amount;
    }

    public int getHistoryId() {
        return historyId;
    }

    public int getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
