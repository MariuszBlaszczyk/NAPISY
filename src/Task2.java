import java.util.Scanner;

public class Task2 {

    /*
    Pobierz od użytkownika dwa napisy. Wszystkie spółgłoski z pierwszego napisu zastąp samogłoską,
    która jako pierwsza, począwszy od indeksu o numerze 0, pojawiła się w napisie drugim.
    Jeżeli w drugim napisie nie wystąpiła samogłoska wyświetl komunikat NIEPRAWIDŁOWE DANE WEJŚCIOWE.
     */

    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
        //inicjalizacja tego Stringa " " jest prawidłowa?
        String text = "";
        //jaka jest różnica pomiędzy
        // "^[a-zA-Z0-9]+$"   a   "[A-Za-z0-9]+.*"   ???
        String regex = "[A-Za-z0-9]+.*";
        boolean error = true;
        do {
            try {
                do {
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

    static boolean isVowel(char character) {
        return character == 'a' || character == 'e' || character == 'i' ||
                character == 'o' || character == 'u' || character == 'A' || character == 'E' ||
                character == 'I' || character == 'O' || character == 'U';
    }


    static String replacingVowelSubstitution(String firstUserText, String secondUserText) {
        if (firstUserText.isEmpty()) {
            throw new IllegalArgumentException("First user text is blank");
        }
        if (secondUserText.isEmpty()) {
            throw new IllegalArgumentException("Second user text is blank");
        }
        char firstVowel = 'a';
        for (int i = 0; i < secondUserText.length(); i++) {
            char ch2 = secondUserText.charAt(i);
            if (!isVowel(ch2)) {
                System.out.println("NIEPRAWIDŁOWE DANE WEJŚCIOWE");
            }
            if (isVowel(ch2)) {
                firstVowel = ch2;
                break;
            }
        }
        for (int j = 0; j < firstUserText.length(); j++) {
            char ch1 = firstUserText.charAt(j);
            if (!isVowel(ch1)) {
                ch1 = firstVowel;
                break;
            }
        }
        return firstUserText;
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
