import java.util.Scanner;

public class Task6 {

    /*
    Pobierz od użytkownika napis. Kod ASCII wszystkich znaków, które znajdują się pod indeksem parzystym
    zwiększ o 10, natomiast kod ASCII pozostałych znaków zmniejsz o 5.
    Po tej zmianie oblicz, ile liter znajduje się w zmodyfikowanym napisie.
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

    static int increaseDecreaseCodeAscii(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("The inscription is empty");
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (i % 2 == 0) {
                ch = (char) ((int) ch + 10);
                System.out.println(ch);
            } else {
                ch = (char) ((int) ch - 5);
                System.out.println(ch);
            }
            builder.append(ch);
        }
        int counter = 0;
        for (int i = 0; i < builder.length(); i++) {
            char ch = builder.charAt(i);
            if (Character.isLetter(ch)) {
                counter++;
            }
        }
        return counter;
    }


    public static void main(String[] args) {

        String userText = getStringFromUser();

        int counter = increaseDecreaseCodeAscii(userText);
        System.out.println("The modified caption includes " + counter + " letters.");
    }
}
