package sample;

import java.util.Scanner;

public class Banknotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String quota = getQuota(scanner);
        cos(quota);
    }

    private static String rekursiveUnity(int iterator, boolean isFive, boolean isTwo,
                                         boolean isOne, int ileRazy5, int ileRazy2, int ileRazy1) {
        int number = iterator;
        String monety = "";

        while (number != 0) {
            if (number - 5 >= 0) {
                isFive = true;
                ileRazy5++;
                number -= 5;
                rekursiveUnity(number, isFive, isTwo, isOne, ileRazy5, ileRazy2, ileRazy1);
            } else if (number - 2 >= 0) {
                isTwo = true;
                ileRazy2++;
                number -= 2;
                rekursiveUnity(number, isFive, isTwo, isOne, ileRazy5, ileRazy2, ileRazy1);
            } else if (number - 1 >= 0) {
                isOne = true;
                ileRazy1++;
                number -= 1;
            }
        }

        if (isFive) {
            monety += ileRazy5 + " moneta pięciozłotowa,";
        }
        if (isTwo) {
            monety += ileRazy2 + " moneta dwuzłotowa, ";
        }
        if (isOne) {
            monety += ileRazy1 + " złotówka";
        }

        return monety;
    }

    private static String rekursiveTens(int iterator, boolean isFive, boolean isTwo,
                                        boolean isOne, int ileRazy5, int ileRazy2, int ileRazy1) {

        int number = iterator;
        String monety = "";
        while (number != 0) {
            if (number - 5 >= 0) {
                isFive = true;
                ileRazy5++;
                number -= 5;
                rekursiveTens(number, isFive, isTwo, isOne, ileRazy5, ileRazy2, ileRazy1);
            } else if (number - 2 >= 0) {
                isTwo = true;
                ileRazy2++;
                number -= 2;
                rekursiveTens(number, isFive, isTwo, isOne, ileRazy5, ileRazy2, ileRazy1);
            } else if (number - 1 >= 0) {
                isOne = true;
                ileRazy1++;
                number -= 1;
            }
        }
        if (isFive) {
            monety += ileRazy5 + " banknot piędziesięciozłotowy,";
        }
        if (isTwo) {
            monety += ileRazy2 + " banknot dwudziestozłotowy, ";
        }
        if (isOne) {
            monety += ileRazy1 + " banknot dziesięciozłotowy";
        }

        return monety;
    }

    private static String rekursiveHundreds(int iterator, boolean isFive, boolean isTwo,
                                            boolean isOne, int ileRazy5, int ileRazy2, int ileRazy1) {

        int number = iterator;
        String monety = "";
        while (number != 0) {
            if (number - 5 >= 0) {
                isFive = true;
                ileRazy5++;
                number -= 5;
                rekursiveHundreds(number, isFive, isTwo, isOne, ileRazy5, ileRazy2, ileRazy1);
            } else if (number - 2 >= 0) {
                isTwo = true;
                ileRazy2++;
                number -= 2;
                rekursiveHundreds(number, isFive, isTwo, isOne, ileRazy5, ileRazy2, ileRazy1);
            } else if (number - 1 >= 0) {
                isOne = true;
                ileRazy1++;
                number -= 1;
            }
        }
        if (isFive) {
            monety += ileRazy5 + " banknot piciosetzłotowy,";
        }
        if (isTwo) {
            monety += ileRazy2 + " banknot dwusuzłotowy, ";
        }
        if (isOne) {
            monety += ileRazy1 + " banknot stuzłotowy";
        }
        return monety;

    }

    private static String checkIfHas500(String hundredsBanknotes) {
        String newHundredsBanknotes = hundredsBanknotes;
        if (hundredsBanknotes.contains("1 banknot piciosetzłotowy,")) {
            newHundredsBanknotes = hundredsBanknotes.replaceAll("1 banknot piciosetzłotowy,", "");
        }

        return newHundredsBanknotes;
    }

    private static int getNew500(String hundredsBanknotes) {
        int ifAdd = 0;
        if (hundredsBanknotes.contains("1 banknot piciosetzłotowy,")) {
            ifAdd++;
        }

        return ifAdd;
    }

    private static int rekursiveThousandAndSoOn(char iterator, int i, int lenght) {

        String a = String.valueOf(iterator);

        for (int j = i + 1; j < lenght; j++) {
            a += "0";
        }
        System.out.println(a);

        Integer b = Integer.valueOf(a);
        return b / 500;

    }

    private static void cos(String quota) {
        int lenght = quota.length();
        boolean ifOne = false;
        boolean ifTwo = false;
        boolean ifFive = false;
        String hundredsBanknotes = "";
        String unityCoins = "";
        String tensBanknotes = "";
        String thousandsBanktotes = "";
        int thousandsBanknotesInt = 0;
        int sumThousandBanknotes = 0;
        String newHundredsBanknotes = "";

        for (int i = lenght - 1; i >= 0; i--) {
            if (i == lenght - 1) {
                unityCoins = rekursiveUnity(Integer.valueOf(quota.charAt(i) - 48), ifFive, ifTwo, ifOne, 0, 0, 0);
            } else if (i == lenght - 2) {
                tensBanknotes = rekursiveTens(Integer.valueOf(quota.charAt(i) - 48), ifFive, ifTwo, ifOne, 0, 0, 0);
            } else if (i == lenght - 3) {
                hundredsBanknotes = rekursiveHundreds(Integer.valueOf(quota.charAt(i) - 48), ifFive, ifTwo, ifOne, 0, 0, 0);
                newHundredsBanknotes = hundredsBanknotes;
            } else {

                thousandsBanknotesInt = rekursiveThousandAndSoOn(quota.charAt(i), i, quota.length());
                sumThousandBanknotes += thousandsBanknotesInt;
            }
        }
        if (lenght >= 4) {
            newHundredsBanknotes = checkIfHas500(hundredsBanknotes);
            System.out.println(newHundredsBanknotes);
            int ifAdd = getNew500(hundredsBanknotes);
            System.out.println(ifAdd);

            if (ifAdd == 1) {
                thousandsBanktotes = (sumThousandBanknotes + 1) + " banknot piciosetzłotowy,";
            } else {
                thousandsBanktotes = (sumThousandBanknotes) + " banknot piciosetzłotowy,";
            }
        }

        System.out.println(thousandsBanktotes + newHundredsBanknotes + tensBanknotes + unityCoins);

    }

    private static String getQuota(Scanner scanner) {
        System.out.println("Podaj kwotę!!");
        return scanner.next();
    }
}
