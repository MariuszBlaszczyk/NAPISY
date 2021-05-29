import java.util.Arrays;
import java.util.Scanner;

public class Task8 {

    /*
    Pobierz od użytkownika napis i sprawdź, ile występuje w nim wyrazów.
    Zbadaj, ile wyrazów zaczyna się z dużej litery oraz ile wyrazów zaczyna się z małej litery.
    Wypisz na ekranie otrzymane wyniki.
     */

    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
        String userText = null;
        boolean error = true;
        do {
            try {
                System.out.println("Give the inscription");
                userText = scan.nextLine();
                error = false;
            } catch (Exception e) {
                System.out.println("You must give the inscription");
                scan.nextLine();
            }
        } while (error);
        return userText;
    }

    static int howManyWordsAreInAJavaText(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    static int howManyWordsStartWithACapitalLetter(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        int counter = 0;
        String regex = "^[A-Z].*";
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (words[i].matches(regex)) {
                counter++;
            }
        }
        return counter;
    }

    static int howManyWordsStartWithALowercaseLetter(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        int counter = 0;
        String regex = "^[a-z].*";
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (words[i].matches(regex)) {
                counter++;
            }
        }
        return counter;
    }


    public static void main(String[] args) {

        String userText = getStringFromUser();

        int wordsInText = howManyWordsAreInAJavaText(userText);
        System.out.println("Is " + wordsInText + " words in text.");

        int startsWithCapitalLetter = howManyWordsStartWithACapitalLetter(userText);
        System.out.println("The text includes " + startsWithCapitalLetter +
                " words that start with a capital letter.");

        int startsWithLowercaseLetter = howManyWordsStartWithALowercaseLetter(userText);
        System.out.println("The text includes " + startsWithLowercaseLetter +
                " words that start with a lowercase letter.");
    }
}
