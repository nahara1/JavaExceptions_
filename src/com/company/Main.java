/*

Project: Lab 13
Purpose Details: Accept user input and handle exceptions in Java
Course: IST 242 - 001
Author: Narrara Melodonascimentodemou
Date Developed: 4/13/19
Last Date Changed: 4/13/19
Rev:

 */




package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

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
        System.out.println("Enter a float-pointing number: ");
        String input1 = scnr.nextLine();
        testFloat(input1);
    }

    public static void inputAlpha() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a letter character: ");
        String input2 = scnr.nextLine();
        testAlpha(input2);
    }

    public static void inputArray() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter 3 integer numbers separated by a whitespace: ");
        String input2 = scnr.nextLine();
        String intArray[] = new String[3];
        intArray = input2.split(" ");
        System.out.println(intArray);
    }


    // Handling exceptions


    public static void testInt(String number) {
        try {
            new Integer(number);

            System.out.println(number + " is an integer.");
            return;
        } catch (NumberFormatException notAnInt) {
            System.out.println("You did not enter an integer number. Try again. \n");


           /* try {

                new Double(number);
                System.out.println(number + " is a floating-point number.");
                return;
            } catch (NumberFormatException notAFloat) {
                System.out.println(number + " is not a number at all.");
            }
            */
            inputInteger();
        }

    }

    public static void testFloat(String number) {
        try {

            // it does not catch an integer input
            new Float(number);
            Float.parseFloat(number);

            System.out.println(number + " is a float-pointing number.");
            return;
        } catch (NumberFormatException notAFloat) {
            System.out.println("You did not enter a float-pointing number (e.g. 7.0). Try again. \n");
            try {
                new Integer(number);
                System.out.println(number + " is an integer number.");
                return;
            } catch (NumberFormatException notAfloat) {
                System.out.println(number + " is not a number at all.");
            }
            inputFloat();

        }
    }

    public static void testAlpha(String alphaCharacter) {
        try {
            //new String(alphaCharacter);
            // not working - don't know
            if (alphaCharacter.matches("/[a-zA-Z]+/")) {
                System.out.println(alphaCharacter + " is an alpha character.");
                //return;
                //}
            }
            else {

                throw new InputMismatchException("not an alpha character");
            }

        } catch (InputMismatchException notAnAlpha) {
           System.out.println("You did not enter an alpha character. Please try again.");


            }
        }




    }



