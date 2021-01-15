package sample;

public class charAndCharAt {
    public static void main(String[] args) {
        char[] tab = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'
                ,'q','p','r','s','t','u','w','x','y','z'};

                ex4alfabet();

//        ex1AllWord(tab);

//        ex2(tab);

//        ex3AllWordReverse(tab);

//        ex5zmiennaTekstowa();
//        ex6alfabet();

//        ifPalindrom();

        theLongestSequenceOfWord();
//        contains();

    }

    private static void contains(){
        String s = "Ala ma kota";
        String s1 = "ma";
        System.out.println("Czy jeden zawiera sie w drugim? " + s.contains(s1));
    }


    private static void theLongestSequenceOfWord(){
        int zmienna = 1;
        int lenght= 0 ;
        String a = "aaabbbbbccaa";
        for (int i = 0 ; i < a.length() ; i++) {
            if (i == a.length() - 1) {
                lenght++;
                break;
            } else {
                if (a.charAt(i) == a.charAt(i + 1)) {
                    zmienna++;
                } else {
                    lenght++;
                }
            }
        }
        System.out.println(lenght);
        Litera [] jakaLitera = new Litera[lenght];
        lenght = 0;
        zmienna = 1;
         a = "aaabbbbbccaa";
        for (int i = 0 ; i < a.length() ; i++) {
            if (i == a.length() - 1) {
                jakaLitera[lenght] = new Litera(a.charAt(i - 1), zmienna);
                break;
            } else {
                if (a.charAt(i) == a.charAt(i + 1)) {
                    zmienna++;
                } else {
                    jakaLitera[lenght] = new Litera(a.charAt(i), zmienna);
                    lenght++;
                    zmienna = 1;
                }
            }
        }

        for (int i = 0 ; i < jakaLitera.length ; i++){
            System.out.printf("Litera : %s wystepuje :%d razy\n"
                    , jakaLitera[i].jakaLitera,jakaLitera[i].ileWystapien);
        }

        int max = jakaLitera[0].ileWystapien;
        int index = 0;
        for (int i = 0 ; i < jakaLitera.length ; i++){
          if(jakaLitera[i].ileWystapien > max){
              max = jakaLitera[i].ileWystapien;
              index = i;
          }
        }

        System.out.printf("Najdłuzszy ciąg wystąpień litery %s wynosi %d",jakaLitera[index].jakaLitera,max);

    }

    private static void ifPalindrom(){
    String p1 = "zagwiżdż i w gaz";
    String p = "Asa loguj u golasa";
    int last = p.length()-1;
    int bad = 0;

    for (int i = 0 ; i < p.length() ; i++) {
        if(p.toLowerCase().charAt(last) == ' '){
          last--;
        }
        if(p.toLowerCase().charAt(i) == ' '){
            i++;
        }
        if (p.toLowerCase().charAt(i) != p.toLowerCase().charAt(last)){
         bad++;
         break;
        }
        last--;
    }

    if(bad == 1){
        System.out.println("nie jest palindromem");
    }else{
        System.out.println("Jest palindromem");
    }

    }

    private static void ex5zmiennaTekstowa(){
        String s = "Edyta";
        for (int i = 0 ; i < s.length() ; i++){
            System.out.println(s.charAt(i));
        }

    }

    private static void ex6alfabet(){
        String alfabet = "alfabet";
        int iloscWystapien = 0;

      for (int i = 0 ; i < alfabet.length() ; i++){
          if(alfabet.charAt(i) == 'a'){
             iloscWystapien++;
          }
      }
        System.out.println("Liczba wystapień 'a ' wynosi: " + iloscWystapien);
    }

    private static void ex4alfabet(){
        String alfabet = "alfabet";
        int iloscWystapien = 0;
        char max = alfabet.charAt(0);

        for (int i = 0 ; i < alfabet.length()  ; i++){
            if(alfabet.charAt(i) > max) {
                max = alfabet.charAt(i);
            }
        }
        System.out.println("Max litera: " + String.valueOf(max).toUpperCase());
    }

    private static void ex3AllWordReverse(char[] tab){

        for (int i = tab.length - 1 ; i >= 0 ; i--){
            System.out.println(tab[i]);
        }

    }

    private static void ex2(char[] tab){
        for (int i = 0 ; i < tab.length ; i++){
            if(evenNumber(i)) {
                System.out.println(tab[i]);
            }
        }
    }

    private static void ex1AllWord(char[] tab){

        for (int i = 0 ; i < tab.length ; i++){
            System.out.println(tab[i]);
        }

    }



    static boolean  evenNumber(int i){
            return i % 2 == 0;
        }


}

class Litera {
    char jakaLitera;
    int ileWystapien;
    public Litera(char jakaLitera , int ileWystapien){
        this.jakaLitera = jakaLitera;
        this.ileWystapien = ileWystapien;
    }


}
