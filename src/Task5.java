import java.util.Scanner;

public class Task5 {

    /*
    Pobierz od użytkownika dwa napisy i wygeneruj trzeci napis.
    Trzeci napis zawiera na początku same samogłoski z napisu pierwszego,
    a następnie same spółgłoski z napisu drugiego.
    Przykład: napis pierwszy -> abcdef, napis drugi -> ghijkl, wynik -> aeghjkl.
     */

    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
        String text = "";
        String regex = "\\w*";
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

    static boolean isVowel(char character) {
        return character == 'a' || character == 'e' || character == 'i' ||
                character == 'o' || character == 'u' || character == 'A' || character == 'E' ||
                character == 'I' || character == 'O' || character == 'U';
    }

    static String createThirdInscription(String text1, String text2) {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < text1.length(); i++) {
            char ch = text1.charAt(i);
            if (isVowel(ch)) {
                newText.append(ch);
            }
        }
        for (int i = 0; i < text2.length(); i++) {
            char ch = text2.charAt(i);
            if (!isVowel(ch)) {
                newText.append(ch);
            }
        }
        return String.valueOf(newText);
    }

    public static void main(String[] args) {

        String userText1 = getStringFromUser();
        String userText2 = getStringFromUser();

        String result = createThirdInscription(userText1, userText2);
        System.out.println("Third inscription: " +result);
    }
}
