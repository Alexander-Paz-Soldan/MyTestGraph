package com.example.mytestgraph.model;

import java.util.HashMap;
import java.util.Map;

public class WordMap {

        public long uid;
        public String owner;
        public String name;
        public String description;
        public Map<Long, Card> cards;
        public Map<Long, Arrow> arrows;
        public long nextCardUid = 0;
        public long nextArrowUid = 0;

        public WordMap() {
            cards = new HashMap<Long, Card>();
            arrows = new HashMap<Long, Arrow>();
        }

        public WordMap(long uid, String owner, String name, String description) {
            this.uid = uid;
            this.owner = owner;
            this.name = name;
            this.description = description;
            cards = new HashMap<Long, Card>();
            arrows = new HashMap<Long, Arrow>();
        }

    /**
     * Card is a Node
     * @return a Card representing a Node in the network
     */
    public Card createCard() {
            long uid = nextCardUid;
            nextCardUid++;

            Card newCard = new Card();
            newCard.uid = uid;
            cards.put(uid, newCard);

            return newCard;
        }

        // create connection
        public Arrow createArrow(Card from, Card to) {

            long uid = nextArrowUid;
            nextArrowUid++;

            Arrow newArrow = new Arrow();
            newArrow.uid = uid;
            arrows.put(uid, newArrow);

            return newArrow;
        }

    /**
     * remove nodes from the netwoek
     * @param card the node to remove
     */
    public void removeCard(Card card) {

        cards.remove(card.uid);

        }

        // removing connections from the network
        public void removeArrow(Arrow arrow) {
            arrows.remove(arrow.uid);
        }

        // make json to send the map to the Database
        public String toJSON() {
            return "";
        };

        // load from a map
        static public WordMap fromJSON(String json) {
            WordMap wordMap = new WordMap();
            // TODO
            return wordMap;
        }

}
