import java.util.Scanner;

public class Task4 {

    /*
    Pobieraj od użytkownika napis, dopóki jego długość nie będzie liczbą parzystą.
    Następnie zamień miejscami kolejne pary znaków, tak jak pokazano to w przykładzie:
    przed -> ABCDEF, po -> BADCFE. Wypisz zmodyfikowany napis.
     */

    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
        String text = "";
        String regex = "\\w*";
        boolean error = true;
        int textLength = 0;
        do {
            try {
                do {
                    System.out.println("Give the inscription");
                    text = scan.nextLine();
                    textLength = text.length();
                    error = false;
                } while (!text.matches(regex) || !(textLength % 2 == 0));
            } catch (Exception e) {
                System.out.println("You must provide a caption consisting of capital letters");
                scan.nextLine();
            }
        } while (error);
        return text;
    }

    static String swapPairsOfCharacters(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("The inscription is empty");
        }
        char[] chars = text.toCharArray();
        char helpedChar = 'a';
        for (int i = 0; i < chars.length; i++) {
            chars[0] = chars[1];
            chars[1] = chars[0];
            helpedChar = chars[2];
        }
        return String.valueOf(text);
    }


    public static void main(String[] args) {

        String userText = getStringFromUser();
        String result = swapPairsOfCharacters(userText);
        System.out.println(result);
    }
}
