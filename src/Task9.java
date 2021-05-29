import java.util.Scanner;

public class Task9 {

    /*
    Pobierz od użytkownika napis i powiel w nim n razy wszystkie wystąpienia znaku podanego przez użytkownika,
    gdzie n to liczba pobrana przez użytkownika.
    Przykład:
    Wyraz: abecadlo, n = 3, znak od użytkownika = a wynik: aaabecaaadlo
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

    static String getSignFromUser() {
        Scanner scan = new Scanner(System.in);
        String userSign = null;
        String regex = "\\w";
        boolean error = true;
        do {
            try {
                do {
                    System.out.println("Give the sign");
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

    static int getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        int userNumber = 0;
        boolean error = true;
        do {
            try {
                System.out.println("Give the number");
                userNumber = scan.nextInt();
                error = false;
            } catch (Exception e) {
                System.out.println("You must give the number");
                scan.nextLine();
            }
        } while (error);
        return userNumber;
    }

    static String finalResult(String text, int number, String sign) {
        if (text == null || text.isEmpty()) {
            throw new IllegalStateException("Text is empty");
        }
        if (number == 0) {
            throw new IllegalStateException("The number must be greater than zero");
        }
        if (sign == null || sign.isEmpty()) {
            throw new IllegalStateException("Sign is empty");
        }
        char signChar = sign.charAt(0);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (signChar == ch) {
                for (int j = 0; j < number; j++) {
                    builder.append(signChar);
                }
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {

        String text = getStringFromUser();
        System.out.println("User text is: " + text);
        int number = getNumberFromUser();
        System.out.println("User number is: " + number);
        String userSign = getSignFromUser();
        System.out.println("User sign is: " + userSign);

        String newText = finalResult(text, number, userSign);
        System.out.println("New text: " + newText);
    }
}
