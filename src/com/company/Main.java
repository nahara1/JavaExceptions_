/*

Project: Lab 13
Purpose Details: Accept user input and handle exceptions in Java
Course: IST 242 - 001
Author: Narrara Melodonascimentodemou
Date Developed: 4/13/19
Last Date Changed: 4/14/19
Rev: 1

 */

package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] argv) {

        Scanner scnr = new Scanner(System.in);

        inputInteger();
        inputFloat();
        inputAlpha();
        inputArray();

    }

    // methods asking for  user input
    public static void inputInteger() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        String input = scnr.nextLine();
        testInt(input);
    }

    public static void inputFloat() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a float-pointing number (i.e. 2.7): ");
        String input1 = scnr.nextLine();
        testFloat(input1);
    }

    public static void inputAlpha() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input2 = scnr.nextLine();
        testAlpha(input2);
    }

    public static void inputArray() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter 3 integer numbers separated by a whitespace: ");
        String input3 = scnr.nextLine();
        testArray(input3);

    }


    // Handling exceptions


    public static void testInt(String number) {
        try {
            new Integer(number);

            System.out.println(number + " is an integer.");
            return;
        } catch (NumberFormatException notAnInt) {
            System.out.println("Invalid input. You did not enter an integer number. Try again. \n");


            inputInteger();
        }


     }

    public static void testFloat(String number) {
        try {

            // regular expression to get only decimal numbers
            if (number.matches("\\d+\\.\\d*$")) {
                return;
            }
            else  {
                throw new NumberFormatException("not float");
            }


        } catch (NumberFormatException notAfloat) {
            System.out.println("Invalid input. You did not enter a float-pointing number. Please try again.");
            inputFloat();

        }
    }


    public static void testAlpha(String alphaCharacter) {
        try {

            if (alphaCharacter.matches("^[a-zA-Z]*$")) {
                return;
            }
            else  {
                throw new InputMismatchException("not alpha");
            }


        } catch (InputMismatchException notAnAlpha) {
            System.out.println("Invalid input. You did not enter an alpha character. Please try again.");
            inputAlpha();

        }
    }

    public static void testArray(String _input) {
        try {
            String[] intArray = new String[3];
            intArray = _input.split("\\s");
            //System.out.println(intArray);
            for (int i = 0; i < intArray.length; i++)
                System.out.println(intArray[i]);

            if (intArray.length > 3) {
                throw new ArrayIndexOutOfBoundsException("Invalid input. More than 3 numbers were entered");
            }
            else {
                System.out.println(intArray);
            }

        } catch (ArrayIndexOutOfBoundsException not3Numbers) {
            System.out.println("You entered more than 4 integers or alpha characters. Please try again. \n");
            inputArray();

        }

    }
}









