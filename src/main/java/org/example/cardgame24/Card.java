package org.example.cardgame24;

public class Card {
    private final String suit; // holds the card's suit
    private final int value; // holds the card's value

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
