package GenProject;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HangMan {
    int triesRemaning = 4;
    ArrayList<Character> wrongCharsGuessed = new ArrayList<>();
    ArrayList<Character> correctCharsGuessed =  new ArrayList<>();
    Boolean play = true;
    String wordToGuess;
    String guessedLetter;
    Scanner answeringMachine = new Scanner(System.in);


    public void mainGame(){


        wordToGuess = getRandomWord();
        correctCharsGuessed = createBlanks(wordToGuess);

try {


    while (play) {

        do {
            System.out.println("Guess a single letter");
            guessedLetter = answeringMachine.nextLine();

            System.out.println("Letter guessed is: " + guessedLetter);
            int lengthCheck = wrongCharsGuessed.size();
            //check if the letter is A: Actually a Char, B: is in the word to guess
            checkLetter(wrongCharsGuessed, correctCharsGuessed, wordToGuess, guessedLetter, triesRemaning);

            if(lengthCheck < wrongCharsGuessed.size()){triesRemaning--;}

            System.out.println("Checked letter: " + guessedLetter);
        }while(guessedLetter.length() != 1);
//|| !Pattern.matches("[a-zA-Z]", guessedLetter)

        draw(triesRemaning,wrongCharsGuessed,correctCharsGuessed);

        if (triesRemaning == 0) {
            play = getPlay(play, answeringMachine);

            //if you want to play again reset board else break from loop
            if (play){
                triesRemaning = 4;
                wordToGuess = "";
                correctCharsGuessed = new ArrayList<>();
                wrongCharsGuessed = new ArrayList<>();
                wordToGuess = getRandomWord();
                correctCharsGuessed = createBlanks(wordToGuess);
            }else {play = false;}
        }




    }


}catch (Exception e){

    System.out.println("Error in Play");
    System.out.println(e);
}


    }

    private static Boolean getPlay(Boolean play, Scanner answeringMachine) {
        String guessedLetter;
        do {
            System.out.println();
            System.out.print("Would you like to play again? y/n");
            guessedLetter = answeringMachine.nextLine();
            if (guessedLetter.equals("n")){
                play = false;}

        }while(guessedLetter != "y" || guessedLetter != "n");
        return play;
    }

    private ArrayList<Character> createBlanks(String wordToGuess) {
        ArrayList<Character> blanks = new ArrayList<>();

        for (int i = 0; i < wordToGuess.length(); i++){
            blanks.add('_');


        }

        return blanks;
    }

    private static void checkLetter(ArrayList<Character> wrongCharsGuessed, ArrayList<Character> correctCharsGuessed, String wordToGuess, String guessedLetter, int triesRemaning) {

        try {
            if (guessedLetter.length() != 1 || !Pattern.matches("[a-zA-Z]", guessedLetter)) {
                System.out.printf("It needs to be a single letter. Try again.");
            } else {

                if (wordToGuess.contains(guessedLetter)) {

                    for (int i = 0; i < wordToGuess.length(); i++){
                        Character num = wordToGuess.charAt(i);

                        if (num.equals(guessedLetter.charAt(0))){

                            correctCharsGuessed.remove(i);
                            correctCharsGuessed.add(i,guessedLetter.charAt(0));

                        }

                    }

                }else{


//                    correctCharsGuessed.add(guessedLetter.charAt(0));
//                    System.out.printf("correctly guessed: " + correctCharsGuessed);



                    wrongCharsGuessed.add(guessedLetter.charAt(0));
                    System.out.println("Wrongly guessed: " + wrongCharsGuessed);
                    System.out.println("Tries remaining: " + (triesRemaning-1));


                }

            }
            System.out.printf("completed char checking");
        }catch (Exception e){
            System.out.println("Error in checking: " + e);
        }
    }

    public void draw(int triesRemainging, ArrayList<Character> wrongCharsGuessed, ArrayList<Character> correctCharsGuessed){

try {
    Scanner drawHangman = new Scanner(Path.of("GenSparkProjects/src/resources/hangman.txt"));
    ArrayList<String> grabHangman = new ArrayList<>();

    while (drawHangman.hasNext()) {
        grabHangman.add(drawHangman.nextLine());
    }

    System.out.println(grabHangman.get(0));
    System.out.println(grabHangman.get(1));
    for (int i = 0; i < grabHangman.get(2).length(); i++) {
        if (i < 4) {
            System.out.print(grabHangman.get(2).charAt(i));
        }else
        if (triesRemainging < 4){System.out.print(grabHangman.get(2).charAt(i));}

    }
    System.out.println("");
    for (int i = 0; i < grabHangman.get(3).length(); i++) {
        if (i < 4) {
            System.out.print(grabHangman.get(3).charAt(i));
        }else
        if (triesRemainging < 3){System.out.print(grabHangman.get(3).charAt(i));}
    }
    System.out.println();
    for (int i = 0; i < grabHangman.get(4).length(); i++) {
        if (i < 4) {
            System.out.print(grabHangman.get(4).charAt(i));
        }else
        if (triesRemainging < 2){System.out.print(grabHangman.get(4).charAt(i));}
    }
    System.out.println();
    for (int i = 0; i < grabHangman.get(5).length(); i++) {
        if (i < 4) {
            System.out.print(grabHangman.get(5).charAt(i));
        }else
        if (triesRemainging < 1){System.out.print(grabHangman.get(2).charAt(i));}
    }
    System.out.println();
    for (int i = 0; i < grabHangman.get(6).length(); i++) {
        if (i < 4) {
            System.out.print(grabHangman.get(6).charAt(i));
        }
    }
    System.out.println();
    System.out.printf(grabHangman.get(7));


    System.out.println();

    System.out.println("Word: " + correctCharsGuessed);
    System.out.println();

    System.out.printf("Incorrect guesses: ");
if (!wrongCharsGuessed.isEmpty()) {
    System.out.println(wrongCharsGuessed);
}
    System.out.println();




    if (triesRemainging == 0){
        System.out.printf("You Lose! Try Again!");
    }


}catch (Exception e){
    System.out.println("error in Draw");
    System.out.println(e);
}
    }

    public String getRandomWord() {
        String wordToGuess = "null";
        Random random = new Random();
        int getElement = 0;
        ArrayList<String> words = new ArrayList<>();
        try {
            Scanner getWords = new Scanner(Path.of("GenSparkProjects/src/resources/words.txt"));
            while (getWords.hasNext()) {
                words.add(getWords.nextLine());
            }


            getElement = random.nextInt(0, words.size() - 1);


            //System.out.println("New word = " + words.get(getElement));

            return words.get(getElement);
        }catch (Exception e){
            System.out.println("Error in Word generator: " + e);
        };
        return "null";
    }
}
