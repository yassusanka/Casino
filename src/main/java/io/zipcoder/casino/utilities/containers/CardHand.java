package io.zipcoder.casino.utilities.containers;

import io.zipcoder.casino.utilities.Card;

import java.util.ArrayList;

public class CardHand extends ArrayList<Card> {

    int numberOfCards = this.size();
//    private java.util.ArrayList<Card> cardHand;
//    public CardHand(int numberOfCards) {
//        this.numberOfCards = numberOfCards;
//    }
//
    public CardHand() {

    }
//
//    public void addCard(Card card) {
//        add(card);
//    }
//    public void removeCard(Card card) {
//        remove(card);
//    }

    public String display() {
        String result = "";
        int i = 0;
        for (Card each : this) {
            if (each == this.get(this.size()-1)) {
                result += "and " + each.getCardValue() + " of " + each.getSuit().getCardGraphic();
            } else {
                result += each.getCardValue() + " of " + each.getSuit().getCardGraphic() + ", ";
            }
            i++;
        }
//        Console.println(result);
        return result;
    }

}