package task.nr1.logic;

import java.util.Scanner;

public class Methods {

    //dlaczego jeśli zmienię tę metodę z public na static, albo w ogóle usunę public to nie działa mi to
    // w kolejnej klasie mimo jej wywołania?
    public String getStringFromUser() {
        return getStringWithExceptions();
    }

    private String getStringWithExceptions() {
        // Dlaczego przy wywołaniu Scanner poza metodą (pomiędzy Methods a tą metodą)
        //  nie mogę go użyc w metodzie?
        // I jak zamknąć w apliakcji teraz tego Scannera?
        Scanner scan = new Scanner(System.in);
        String text = "";
        String regex = "[A-Z]+";
        boolean error = true;
        do {
            try {
                do {
                    System.out.println("Give the inscription");
                    text = scan.nextLine();
                    error = false;
                } while (!text.matches(regex));
            } catch (Exception e) {
                // tutaj w sout powienien znaleźć się opis wyjątku taki pro jak wyskakuje przy błędzie
                //  czy tak jak teraz jest ok?
                System.out.println("You must provide a caption consisting of capital letters");
                scan.nextLine();
            }
        } while (error);
        return text;
    }

    static int unities(int number) {
        return number % 10;
    }


    // niestety ta metoda zlicz ilość znaków w napisie, jakieś pdopwoiedzi?
    public static int howManyCharactersHaveAnOddDigitOfUnity(String text) {
        int counter = 0;
        for (char digit : text.replaceAll("//D", "").toCharArray()) {
            if (Character.getNumericValue(unities(digit)) % 2 != 0) {
                counter++;
            }
        }
        return counter;
    }


}
