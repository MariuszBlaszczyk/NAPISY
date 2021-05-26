package task.nr1.app;

import task.nr1.logic.Methods;

public class App {

    public static void main(String[] args) {

        Methods methods = new Methods();
        String userText = methods.getStringFromUser();


        int x = Methods.howManyCharactersHaveAnOddDigitOfUnity(userText);
        System.out.println(x);

    }
}
