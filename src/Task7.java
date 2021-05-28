import java.util.Scanner;

public class Task7 {

    /*
    Pobieraj od użytkownika dwa napisy, dopóki nie będą posiadały tej samej długości.
    Następnie wygeneruj trzeci napis, który będzie zawierał w sobie na przemian znaki z pierwszego
    i drugiego napisu. Przykładowo wyraz pierwszy ABCD oraz wyraz drugi EFGH dają wynik AEBFCGDH.
     */

    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
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

//    static String createNewString(String text1, String text2) {
//        String newText;
//    }

    public static void main(String[] args) {

        String userText1, userText2;

        do {
            System.out.println("Give the first inscription");
            userText1 = getStringFromUser();
            System.out.println("Give the second inscription");
            userText2 = getStringFromUser();
        } while (!(userText1.length() == userText2.length()));
    }
}
