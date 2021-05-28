import java.util.Scanner;

public class Task8 {

    /*
    Pobierz od użytkownika napis i sprawdź, ile występuje w nim wyrazów.
    Zbadaj, ile wyrazów zaczyna się z dużej litery oraz ile wyrazów zaczyna się z małej litery.
    Wypisz na ekranie otrzymane wyniki.
     */

    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
        String text = "";
        String regex = "\\w+";
        boolean error = true;
        do {
            try {
                do {
                    System.out.println("Give the inscription");
                    text = scan.nextLine();
                    error = false;
                } while (!text.matches(regex));
            } catch (Exception e) {
                System.out.println("You must provide a caption consisting of capital letters");
                scan.nextLine();
            }
        } while (error);
        return text;
    }

    static int howManyWordsAreInAJavaText(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return text.length();
    }

    public static void main(String[] args) {

        String userText = getStringFromUser();

        int wordsInText = howManyWordsAreInAJavaText(userText);
        System.out.println("Is " + wordsInText + " words in text.");
    }
}
