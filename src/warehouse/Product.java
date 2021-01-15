package warehouse;

public class Product {
    String name ;
    double price ;
    int quantity;

    public Product (String name,double price,int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "nameProduct: " + name  +
                "\nprice: " + price +
                "\nquantity: " + quantity
                ;
    }
}
