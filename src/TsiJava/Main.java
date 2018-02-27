package TsiJava;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String Answer;

        do {
            int RNum = random.nextInt(100) + 1;
            int Attempts = 10;
            System.out.println("I think of number from 1 to 100. You have " + Attempts + " attempts!");
            System.out.println("Good luck!");
            //System.out.println(RNum);


            for (int i = 0; i < Attempts; i++) {

                System.out.println("Its your " + (i + 1) + " try!");
                System.out.print("Please add your number: ");

                int UserNum = scanner.nextInt();

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

            System.out.println("Do you want to play again? ( Y / N )");
            System.out.print("Answer: ");
            Answer = scanner.next();

            if (Answer.equals("N")){
                System.out.println("Goodbye!");
                return;
            }


        } while (Answer.equals("Y"));


    }
}

