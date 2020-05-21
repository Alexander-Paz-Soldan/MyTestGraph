package com.example.mytestgraph.model;

/**
 * Card representeert een Kaart in een talennetwerk.
 */
public class Card {

    public long uid;

    public String getFamiliarWord() {
        return familiarWord;
    }

    public void setFamiliarWord(String familiarWord) {
        this.familiarWord = familiarWord;
    }

    public String getForeignWord() {
        return foreignWord;
    }

    public void setForeignWord(String foreignWord) {
        this.foreignWord = foreignWord;
    }

    private String familiarWord;
    private String foreignWord;
    public long x;
    public long y;



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
