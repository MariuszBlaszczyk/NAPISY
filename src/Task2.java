import java.util.Scanner;

public class Task2 {

    /*
    Pobierz od użytkownika dwa napisy. Wszystkie spółgłoski z pierwszego napisu zastąp samogłoską,
    która jako pierwsza, począwszy od indeksu o numerze 0, pojawiła się w napisie drugim.
    Jeżeli w drugim napisie nie wystąpiła samogłoska wyświetl komunikat NIEPRAWIDŁOWE DANE WEJŚCIOWE.
     */

    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
        String text = "";
        String regex = "^[a-zA-Z]+$";
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

//    static String ReplacingVowelSubstitution(String firstUserText, String secondUserText) {
//        char[] character1 = firstUserText.toCharArray();
//        char[] character2 = secondUserText.toCharArray();
//        for (int i = 0; i <= character2.length; i++) {
//
//        }
//        var chars = expression.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (Character.isUpperCase(chars[i])) {
//                chars[i] = Character.toLowerCase(chars[i]);
//            } else if (Character.isLowerCase(chars[i])) {
//                chars[i] = Character.toUpperCase(chars[i]);
//            }
//        }
//        return String.valueOf(chars);
//    }


    public static void main(String[] args) {

        System.out.println("Give the first inscription");
        String firstUserText = getStringFromUser();
        System.out.println("Give the second inscription");
        String secondUserText = getStringFromUser();


    }
}
