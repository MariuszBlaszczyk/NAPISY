import java.util.Scanner;

public class Task3 {

    /*
    Pobierz od użytkownika napis i wykonaj zestawienie, w którym wypiszesz,
    ile w napisie jest małych liter, dużych liter oraz cyfr.
     */


    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
        String text = "";
        String regex = "\\w+.*";
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

    static int howManyLowercaseLettersAreInTheWording(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("The inscription is empty");
        }
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                counter++;
            }
        }
        return counter;
    }

    static int howManyUppercaseLettersAreInTheWording(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("The inscription is empty");
        }
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                counter++;
            }
        }
        return counter;
    }

    static int howManyDigitsAreInTheWording(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("The inscription is empty");
        }
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= '0' && ch <= '9') {
                counter++;
            }
        }
        return counter;
    }


    public static void main(String[] args) {

        String userText = getStringFromUser();

        int lowercase = howManyLowercaseLettersAreInTheWording(userText);
        int uppercase = howManyUppercaseLettersAreInTheWording(userText);
        int digit = howManyDigitsAreInTheWording(userText);

        System.out.println("The caption features " + lowercase + " lowercase.");
        System.out.println("The caption features " + uppercase + " upercase.");
        System.out.println("The caption features " + digit + " digit.");
    }
}
