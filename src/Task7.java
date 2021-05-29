import java.util.Scanner;

public class Task7 {

    /*
    Pobieraj od użytkownika dwa napisy, dopóki nie będą posiadały tej samej długości.
    Następnie wygeneruj trzeci napis, który będzie zawierał w sobie na przemian znaki z pierwszego
    i drugiego napisu. Przykładowo wyraz pierwszy ABCD oraz wyraz drugi EFGH dają wynik AEBFCGDH.
     */

    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
        String userText = "";
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

    static String createNewString(String text1, String text2) {
        if (text1 == null || text1.isEmpty()) {
            throw new IllegalArgumentException("The first inscription is empty");
        }
        if (text2 == null || text2.isEmpty()) {
            throw new IllegalArgumentException("The second inscription is empty");
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text1.length(); i++) {
            char ch = text1.charAt(i);
            builder.append(ch);
            ch = text2.charAt(i);
            builder.append(ch);
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        String userText1, userText2;

        do {
            System.out.println("Give the first inscription");
            userText1 = getStringFromUser();
            System.out.println("Give the second inscription");
            userText2 = getStringFromUser();
        } while (!(userText1.length() == userText2.length()));

        String cre = createNewString(userText1, userText2);
        System.out.println(cre);
    }
}
