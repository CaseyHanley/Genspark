package GenProject;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public void Game(){

        String Username = "";
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your name?\n\n");

        Username = scan.nextLine();

        System.out.printf("Well, %s, I am thinking of a number between 1 and 20.\nTake a Guess.", Username);

        guess(Username);






    }

    private void guess(String Username) {

        int guessedNum = 0;
        Random rand = new Random();
        guessedNum = rand.nextInt(1,20);

        int turn = 0;
        int guessing = 0;
        Scanner scanning = new Scanner(System.in);

        do {
            System.out.printf("Take a guess");

            guessing = scanning.nextInt();


            if (guessing == guessedNum){
                System.out.printf("Good job, %s! you guessed my number in %i guesses!", Username, (turn+1));
            System.out.println();
            System.out.println("Would you like to play again? (y or n)");
            String yesOrNo = scanning.next();

            if (yesOrNo.equals("y")){guess(Username);}else return;

            }

            if (guessing < guessedNum){System.out.println("Your guess is too low."); }
            if (guessing > guessedNum){System.out.println("Your guess is too high."); }


            turn++;

            if (turn == 6){
                System.out.println("Too many guesses.");
                System.out.println("Would you like to play again? (y or n)");
                String yesOrNo = scanning.next();

                if (yesOrNo.equals("y")){guess(Username);}else return;
            }


        }while(guessing != guessedNum && turn <6);






    }


}
