package com.mycompany.it2021078.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;


public class inputHandler {
    
    private static Scanner inputhandler = new Scanner(System.in);
    private static Scanner inputhandler2 = new Scanner(System.in);

    public static int getIntInput(String textPromptInput) {
        while (true) {
            try {
                System.out.println(textPromptInput);
                int intInput =  inputhandler.nextInt();
                return intInput;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                inputhandler.nextLine(); // Consume the invalid input
            }
        }
    }

    public static String getStringInput(String textPromptInput) {
        System.out.println(textPromptInput);
        String stringInput = inputhandler2.nextLine();
        return stringInput;
    }

    
}
