package sample;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] tab4 = {2, 3, 2, 2, 2, 5, 5, 5, 5, 5, 6, 7, 8, 9, 9, 9, 9, 9};
        printTable(getDistinct(tab4));
        boolean[] array = createTable(7);
        checkIfPrimeNumber(array, 7);
        ifPrimeNumber1(array, 7);

    }

    private static int[] getDistinct(int[] array) {
        Arrays.sort(array);
        int index = 0;
        int[] tab = new int[array.length];
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                tab[index] = array[i];
                index++;
            }
        }

        tab[index] = array[array.length - 1];

        System.out.println(array[array.length - 1]);
        System.out.println(index);

        int[] tab1 = new int[index + 1];
        for (int i = 0; i <= index; i++) {
            tab1[i] = tab[i];
        }
        return tab1;
    }

    private static int[] removeDuplicate(int[] input) {
        Arrays.sort(input);
        int n = input.length;
        int[] tmp = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (input[i] != input[i + 1]) {
                tmp[j++] = input[i];
            }
        }
        tmp[j++] = input[n - 1];
        int[] result = new int[j];
        for (int i = 0; i < j; ++i) {
            result[i] = tmp[i];
        }
        return result;
    }

    private static void printTableObject(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("tab[%d] = %d\n", i, array[i]);
        }
    }

    private static int[] merge(int[] array1, int[] array2) {
        int lenght1 = array1.length;
        int lenght2 = array2.length;
        int lenght3 = lenght1 + lenght2;

        int[] array3 = new int[lenght3];

        System.arraycopy(array1, 0, array3, 0, array1.length);
        System.arraycopy(array2, 0, array3, array1.length, array2.length);


        return array3;
    }

    private static int[] getLarger(int[] array1, int[] array2) {
        int suma1 = getSum(array1);
        int suma2 = getSum(array2);

        if (suma1 > suma2) {
            return array1;
        }
        return array2;
    }

    private static void printTable(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("tab[%d] = %d\n", i, array[i]);
        }
    }

    private static int[] getMaxAndMinAndSum(int[] array) {
        int sum = getSum(array);
        int max = getMax(array);
        int min = getMin(array);

        int[] array3 = new int[3];
        array3[0] = max;
        array3[1] = min;
        array3[2] = sum;

        return array3;
    }

    private static int getSum(int[] tab) {
        int sum = 0;
        for (int i = 0; i < tab.length; i++) {
            sum += tab[i];
        }
        System.out.println("suma wynosi: " + sum);
        return sum;
    }

    private static int getMin(int[] array) {
        int min = array[0];
        for (int tab : array) {
            if (tab < min) {
                min = tab;
            }
        }
        System.out.println(min);
        return min;
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int tab : array) {
            if (tab > max) {
                max = tab;
            }
        }
        System.out.println(max);
        return max;
    }

    private static void print(int... array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("tab[%d] = %d\n", i, array[i]);
        }
    }

    private static boolean[] createTable(int integer) {
        boolean tab[] = new boolean[integer + 1];
        for (int i = 0; i <= integer; i++) {
            if (i == 0 || i == 1) {
                tab[i] = false;
            } else {
                tab[i] = true;
            }
        }
        return tab;
    }

    private static boolean[] checkIfPrimeNumber(boolean[] tab, int integer) {

        for (int i = 2; i <= integer; i++) {
            for (int j = i + i; j <= integer; j = j + i) {
                tab[j] = false;
            }
        }
        return tab;
    }

    private static void ifPrimeNumber1(boolean[] tab, int integer) {
        if (integer < 0) {
            System.out.println("nie jest liczbą pierwszą");
        } else if (tab[integer] == true) {
            System.out.println("Jest liczbą pierwszą ");
        } else {
            System.out.println("Nie jest liczbą pierwsza");
        }
    }
}
