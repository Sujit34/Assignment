package customers;

public class Product {
    private int productNumber;
    private  String name;
    private String price;

    private Supplier supplier;

    public Product(int productNumber, String name, String price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
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

    @Override
    public String toString() {
        return "Product{" +  "productNumber=" + productNumber + ", name='" + name + '\'' + ", price='" + price + '\'' + '}';
    }
}
