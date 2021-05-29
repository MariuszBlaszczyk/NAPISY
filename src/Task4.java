import java.util.Scanner;

public class Task4 {

    /*
    Pobieraj od użytkownika napis, dopóki jego długość nie będzie liczbą parzystą.
    Następnie zamień miejscami kolejne pary znaków, tak jak pokazano to w przykładzie:
    przed -> ABCDEF, po -> BADCFE. Wypisz zmodyfikowany napis.
     */

    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
        String text = null;
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
        char[] ch = text.toCharArray();
        for (int i = 0; i < ch.length; i += 2) {
            char temp = ch[i];
            ch[i] = ch[i + 1];
            ch[i + 1] = temp;
        }
        return new String(ch);
    }


    public static void main(String[] args) {

        String userText = getStringFromUser();
        String result = swapPairsOfCharacters(userText);
        System.out.println(result);
    }
}
