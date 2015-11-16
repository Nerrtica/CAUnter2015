package kr.ac.cau.cse.caunter2015.data;

public class ProductSales {
    private int historyId;
    private Product product;
    private int amount;

    public int getHistoryId() {
        return historyId;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
