package Task_1_2_3.allConnectedToHumans.check;

import Task_1_2_3.allConnectedToProducts.product.Product;

import java.time.LocalDate;

public class Check {
    private Product product;
    private LocalDate date;

    public Check(Product product, LocalDate date) {
        this.product = product;
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return " " +
                "product=" + product +
                ", date=" + date +
                '}';
    }
}
