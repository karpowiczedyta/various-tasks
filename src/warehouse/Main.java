package warehouse;

import java.util.Scanner;

import static warehouse.Warehouse.addProduct;


public class Main {
    public static void main(String[] args) {
      String[] arrayChoice = {"dodajProduct","wyswietlStan",
              "sumaWartosci","aktualizujStan"};
      Warehouse tmp = new Warehouse();


        Product p1 = new Product("kombinerki" , 87, 12);
        Warehouse w1 = new Warehouse(p1);
        Product p2 = new Product("nozyczki" , 5, 18);
        Warehouse w2 = new Warehouse(p2);

      displayChoice(arrayChoice);
      String choice  = getChoice();
      doOption(choice,w2);
//      tmp.displayTheStatusOfWarehouse();


    }

    private static void doOption(String choice,Warehouse tmp){
       if("dodajProduct".equals(choice)){
           addProduct();
       }else if ("wyswietlStan".equals(choice)){
           tmp.displayTheStatusOfWarehouse();
       }else if("sumaWartosci".equals(choice)){
           tmp.sumProduct();
       }else if("aktualizujStan".equals(choice)){
           System.out.println("-\n+\nzmien wszytsko");
         String choice2 = getChoice();
           Scanner scanner = new Scanner(System.in);
           System.out.println("Podaj nazwe produktu: ");
           String name = scanner.next();
           System.out.println("Podaj cene produktu: ");
           double price = scanner.nextDouble();
           System.out.println("Podaj ilość sztuk: ");
           int quantity = scanner.nextInt();

         if("-".equals(choice2)){
             tmp.updateTheStatusOfWarehouseAddORSubtract(name,price,quantity,choice2);
         }else if("+".equals(choice2)){
             tmp.updateTheStatusOfWarehouseAddORSubtract(name,price,quantity,choice2);
         }else if("zmien wszytsko".equals(choice2)){
             tmp.updateTheStatusOfWarehouse(name,price,quantity);
         }
       }
    }

    private static String getChoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Co chcesz zrobić ? ");
        return scanner.next();
    }

    private static void  displayChoice(String [] array){
        System.out.println("Lista opcji: ");
        for(String c : array){
            System.out.println("- " + c);
        }
    }


}
