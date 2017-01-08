package com.exemple;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CardsPackage pack = new CardsPackage(1, true);
        Player singlePlayer = new Player();
        Player Dealer = new Player();

        singlePlayer.hitACard(pack.getNextCard());
        Dealer.hitACard(pack.getNextCard());

        singlePlayer.hitACard(pack.getNextCard());
        Dealer.hitACard(pack.getNextCard());

        System.out.println("Initial Draw");
        Dealer.printFirstPlayersHand(false);
        singlePlayer.printFirstPlayersHand(true);

        boolean playerDone = false;
        boolean dealerDone = false;
        boolean isEliminated = false; // daca playerul este eliminat pe parcurs ce extrage carti
        String drawOrNot;

        int countPrints = 2; // pentru a afisa a cata carte extrage Playerul/Dealerul


        while (!playerDone) {
            // playerul joaca
            if (!playerDone) {
                System.out.println(" Do you want to draw another card? (Y/N)");
                drawOrNot = sc.next();
                if (drawOrNot.compareTo("Y") == 0 || drawOrNot.compareTo("y") == 0) {
                    boolean an = singlePlayer.hitACard(pack.getNextCard());
                    playerDone = !an; // daca scorul este >21 , atunci am iesit
                    if (playerDone) { // daca playerul este eliminat
                        isEliminated = true;
                    }
                    singlePlayer.printActualHand(false, countPrints++);
                } else if (drawOrNot.compareTo("N") == 0 || drawOrNot.compareTo("n") == 0) {
                    playerDone = true;
                }
            }
        }
        countPrints = 1;
        System.out.print("Dealer Hidden Card Was: ");
        Dealer.showHidden();
        if (!isEliminated) {
            while (!dealerDone) {
                // dealerul joaca
                if (!dealerDone) {
                    if (Dealer.getCurrentScore() < 17) {
                        System.out.print(" Dealer hand is " + Dealer.getCurrentScore() + ", dealer draws another hand.");
                        boolean an = Dealer.hitACard(pack.getNextCard());
                        dealerDone = !an; // daca scorul este > 21 , atunci am iesit
                        Dealer.printActualHand(true, countPrints++);
                    } else { // Dealerul sta, deci s-a terminat
                        System.out.print(" Dealer hand is " + Dealer.getCurrentScore() + ", dealer stops.");
                        dealerDone = true;
                    }
                }
            }
        }else{
            System.out.print(" Dealer hand is " + Dealer.getCurrentScore() + ", dealer stops, player BUSTED.");
        }

        int pScore = singlePlayer.getCurrentScore();
        int dScore = Dealer.getCurrentScore();
        System.out.print("\n\nPlayer Hand values " + pScore + ", ");
        System.out.println("Dealer Hand values " + dScore + ".");

        if ((pScore > dScore && pScore <= 21) || dScore > 21) {
            System.out.println("Player WINS!!!");
        } else if (pScore == dScore) {
            if(pScore == 21){
                System.out.println("It's a BLACKJACK tie!!!");
            }else {
                System.out.println("It's a TIE!!!");
            }
        } else {
            System.out.println("Dealer WINS!!!");
        }

        sc.close();
    }
}
