package sample;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class DvisibleBy235 {
    public static void main(String[] args) {

        for (int i = 0; i <= 100; i++) {
            divisible(i);
        }

        Clock a = Clock.systemDefaultZone();
        LocalDate monday = LocalDate.parse("2020-10-09");
        returnMonday(monday);

    }

    private static void returnMonday(LocalDate localDate) {
        String[] dayOfWeekARRAY = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        LocalDate monday = null;

        for (int i = 0; i < dayOfWeekARRAY.length; i++) {
            if (dayOfWeek.toString().equals(dayOfWeekARRAY[i].toString())) {
                monday = localDate.minusDays(i);
            }
        }
        System.out.println(dayOfWeek);
        System.out.println(monday);

    }

    private static void divisible(int liczba) {
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag5 = false;
        if (divisibleBy2(liczba)) {
            flag2 = true;
            if (divisibleBy3(liczba)) {
                flag3 = true;
            }
            if (divisibleBy5(liczba)) {
                flag5 = true;
            }

            if (flag2 && flag3 && flag5) {
                System.out.printf("%d jest podzielna przez 2 3 i 5\n", liczba);
            } else if (flag2 && flag5) {
                System.out.printf("%d jest podzielna: przez 2 i 5\n", liczba);
            } else if (flag2 && flag3) {
                System.out.printf("%d podzielna przez 2 i 3\n", liczba);
            } else if (flag2) {
                System.out.printf("%d jest podzielna przez 2\n", liczba);
            }

        } else if (divisibleBy3(liczba)) {
            flag3 = true;
            if (divisibleBy5(liczba)) {
                flag5 = true;
            }
            if (flag3 && flag5) {
                System.out.printf("%d jest podzielna przez 3 i 5\n", liczba);
            } else if (flag3) {
                System.out.printf("%d jest podzielna przez 3\n", liczba);
            }

        } else if (divisibleBy5(liczba)) {
            System.out.printf("%d jest podzielna przez 5\n", liczba);
        } else {
            System.out.printf("%d\n", liczba);
        }
    }

    private static boolean divisibleBy2(int number) {
        return number % 2 == 0;
    }

    private static boolean divisibleBy3(int number) {
        return number % 3 == 0;
    }

    private static boolean divisibleBy5(int number) {
        return number % 5 == 0;
    }
}
