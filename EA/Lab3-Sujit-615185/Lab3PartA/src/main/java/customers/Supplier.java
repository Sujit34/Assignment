package customers;

public class Supplier {
    private String name;
    private String phone;
    private int productNumber;

    public Supplier(String name, String phone,int productNumber) {
        this.productNumber = productNumber;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" + "ProductNumber = " + productNumber + "ProductName='" + name + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
