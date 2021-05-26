
import java.util.Scanner;

public class Task1 {

    /*
    Pobieraj od użytkownika napis, dopóki nie będzie składał się z samych dużych liter.
    Przeprowadź analizę pobranego napisu:
    a) Zlicz, ile w napisie znajduje się znaków, których kod ASCII posiada nieparzystą cyfrę jedności
    b) Oblicz sumę kodów ASCII znaków znajdujących się na parzystych indeksach w napisie.
    Następnie znajdź pierwszą liczbę z przedziału <65, 90>, która jest dzielnikiem wyznaczonej wcześniej sumy.
    Będzie to kod ASCII jednej z dużych liter alfabetu.
    Zlicz, ile w napisie występuje liter większych od wyznaczonej litery.
     */

    static String getStringFromUser() {
        Scanner scan = new Scanner(System.in);
        String text = "";
        String regex = "[A-Z]+.*";
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


    static int howManyCharactersHaveAnOddDigitOfUnity(String text) {
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if ((int) character % 2 != 0) {
                counter++;
            }
        }
        return counter;
    }

    static int theSumOfTheAsciiCodesOfTheCharactersOnTheEvenIndicesInTheString(String text) {
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (i % 2 == 0) {
                sum += (int) character;
            }
        }
        return sum;
    }

    static int findTheFirstNumberFromTheIntervalWhichIsADivisorOfThePreviouslyDeterminedSum
            (int sum, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min is bigger than max!");
        }
        int number = 0;
        for (int i = min; i <= max; i++) {
            if (sum % i == 0) {
                number = i;
                break;
            }
        }
        return number;
    }

    static int howManyLettersInTheWordAreLargerThanTheDesignatedLetter(int asciiCode) {
        if (asciiCode == 0) {
            throw new IllegalArgumentException("Ascii code is null.");
        }
        char character = 'a';
        asciiCode = (char) character;
    }

    public static void main(String[] args) {

        String userText = getStringFromUser();

// jaką nazwę nadałbyś tym zmiennym tak żeby było wiadomo o co chodzi?
        int counter = howManyCharactersHaveAnOddDigitOfUnity(userText);
        int sum = theSumOfTheAsciiCodesOfTheCharactersOnTheEvenIndicesInTheString(userText);

        System.out.println("Counter: " + counter);
        System.out.println("Suma: " + sum);

        final int MIN = 65;
        final int MAX = 90;

        int firstDivider =
                findTheFirstNumberFromTheIntervalWhichIsADivisorOfThePreviouslyDeterminedSum(sum, MIN, MAX);

        System.out.println("First divider: " + firstDivider);

    }
}
