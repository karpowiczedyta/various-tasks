package warehouse;

import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse {

     Product product;
     static ArrayList<Product> productList = new ArrayList<>();

    public Warehouse(){

    }
    public Warehouse(Product product){
        this.product = product;
        addToArray(product);
    }
    public void addToArray(Product product){
        productList.add(product);
    }

    public static void addProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe produktu: ");
        String name = scanner.next();
        System.out.println("Podaj cene produktu: ");
        double price = scanner.nextDouble();
        System.out.println("Podaj ilość sztuk: ");
        int quantity = scanner.nextInt();

        Product p = new Product(name , price,quantity);
        Warehouse w = new Warehouse(p);
    }

    public  void displayTheStatusOfWarehouse(){
        for (Product p : productList){
            System.out.println(p);
        }
    }

    public void sumProduct(){
        double sum = 0;
      for (Product p : productList){
         sum += p.price;
      }
        System.out.println("Suma wynosi: " + sum);
    }

    public void updateTheStatusOfWarehouse(String name,double price , int quantity){

        for (Product p : productList){
            if(p.name.equals(name)){
                p.price = price;
                p.quantity =quantity;
            }
        }
    }

    public void updateTheStatusOfWarehouseAddORSubtract(String name,double price , int quantity,String choice){

        for (Product p : productList){
            if(p.name.equals(name)){
                if("-".equals(choice)) {
                    p.price = price;
                    p.quantity -= quantity;
                }else if("+".equals(choice)){
                    p.price = price;
                    p.quantity += quantity;
                }
            }
        }
    }

}
