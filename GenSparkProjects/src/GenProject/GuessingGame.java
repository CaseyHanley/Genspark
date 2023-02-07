package GenProject;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {


    public String Username = "";
    public int guessedNum = 0;

    public int turn = 0;
    public int guessTheNumber = 0;

    public void Game(){


        Scanner scan = new Scanner(System.in);

        System.out.println("What is your name?\n\n");

        Username = scan.nextLine();

        System.out.printf("Well, %s, I am thinking of a number between 1 and 20.\nTake a Guess.", Username);

        guess(Username);
    }

    public void guess(String Username) {

        guessedNum = randNumGen();


        Scanner scanning = new Scanner(System.in);

        do {
            System.out.print("Take a guess");

            guessTheNumber = scanning.nextInt();


            if (guessTheNumber == guessedNum){
                System.out.printf("Good job, %s! you guessed my number in %d guesses!", Username, (turn+1));
            System.out.println();
            System.out.println("Would you like to play again? (y or n)");
            String yesOrNo = scanning.next();

            if (yesOrNo.equals("y")){guess(Username);}else return;

            }

            if (guessTheNumber < guessedNum){System.out.println("Your guess is too low."); }
            if (guessTheNumber > guessedNum){System.out.println("Your guess is too high."); }


            turn++;

            if (turn == 6){
                System.out.println("Too many guesses.");
                System.out.println("Would you like to play again? (y or n)");
                String yesOrNo = scanning.next();

                if (yesOrNo.equals("y")){guess(Username);}else return;
            }


        }while(guessTheNumber != guessedNum && turn <6);






    }

    public int randNumGen() {
        Random rand = new Random();

        return rand.nextInt(1, 20);
    }


}
