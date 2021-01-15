package sample;

import java.util.Scanner;

public class Summary {
    public static void main(String[] args) {
        String[] tools = {"kombinerki", "nozyczki", "srubokret"};
        Scanner scanner = new Scanner(System.in);
        boolean zmienna = false;
        boolean isFirst = true;
        String product = "";
        String name = "";
        while (!"dowidzenia".equals(product)) {
            if(isFirst) {
                name = getUserName(scanner);
            }
            printMessage(name, tools);
            product = getProduct(scanner);

            if(!"dowidzenia".equals(product)) {
                zmienna = caseWyborUzytkownika(product);
                isFirst = false;
                if (zmienna) {
                    printTable(removeElement(product, tools));
                    product = "dowidzenia";
                }
            }

        }
        }

        //System.out.println("Zakonczono zakup!!");
        private static boolean czyDowidzenia(String nazwa){
            return "dowidzenia".equals(nazwa) ;
        }



    private static String getUserName(Scanner scanner){
        System.out.println("Podaj imie: ");
        String name = scanner.next();
        return  name;
    }

    private  static void printMessage(String name,String[] tab){
        System.out.printf("Witaj %s !! W naszej ofercie mamy:\n",name.toUpperCase());
        String variableToNameProduct = "";
        for(String nameProduct : tab){
         variableToNameProduct += "- " + nameProduct + "\n";
        }
        System.out.println(variableToNameProduct);
    }
    private static boolean caseWyborUzytkownika(String wybor){
        boolean zmienna ;
        switch(wybor){
            case "kombinerki":
                System.out.println("Wybrano kombinerki");
                zmienna = true;
                break;
            case  "nozyczki":
                System.out.println("Wybrano nozyczki");
                zmienna = true;
                break;
            case  "srubokret":
                System.out.println("Wybrano srubokret");
                zmienna = true;
                break;
            default:
                System.out.println("Takiego poduktu nie mamy w ofercie");
                zmienna = false;
        }
        return zmienna;
    }

    private static String[] removeElement(String wybor , String[] tab){

        int newSize = tab.length;
        for (String el : tab){
            if(el.equals(wybor)){
                newSize --;
            }
        }

        String[] newTab = new String[newSize];
        int zmienna = 0;
        for (int i = 0 ; i < tab.length ; i++){
            if(!wybor.equals(tab[i])){
               newTab[zmienna] = tab[i];
               zmienna++;
            }
        }
        System.out.println("dodano produkt!!!!! " + wybor);
        return newTab;
    }

    private static  void printTable(String[] tab){
        for (String s : tab){
            System.out.println("-" + s);
        }
    }

    private static String getProduct(Scanner scanner ){
        System.out.println("Co chciałbyś kupić? ");
        return scanner.next();
    }


}

