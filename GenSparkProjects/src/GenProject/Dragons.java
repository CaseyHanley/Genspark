package GenProject;

import java.util.Scanner;

public class Dragons {

    public int DragonsCave(){

        //Output Story:
        System.out.println("You are in a long full of dragons. In front of you,");
        System.out.println("");
        System.out.println("you see two caves. In one, the dragon is friendly");
        System.out.println("");
        System.out.println("and will share his treasure with you/ The other dragon");
        System.out.println("");
        System.out.println("is greedy and will eat you on sight.");
        System.out.println("");
        System.out.println("which cave will you go into? "+ "\u001B (1 or 2)");
        //Spacing
        System.out.println("");
        System.out.println("");


        int answer = 0;
        Scanner scan = new Scanner(System.in);

        //Make input function
        while(answer != 1 && answer != 2){
            answer = scan.nextInt();
        }

        switch (answer){
            case 1: Eaten();break;
            case 2: Gold();
        }

        //Spacing
        System.out.println("");
        System.out.println("");





        return 0;
    }

    private void Gold() {
    }

    private void Eaten() {
        //Make if(answer == 1){}
        System.out.println("You approach the cave...");
        System.out.println();
        System.out.println("It is dark and spooky...");
        System.out.println();
        System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
        System.out.println();
        System.out.println("Gobbles you down in one bite!");
        System.out.println("");



    }

}
