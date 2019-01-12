package io.zipcoder.casino.utilities.containers;

import io.zipcoder.casino.utilities.Card;
import io.zipcoder.casino.utilities.enums.CardSuit;
import io.zipcoder.casino.utilities.enums.CardValue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayDeque<Card> {
    public Deck(){
        ArrayList<Card> freshDeck = new ArrayList<>();
        for (int i = 0; i < 13; i++){
            CardValue value = CardValue.values()[i];
            for (int j =0; j < 4;j++){
                Card card = new Card (value, CardSuit.values()[j]);
                freshDeck.add(card);
            }
        }
        Collections.shuffle(freshDeck);
        this.addAll(freshDeck);
    }
}
