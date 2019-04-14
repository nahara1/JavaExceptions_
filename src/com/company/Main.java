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
import java.io.*;

public class Main {

    public static void main(String[] argv) {

        Scanner scnr = new Scanner(System.in);

        inputInteger();
        inputFloat();
        inputAlpha();
        inputArray();
        inputFileName();

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

    public static void inputFileName() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a Windows file name: ");
        String input4 = scnr.nextLine();
        testFileName(input4);

    }


    // Handling exceptions


    public static void testInt(String number) {
        try {
            new Integer(number);

            //System.out.println(number + " is an integer.");
            return;
        } catch (NumberFormatException notAnInt) {
            System.out.println("Invalid input. You did not enter an integer number. Please try again. \n");


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
            System.out.println("Invalid input. You did not enter a float-pointing number (i.e. 2.7, 2.34). Please try again.\n");
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
            System.out.println("Invalid input. You did not enter an alpha character. Please try again.\n");
            inputAlpha();

        }
    }

    public static void testArray(String _input) {

        try {
            if (_input.matches("[0 -9 ]*[\\s]*[0 -9 ]")) {
                try {
                    String[] intArray = new String[3];
                    intArray = _input.split("\\s");
                    //System.out.println(intArray);
                    /*for (int i = 0; i < intArray.length; i++)
                        System.out.println(intArray[i]);
                    */

                    if ((intArray.length > 3)||(intArray.length < 3)) {
                        throw new ArrayIndexOutOfBoundsException("Invalid index.");
                    }
                    /*else {
                        System.out.println(intArray); //
                        for (int i = 0; i < intArray.length; i++)
                           System.out.println(intArray[i]);
                    }
                    */

                } catch (ArrayIndexOutOfBoundsException not3Numbers) {
                    System.out.println("You entered either less or more than 3 integers or you entered alpha characters instead. Please try again. \n");
                    inputArray();

                }
            } else {
                throw new InputMismatchException("Invalid input");
            }
        }

           
            catch (InputMismatchException notAnumber) {
            System.out.println("Invalid input. You did not enter integers separated by whitespaces. Please try again. \n");
            inputArray();
        }
    }



    public static void testFileName(String name) {
        try {
            if (name.matches("[-]*[_a-zA-Z0-9]*[-]*$")) {
                System.out.println("File name: " + name);
                name = name + ".txt";
                File file = new File(name);
                try {

                    File file_ = new File("/Users/Narrara/Desktop/" + name);
                    file_.createNewFile();

                    /* doesn't work
                    if (file.exists()) {
                        throw new FileAlreadyExistsException("exception");
                    }

                    else {
                        File file_ = new File("/Users/Narrara/Desktop/" + name);
                        //file_.createNewFile();
                    }
                } catch (FileAlreadyExistsException fileAlreadyExists) {
                    System.out.print("File name already exists. Try another one.");
                    inputFileName();
                    */

            } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else {
                throw new InputMismatchException("Invalid input");
            }

            /*
            if (fileName.matches("!@#$%^&*(),.?\":{}|<>\\s]*[a-zA-Z]*[!@#$%^&*(),.?\":{}|<>\\s]*$")) {
                throw new InputMismatchException("Invalid input");
            }
            else {
                System.out.println("File name: " + fileName);
            }
            */

            } catch (InputMismatchException invalidChars) {
                System.out.println("Invalid Name. Windows file names cannot contain special characters or whitespaces. Please try again. \n");
                inputFileName();
            }



    }
}









