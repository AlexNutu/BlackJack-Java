package com.exemple;

import java.util.ArrayList;

/**
 * Created by Alex Nutu on 1/7/2017.
 */

public class Card {

    private int cardNumber; // numarul cartii
    private String cardType; // tipul cartii

    public Card(int number, String type) {

        if (number < 1 || number > 13) {// verificam ca este un numar de carte valid
            System.out.println("Error: Incorrect Card!");
            System.exit(1);
        } else {
            cardNumber = number;
            cardType = type;
        }
    }

    public int getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        String numberOfCard;
        ArrayList<String> s = new ArrayList<>(14);
        s.add("A");
        s.add("2");
        s.add("3");
        s.add("4");
        s.add("5");
        s.add("6");
        s.add("7");
        s.add("8");
        s.add("9");
        s.add("10");
        s.add("J");
        s.add("Q");
        s.add("K");
        numberOfCard = s.get(cardNumber - 1); // deoarece numerotarea cartilor este de la 1 si nu de la 0;

        return numberOfCard + " " + cardType.toString(); // cardType este integer, dar il putem transforma in String

    }
}
