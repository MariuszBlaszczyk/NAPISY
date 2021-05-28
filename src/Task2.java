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
        String regex = "\\w*";
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
        char[] arrayText2 = secondUserText.toCharArray();
        for (int i = 0; i < arrayText2.length; i++) {
            if (isVowel(arrayText2[i])) {
                firstVowel = arrayText2[i];
                break;
            } else {
                System.out.println("NIEPRAWIDŁOWE DANE WEJŚCIOWE");
                break;
            }
        }
        char[] arrayText1 = firstUserText.toCharArray();
        for (int i = 0; i < arrayText1.length; i++) {
            if (!isVowel(arrayText1[i])) {
                arrayText1[i] = firstVowel;
            }
        }
        //WYNIK FINALNY NIE JEST TAKI JAKIEGO BYM OCZEKIWAŁ, LITERY SIĘ PODMIENIAJĄ, ALE SĄ ŁĄCZONE
        // I WYSKAKUJE ZA KAŻDYM RAZEM KOMUNIKAT Z ELSE
        return String.valueOf(arrayText1);

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
