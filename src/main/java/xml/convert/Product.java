package xml.convert;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;

    private String price;

    private String supplierId;

    private String content;

    public Product() {
    }

    public Product(String name, String price, String supplierId, String content) {
        this.name = name;
        this.price = price;
        this.supplierId = supplierId;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
