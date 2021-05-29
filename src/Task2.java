import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Task2 {

    /*
    Pobierz od użytkownika dwa napisy. Wszystkie spółgłoski z pierwszego napisu zastąp samogłoską,
    która jako pierwsza, począwszy od indeksu o numerze 0, pojawiła się w napisie drugim.
    Jeżeli w drugim napisie nie wystąpiła samogłoska wyświetl komunikat NIEPRAWIDŁOWE DANE WEJŚCIOWE.
     */


    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
        String userText = null;
        boolean error = true;
        do {
            try {
                userText = scan.nextLine();
                error = false;
            } catch (Exception e) {
                System.out.println("You must give the inscription");
                scan.nextLine();
            }
        } while (error);
        return userText;
    }

    static boolean isVowel(char character) {
        String string = Character.toString(character).toLowerCase();
        return string.equals("a") || string.equals("e") || string.equals("i") ||
                string.equals("o") || string.equals("u") || string.equals("y");
    }


    static String replacingVowelSubstitution(String firstUserText, String secondUserText) {
        if (firstUserText == null || firstUserText.isEmpty()) {
            throw new IllegalArgumentException("First user text is empty");
        }
        if (secondUserText == null || secondUserText.isEmpty()) {
            throw new IllegalArgumentException("Second user text is empty");
        }
        char firstVowel = 0;
        boolean helped = false;
        for (int i = 0; i < secondUserText.length(); i++) {
            char ch = secondUserText.charAt(i);
            if (isVowel(ch)) {
                firstVowel = ch;
                helped = true;
                break;
            }
        }
        if (!helped) {
            System.out.println("NIEPRAWIDŁOWE DANE WEJŚCIOWE");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firstUserText.length(); i++) {
            char ch = firstUserText.charAt(i);
            if (!isVowel(ch)) {
                sb.append(firstVowel);
            }
            else {
                sb.append(ch);
            }

        }
        return sb.toString();
    }


    public static void main(String[] args) {

        System.out.println("Give the first inscription");
        String firstUserText = getStringFromUser();
        System.out.println("Give the second inscription");
        String secondUserText = getStringFromUser();


        String result = replacingVowelSubstitution(firstUserText, secondUserText);
        System.out.println(result);

    }
}
