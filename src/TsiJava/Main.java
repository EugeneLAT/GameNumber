package TsiJava;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static File leaderBoardFile = new File("Leader-Board.txt");

    public static void main(String[] args) {

        ArrayList<GameResult> leaderboard = new ArrayList<>();
        loadLeaderBoard(leaderboard);
        try {

            String answer;

            do {
                String menu;
                String name;

                System.out.println("Hello!");
                System.out.println("What is your name?");
                System.out.print("My name is: ");
                name = scanner.next();


                System.out.println("Menu:");
                System.out.println("1. New Game!");
                System.out.println("2. Check Leader-Board!");
                System.out.println("3. Exit!");
                System.out.print("Your choose: ");
                menu = askAnswerMenu();
                switch (menu) {
                    case "1":
                        GameResult r = doGame(name);
                        if (r != null) {
                            leaderboard.add(r);
                        }
                        break;
                    case "2":
                        String menuCase2;
                        System.out.println("1. All Players!");
                        System.out.println("2. TOP 5!");
                        System.out.println("3. Back!");
                        System.out.println("4. Exit!");
                        System.out.print("Your choose: ");
                        menuCase2 = askAnswerMenuCase2();
                        switch (menuCase2) {
                            case "1":
                                printLeaderBoard(leaderboard);
                                break;
                            case "2":
                                printLeaderBoardTopFive(leaderboard);
                                break;
                            case "3":
                                //!!!!!///!!!!///!!!!///!!!!///!!!!///
                                break;
                            case "4":
                                return;
                        }
                        break;
                    case "3":
                        return;
                }

                System.out.println("Do you want restart? ( Yes / No )");
                System.out.print("Answer: ");
                answer = askAnswer();

            } while (answer.equals("Yes"));

        } catch (NoSuchElementException i) {
            System.out.println("Goodbye!");
        }

        System.out.println("Leaders Board!");
        leaderboard.sort(Comparator
                .<GameResult>comparingInt(gameResult -> gameResult.attempts)
                .<GameResult>thenComparingDouble(gameResult -> gameResult.playTime));
        saveLeaderBoard(leaderboard);

        System.out.println("Goodbye!");
    }

    private static GameResult doGame(String userName) {
        int RNum = random.nextInt(100) + 1;
        int Attempts = 10;
        long startTime = System.currentTimeMillis();


        System.out.println(userName + "!");
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
                result.playTime = (finishTime - startTime) / 1000.0;
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

    private static String askAnswerBoard() {
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

    private static String askAnswerMenu() {
        String word = scanner.next();
        if (word.equals("1") || word.equals("2") || word.equals("3")) {
            return word;
        } else {
            do {
                System.out.println("I don't understand!");
                System.out.println("Please write: 1 or 2 or 3!");
                System.out.println("1. New Game!");
                System.out.println("2. Check Leader-Board!");
                System.out.println("3. Exit!");
                System.out.print("Again: ");
                word = scanner.next();
            } while (!(word.equals("1") || word.equals("2") || word.equals("3")));
        }
        return word;
    }

    private static String askAnswerMenuCase2() {
        String word = scanner.next();
        if (word.equals("1") || word.equals("2") || word.equals("3") || word.equals("4")) {
            return word;
        } else {
            do {
                System.out.println("I don't understand!");
                System.out.println("Please write: 1 or 2 or 3 or 4!");
                System.out.println("1. All Players!");
                System.out.println("2. TOP 5!");
                System.out.println("3. Back!");
                System.out.println("4. Exit!");
                System.out.print("Again: ");
                word = scanner.next();
            } while (!(word.equals("1") || word.equals("2") || word.equals("3")));
        }
        return word;
    }

    private static void printLeaderBoard(ArrayList<GameResult> leaderboard) {
        for (GameResult r : leaderboard) {
            System.out.println("Name: " + r.userName + "\t Attempts: " + r.attempts + "\t Time: " + r.playTime);
        }

    }

    private static void printLeaderBoardTopFive(ArrayList<GameResult> leaderboard) {

        for (GameResult r : leaderboard) {
            for (int i = 1; i <= 5;i++) {
                System.out.println("Name: " + r.userName + "\t Attempts: " + r.attempts + "\t Time: " + r.playTime);
            }
        }

    }

    private static void saveLeaderBoard(ArrayList<GameResult> leaderboard) {
        try (PrintWriter out = new PrintWriter(leaderBoardFile)) {
            for (GameResult r : leaderboard) {
                out.println(r.userName + "\t" + r.attempts + "\t" + r.playTime);
            }
        } catch (IOException e) {
            System.out.println("Something wrong!");
        }

    }

    private static void loadLeaderBoard(ArrayList<GameResult> leaderboard) {
        if (!leaderBoardFile.exists()) {
            return;
        }
        try (Scanner in = new Scanner(leaderBoardFile)) {

            while (in.hasNext()) {
                GameResult r = new GameResult();
                r.userName = in.next();
                r.attempts = in.nextInt();
                r.playTime = Double.parseDouble(in.next());
                leaderboard.add(r);
            }

        } catch (IOException e) {
            System.out.println("Something wrong while reading file!");
        }
    }
}

