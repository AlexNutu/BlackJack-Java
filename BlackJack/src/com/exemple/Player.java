package com.exemple;

import java.util.ArrayList;

/**
 * Created by Alex Nutu on 1/7/2017.
 */
public class Player {


    private ArrayList<Card> pHand = new ArrayList<>();
    private int numberOfCards;


    public Player() {
        makeEmptyHand();
    }

    public void makeEmptyHand() {
        for (int i = 0; i < pHand.size(); i++) {
            pHand.remove(i);
        }
        numberOfCards = 0;
    }

    public boolean hitACard(Card theCard) {
        if (numberOfCards == 7) {// presupunem ca numarul maxim de carti pe care le poate lua jucatorul este 7
            System.out.println("Maximum number of cards in one hand exceeded !");
            System.exit(1);
        }
        pHand.add(numberOfCards, theCard);
        numberOfCards++;

        if (getCurrentScore() <= 21) {
            return true;
        } else {
            return false;
        }
    }

    public int getCurrentScore() {
        int score = 0;
        int numberOfTheCard;
        int nrAce = 0;
        for (int i = 0; i < numberOfCards; i++) {
            numberOfTheCard = pHand.get(i).getCardNumber();
            if (numberOfTheCard == 1) { // avem un 'As'
                score += 11;
                nrAce++;
            } else if (numberOfTheCard > 10) {
                score = score + 10;
            } else {
                score = score + numberOfTheCard;
            }
        }

        while (score > 21 && nrAce > 0) { // pentru a nu fi dati afara, transformam 'asii' din 11 in 1
            score = score - 10;
            nrAce--;
        }

        return score;
    }

    public void printFirstPlayersHand(boolean secondCard) {
        if (!secondCard) {
            System.out.print("\nDealer Draw: ");
        } else {
            System.out.print("Player Draw(" + 1 + "): ");
        }
        for (int i = 0; i < numberOfCards; i++) {
            if (i == 1 && !secondCard) {
                System.out.println(" Hidden");
            } else {
                System.out.print(pHand.get(i));
                if (i == 0) System.out.print(", ");
                if (i == 1 && secondCard) System.out.print(".");
            }
        }
    }

    public void printActualHand(boolean whichPlayer, int poz) {
        if (whichPlayer == true) { // afisam cartea dealerului
            System.out.print("\nDealer Draw(" + poz + "): " + pHand.get(numberOfCards - 1));
        } else {
            System.out.println("Player Draw(" + poz + "): " + pHand.get(numberOfCards - 1));
        }
    }

    public void showHidden() {
        System.out.print(pHand.get(numberOfCards - 1) + ".");
    }

}
