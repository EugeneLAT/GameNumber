package TsiJava;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {

            Random random = new Random();

            String Answer;
            do {
                int RNum = random.nextInt(100) + 1;
                int Attempts = 10;
                System.out.println("I think of number from 1 to 100. You have " + Attempts + " attempts!");
                System.out.println("Good luck!");
                System.out.println(RNum);

                for (int i = 0; i < Attempts; i++) {

                    System.out.println("Its your " + (i + 1) + " try!");
                    System.out.print("Please add your number: ");

                    int UserNum = askNumber();

                    if (UserNum > RNum) {
                        System.out.println("Your number " + UserNum + " are bigger than my!");
                    } else if (UserNum < RNum) {
                        System.out.println("Your number " + UserNum + " are smaller than my!");
                    } else if (UserNum == RNum) {
                        System.out.println("Congratulate!");
                        break;
                    }
                    if (i == Attempts - 1) {
                        System.out.println("Sorry! You lost all " + Attempts + " attempts!");
                    }
                }

                System.out.println("Do you want to play again? ( Yes / No )");
                System.out.print("Answer: ");
                Answer = answer();

                if (Answer.equals("No")) {
                    System.out.println("Goodbye!");
                    return;
                }


            } while (Answer.equals("Yes"));

        }catch (NoSuchElementException i){
            System.out.println("Goodbye!");
            return;
        }
    }
//    static int askNumber() {
//        int number;
//        do {
//            number = scanner.nextInt();
//            if (number > 100 || number < 1) {
//                System.out.println("WRONG! Try again: from 1 to 100!");
//                System.out.print("Please add your number: ");
//            }
//        } while (number > 100 || number < 1);
//
//        return number;
//    }

        static int askNumber () {
            for (; ; ) {
                try {
                    int number = scanner.nextInt();
                    if (number <= 100 && number >= 1) {
                        return number;
                    }
                } catch (InputMismatchException i) {
                    scanner.next();
                    System.out.println("Oops!");

                }

                System.out.println("WRONG! Try again: from 1 to 100!");
                System.out.print("Please add your number: ");

            }


        }

        static String answer () {
            String word = scanner.next();

            if (word.equals("Yes") || word.equals("No")) {
                return word;
            } else {
                do {
                    System.out.println("I don't understand!");
                    System.out.print("Please write: Yes or No!");
                } while (word.equals("Yes") || word.equals("No"));
            }
            return word;
        }
    }

