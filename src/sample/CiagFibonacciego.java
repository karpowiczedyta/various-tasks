package sample;

import java.util.Scanner;

public class CiagFibonacciego {
    public static void main(String[] args) {

        int amount = getAmountNumber();
        System.out.println("Wynik koncowy " + FibonnaciSequence(amount, 0, 1, 2, "0,1,"));

    }


    private static String FibonnaciSequence(int amount, int firstNumber1, int secodNumber1, int zmienna1, String fibonacciSequence1) {
        String fibonacciSequenceE = "";
        int firstNumber = firstNumber1;
        int secodNumber = secodNumber1;
        int zmienna = zmienna1;//1
        String fibonacciSequence = fibonacciSequence1;

        if (amount == 0) {
            fibonacciSequence = "0";
            return fibonacciSequence;
        } else if (amount == 1) {
            fibonacciSequence = firstNumber + ", " + secodNumber;
            return fibonacciSequence;
        }

        zmienna++;

        System.out.println("fibonaciesequence::::::::" + fibonacciSequence + "zmienna" + zmienna);
        if (zmienna <= amount) {
            int third = firstNumber + secodNumber;
            fibonacciSequence += third + ",";
            System.out.println("wywoływanie funkcji");
            fibonacciSequence = FibonnaciSequence(amount, secodNumber, third, zmienna, fibonacciSequence);
            System.out.println("Zmienaa nr: " + zmienna);
            System.out.println("po funkcji" + fibonacciSequence);
        }
        System.out.println("jestem po ifie");
        System.out.println(fibonacciSequence);

        return fibonacciSequence;

    }

    private static int getAmountNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ilość liczb dla ciągu Fibbonaciego");
        return scanner.nextInt();
    }


}
