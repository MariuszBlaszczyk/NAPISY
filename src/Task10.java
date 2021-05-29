import java.util.Scanner;

public class Task10 {

    /*
    Pobieraj od użytkownika napis, dopóki nie będzie zawierał poprawnie zapisanej liczby.
    Zakładamy, że poprawnie zapisana liczba to taka, do której zapisu użyto „zwykłego” zapisu
    lub notacji naukowej. Przykłady poprawnie zapisanych liczb:
    2.4, -12.45, 10E12, -5.45E9, 8E-3, 23.34e10, 24.3e-5.
     */

    static String getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        String userSign = null;
        String regex = "\\w.+";
        boolean error = true;
        do {
            try {
                do {
                    System.out.println("Give the number");
                    userSign = scan.nextLine();
                    error = false;
                } while (!userSign.matches(regex));
            } catch (Exception e) {
                System.out.println("You must give the inscription");
                scan.nextLine();
            }
        } while (error);
        return userSign;
    }
}
