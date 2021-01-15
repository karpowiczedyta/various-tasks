package sample;

public class UnityTensHundreds {

    public static void main(String[] args) {
        int x = 300;

        String unity = "";
        String tens = "";
        String hundreds = "";
        int temp = -1;
        do {
            temp = x / 10;
            int dzielnik = 1;

            if (temp == 0) {
                unity = getUnity( x % 10);
            } else if (temp == 1) {
                tens = getNascie(x);
            } else if (temp > 1 && temp <=9) {
                tens = getTeens(temp);
                dzielnik = 10;
            } else {
                hundreds = getHundreds(temp / 10);
                dzielnik = 100;
            }

            x = x % dzielnik;
        }
        while (temp > 0);

        System.out.println(hundreds + " " + tens + " " + unity);
    }

    private static String getHundreds(int value) {
        String[] tab = {"", "sto", "dwiescie", "trzysta"};
        return tab[value];
    }

    private static String getTeens(int value) {
        String[] tab = {"", "dziesiec", "dwadziescia", "trzydziesci", "czterdziesci",
        "piecdziesiat", "szescdziesiat", "siedemdziesiat", "osiemdziesiat", "dziewiecdziesiat"};

        return tab[value];
    }

    private static String getNascie(int value) {
        String[] tab = {"", "jedenascie", "dwanascie", "trzynascie", "czternascie",
        "pietnascie", "szesnascie", "siedemnascie", "osiemnascie", "dziewietnascie"};

        return tab[value % 10];
    }

    private static String getUnity(int value) {
        String[]tab = {"", "jeden", "dwa", "trzy", "cztery", "piec",
        "szesc", "siedem", "osiem", "dziewiec"};

        return tab[value];
    }

}
