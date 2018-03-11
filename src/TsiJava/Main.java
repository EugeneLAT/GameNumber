package TsiJava;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        ArrayList<GameResult> leaderboard = new ArrayList<>();

        try {

            String answer;

            do {

                String name;

                System.out.println("Hello!");
                System.out.println("What is your name?");
                System.out.print("My name is: ");
                name = scanner.next();


                GameResult r = doGame(name);
                if (r != null) {
                    leaderboard.add(r);
                }


                System.out.println("Do you want to play again? ( Yes / No )");
                System.out.print("Answer: ");
                answer = askAnswer();

            } while (answer.equals("Yes"));

        } catch (NoSuchElementException i) {
            System.out.println("Goodbye!");
        }

        System.out.println("Leaders Board!");

        for (GameResult r : leaderboard) {
            System.out.println("Name: " + r.userName + "\t Attempts: " + r.attempts + "\t Time: " + r.playTime);
        }
        System.out.println("Goodbye!");
    }

    private static GameResult doGame(String userName) {
        int RNum = random.nextInt(100) + 1;
        int Attempts = 10;
        long startTime = System.currentTimeMillis();


        System.out.println("Hello " + userName + "!");
        System.out.println("I think of number from 1 to 100. You have " + Attempts + " attempts!");
        System.out.println("Good luck!");
        System.out.println(RNum);


        GameResult result = new GameResult();
        result.userName = userName;



        for (int i = 1; i <= Attempts; i++) {

            System.out.println("Its your " + i + " try!");
            System.out.print("Please add your number: ");

            int UserNum = askNumber();

            if (UserNum > RNum) {
                System.out.println("Your number " + UserNum + " are bigger than my!");
            } else if (UserNum < RNum) {
                System.out.println("Your number " + UserNum + " are smaller than my!");
            } else if (UserNum == RNum) {
                System.out.println("Congratulate!");
                result.attempts = i;
                long finishTime = System.currentTimeMillis();
                result.playTime = (finishTime - startTime)/1000;
                return result;
            }

        }
        System.out.println("Sorry! You lost all " + Attempts + " attempts!");
        return null;
    }

    static int askNumber() {
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

    static String askAnswer() {
        String word = scanner.next();
        if (word.equals("Yes") || word.equals("No")) {
            return word;
        } else {
            do {
                System.out.println("I don't understand!");
                System.out.println("Please write: Yes or No!");
                System.out.print("Again: ");
                word = scanner.next();
            } while (!(word.equals("Yes") || word.equals("No")));
        }
        return word;
    }
}

