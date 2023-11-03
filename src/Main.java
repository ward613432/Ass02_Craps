import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int[] rolls = new int[2];
    static int sum = 0;
    static int point = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Craps Simulator!");
        System.out.println("If the sum is 2, 3, or 12 it is called \"craps\" or \"crapping out\" and the game is over with a loss.");
        System.out.println("If the sum is 7 or 11 it is called a \"natural\" and the game is over with a win.");
        System.out.println("For all other values, the sum becomes \"the point\" and the user makes subsequent rolls until they either roll a 7, in which case they lose, or they roll the point sum in which case they win.");

        while (true) {
            // game init
            boolean gameRunning = false;
            point = 0;
            DoCrap();

            if (sum == 7 || sum == 11) {
                System.out.println("You win!");
            } else if (sum == 2 || sum == 3 || sum == 12){
                System.out.println("Sorry, you crapped out.");
            } else {
                gameRunning = true;
                point = sum;
            }

            // game loop
            while (gameRunning) {
                DoCrap(); // resets the sum

                if (sum == point) {
                    gameRunning = false;
                    System.out.println("You win!\n");
                } else if (sum == 7) {
                    gameRunning = false;
                    System.out.println("Sorry, you crapped out.\n");
                } else {
                    System.out.printf("Reroll. You must roll a %d in order to win. A roll of a 7 will result in a loss.\n", point);
                }
            }

            // continue game or end game
            System.out.println("Play again? [Y/N]");
            if (scanner.hasNextLine()) {
                String yn = scanner.nextLine();
                if (yn.equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
    }

    public static int RandRange(int min, int max) {
        return (int)(Math.random() * max) + min;
    }

    public static void DoCrap() {
        rolls[0] = RandRange(1, 6);
        rolls[1] = RandRange(1, 6);
        sum = rolls[0] + rolls[1];

        System.out.printf("Roll 1:%6d\n", rolls[0]);
        System.out.printf("Roll 2:%6d\n", rolls[1]);
        System.out.printf("Sum:%9d\n", sum);
    }
}