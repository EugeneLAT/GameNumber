package TsiJava;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in); // System.in считывает что вел пользователь

        int RNum = random.nextInt(100) + 1;
        System.out.println("I think of number from 1 to 100. Try to guess it.");
        //System.out.println(RNum);


        for (int i = 0; true ; i++) {

            System.out.println("Its your " + (i + 1) + " try!");
            System.out.print("Please add your number:");

            int UserNum = scanner.nextInt();

            if (UserNum > RNum) {
                System.out.println("Your number " + UserNum + " are bigger than my!");
            } else if (UserNum < RNum) {
                System.out.println("Your number " + UserNum + " are smaller than my!");
            } else {
                System.out.println("Congratulate!");
                break;
            }

        }
    }
}
