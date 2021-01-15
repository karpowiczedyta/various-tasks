package sample;

import java.util.Random;
import java.util.Scanner;

public class RandomArray {

    public static void main(String[] args) {

        int lenghtArray = getLengthArrayFromUser();
        int maxNumberInArray = getMaxNumberInArray();
        int[] arrayWithNumbers = createArray(lenghtArray,maxNumberInArray);
        printTable(arrayWithNumbers);
        printEvenNumbers(arrayWithNumbers);
        printOddNumbersDivisibleBy3(arrayWithNumbers);
        displayNumberAverageInArray(arrayWithNumbers);
        maxValue(arrayWithNumbers);
        minValue(arrayWithNumbers);
        int maxNumbersAndLessNumbersThanThisValues = getNumberWhichWillBeMaxAndDisplayNumbersLessThanThisValue();
        int[] newTable = newTableIncludeElementLessFromUserValue(arrayWithNumbers,maxNumbersAndLessNumbersThanThisValues);
        System.out.println("NOWA TABLICA");
        printTable(newTable);
        //========================================================================
        int[] newTableEvenTable = newTableEvenTable(arrayWithNumbers);
        printTable(newTableEvenTable);
        int[] newTableOddNumbers = newTableOddNumbers(arrayWithNumbers);
        printTable(newTableOddNumbers);
        int [][] multiArray = creatMultiArray(newTableEvenTable,newTableOddNumbers);
        printMultiArray(multiArray);
        prinArrayReverse(arrayWithNumbers);

    }
    //h

    private static void prinArrayReverse(int[] array){
        for (int i = array.length - 1 ; i >= 0 ; i--){
            System.out.printf("tab[%d] = %d\n",i,array[i]);
        }
    }
    private static void printMultiArray(int[][] multiArray){
        System.out.println("Elementy tablicy dwuwymaiorej: 1 wiersz liczby parzyste 2 wiersz liczby nie parzyste");
        for (int i = 0 ; i < multiArray.length ; i++){
            for (int j = 0 ; j < multiArray[i].length ; j++){
                System.out.printf("tab[%d][%d] = %d\n",i,j,multiArray[i][j]);
            }
        }
    }

    //g
    private static int[][] creatMultiArray(int[] arrayEven , int[] arrayOdd){

        int lenghtEven = arrayEven.length;
        int lenghtOdd = arrayOdd.length;


        int[][] multiArray = {arrayEven,arrayOdd};

        for (int i = 0 ; i < multiArray.length ; i++){
            if(i == 0) {
                for (int j = 0; j < lenghtEven; j++) {
                    multiArray[i][j] = arrayEven[j];
                }
            }else{
                for (int j = 0; j < lenghtOdd; j++) {
                    multiArray[i][j] = arrayOdd[j];
                }
            }
        }
        return multiArray;
    }

    private static int[] newTableEvenTable(int[] array){
        int newSize = 0;
        for(int i = 0 ; i < array.length ; i++){
            if(ifEvenNumbers(array[i])){
             newSize ++;
            }
        }
        System.out.println(newSize);
        int index = 0;
        int[] newTableEvenNumbers = new int[newSize];
        for(int i = 0 ; i < array.length ; i++){
            if(ifEvenNumbers(array[i])){
                newTableEvenNumbers[index] = array[i];
                index ++;
            }
        }
        return newTableEvenNumbers;
    }

    private static int[] newTableOddNumbers(int[] array){
        int newSize = 0;
        for(int i = 0 ; i < array.length ; i++){
            if(ifOddNumbers(array[i])){
                newSize ++;
            }
        }
        System.out.println(newSize);
        int index = 0;
        int[] newTableOddNumbers = new int[newSize];
        for(int i = 0 ; i < array.length ; i++){
            if(ifOddNumbers(array[i])){
                newTableOddNumbers[index] = array[i];
                index ++;
            }
        }
        return newTableOddNumbers;
    }

    //============================================================================================

    //f
    private static int[] newTableIncludeElementLessFromUserValue(int[] array , int maxValueFormUser){
        int newSize = array.length;
        for (int i = 0; i < array.length ; i++){
            if(array[i] < maxValueFormUser){
                newSize -- ;
            }
        }
        int[] newTable = new int[newSize];
        int index = 0 ;
        for (int i = 0; i < array.length ; i++) {
            if (array[i] < maxValueFormUser) {
            newTable[index] = array[i];
            index ++;
            }
        }
        return newTable;
    }


    //e1
    private static void minValue(int[] array){
        int min = array[0];
        int index = 0;

        for (int i = 0 ; i < array.length ; i++){
            if(array[i] < min ){
                min = array[i];
                index = i;
            }
        }
        System.out.println("Minimalna wartość indeksu wynosi: " + min + "Index: " + index);
    }

    //e

    private static void maxValue(int[] array){
        int max = array[0];
        int index = 0;

        for (int i = 0 ; i < array.length ; i++){
            if(array[i] > max ){
                max = array[i];
                index = i;
            }
        }
        System.out.println("Maksymalna wartość indeksu wynosi: " + max + "Index: " + index);
    }

    //d
    private static void displayNumberAverageInArray(int[] array){
        int sum = 0;
       double average = 0;
        for(int i = 0 ; i < array.length ; i++){
            sum += array[i];
        }
        average = sum / array.length;
        System.out.println("Srednia liczb przechowywanych w tablicy wynosi: " + average);
    }

    //c
    private static void printOddNumbersDivisibleBy3(int[] array){
        System.out.println("Liczby nieparzyste podzielne przez 3");
        for (int i = 0 ;i < array.length ; i++){
            if(ifOddNumbers(array[i])){
                if(ifDisibleBy3(array[i]))
                System.out.println("- " + array[i]);
            }
        }

    }

    //b
    private  static void printEvenNumbers(int[] array){
        System.out.println("Liczby parzyste");
        for (int i = 0 ;i < array.length ; i++){
            if(ifEvenNumbers(array[i])){
                System.out.println("- " + array[i]);
            }
        }
    }

    //a
    private static void printTable(int[] array){
        System.out.println("ELEMENTY TABLICY: ");
        for(int element : array){
            System.out.println("- "+element);
        }
    }

    private static int getLengthArrayFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podj długośc tablicy");
        return scanner.nextInt();
    }

    private static int getMaxNumberInArray(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podj maksymalna liczbe w tablicy");
        return scanner.nextInt();
    }

    private static int[] createArray(int lenght , int max){

        Random r = new Random();

        int[] arrayWithNumber = new int[lenght];

        for (int i = 0 ;i < arrayWithNumber.length ; i++){
            arrayWithNumber[i] = r.nextInt(max);
        }
        return arrayWithNumber;
    }

    private static boolean ifEvenNumbers(int number){
        return number % 2 == 0;
    }

    private static boolean ifOddNumbers(int number){
        return number % 2 != 0;
    }

    private static boolean ifDisibleBy3(int number){
        return number % 3 == 0;
    }

    private static int getNumberWhichWillBeMaxAndDisplayNumbersLessThanThisValue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę: ");
        return scanner.nextInt();
    }


}
