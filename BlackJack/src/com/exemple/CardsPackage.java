package com.exemple;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Alex Nutu on 1/7/2017.
 */
public class CardsPackage {

    private int numberOfCards; // numarul de carti din pachet, vom avea 52 de carti
    private ArrayList<Card> cards; // vectorul de carti

    public CardsPackage() { // apelam constructorul pentru 1 singur pachet si fara sa il amestecam
        this(1, false);
    }

    public CardsPackage(int numberOfPairs, boolean needShuffle) {
        // numberOfPairs este numarul de perechi separate de carti
        numberOfCards = numberOfPairs * 52;
        cards = new ArrayList<>(numberOfCards);
        ArrayList<String> type = new ArrayList<>();
        type.add("Clubs");
        type.add("Diamonds");
        type.add("Hearts");
        type.add("Spades");

        int iCard = 0; //numarul cartii

        for (int i = 0; i < numberOfPairs; i++) {

            for (int t = 0; t < 4; t++) {

                for (int n = 1; n <= 13; n++) {
                    cards.add(iCard, new Card(n, type.get(t)));
                    iCard++;
                }
            }
        }
        if (needShuffle) { // le amestecam doar daca este necesar
            shuffleCards();
        }
    }

    public Card getNextCard() {
        Card first = cards.get(0);// prima noastra carte din pachet
        // cum vom elimina o carte din, vom muta cartile cu 1 pozitie la dreapta
        for (int i = 1; i < numberOfCards; i++) {
            cards.set(i - 1, cards.get(i));
        }
        cards.remove(numberOfCards - 1);
        numberOfCards--;
        return first;
    }

    public void printPair(int howMany) {
        for (int i = 0; i < howMany; i++) {
            System.out.println(i + 1 + " " + cards.get(i).toString());
        }
    }


    public void shuffleCards() {
        Random random = new Random();
        Card tempCard;
        for (int i = 0; i < numberOfCards; i++) {
            int j = random.nextInt(numberOfCards); // ne genereaza un numar random intre 0 si numarul de carti-1
            tempCard = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, tempCard);
        }
    }


}
