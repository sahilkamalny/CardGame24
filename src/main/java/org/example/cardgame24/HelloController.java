package org.example.cardgame24;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloController {
    // GUI elements
    @FXML
    private HBox cardContainer;
    @FXML
    private TextField expressionField;
    @FXML
    private Label resultDialog;
    @FXML
    private Button verifyButton;
    @FXML
    private Button refreshButton;

    private List<Card> cards;

    public void initialize() {
        newHand(); // generates a new hand at the start of the game
    }

    private void newHand() {
        cards = randomHand(); // generates a random hand
        cardContainer.getChildren().clear(); // clears previous cards on display

        for (Card card : cards) { // loops through each of four cards and assigns their value
            String cardValue;
            switch (card.getValue()) {
                case 1 -> cardValue = "ace";
                case 11 -> cardValue = "jack";
                case 12 -> cardValue = "queen";
                case 13 -> cardValue = "king";
                default -> cardValue = String.valueOf(card.getValue());
            }

            String fileName = cardValue + "_of_" + card.getSuit().toLowerCase() + ".png"; // naming convention for card png images
            InputStream imgStream = getClass().getResourceAsStream("/org/example/cardgame24/images/" + fileName); // loads images

            if (imgStream == null) {
                System.out.println("ERROR: Could not load image: " + fileName); // debug line for testing when images don't load
            } else {
                // displays the cards
                ImageView cardImg = new ImageView(new Image(imgStream));
                cardImg.setFitWidth(120);
                cardImg.setFitHeight(160);
                cardContainer.getChildren().add(cardImg);
            }
        }

    }

    @FXML
    private void onVerifyClick() {
        String input = expressionField.getText().replaceAll("\\s", ""); // removes whitespace from expression
        if (Validator.isValid(input, cards)) {
            resultDialog.setText("Correct!"); // display if user is correct
        } else {
            resultDialog.setText("Wrong!"); // display if user is wrong
        }
    }

    @FXML
    private void onRefreshClick() {
        newHand(); // generates a new hand
        expressionField.clear(); // clears the expression field
        resultDialog.setText(""); // clears the result dialog label
    }

    private List<Card> randomHand() {
        List<Card> cardDeck = new ArrayList<>(); // deck to hold all 52 cards
        String suits[] = {"Spades", "Clubs", "Hearts", "Diamonds"}; // names of all four suits
        for (String suit : suits) { // first loop to go through each suit
            for (int i = 0; i <= 12; i++) { // second loop to go through each value
                cardDeck.add(new Card(suit, i + 1)); // add each available card to the deck
            }
        }
        Collections.shuffle(cardDeck); // shuffles the deck
        return cardDeck.subList(0, 4); // returns the first four cards from the deck
    }
}