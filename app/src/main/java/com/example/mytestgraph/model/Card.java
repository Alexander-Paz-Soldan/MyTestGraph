package com.example.mytestgraph.model;

/**
 * Card representeert een Kaart in een talennetwerk.
 */
public class Card {

    public long uid;
    public String familiarWord;
    public String foreignWord;
    long x;
    long y;


    public String toJSON() {
        // TODO
        return "";
    };

    public Card fromJSON(String json) {
        Card card = new Card();
        // TODO
        return card;
    }

}
