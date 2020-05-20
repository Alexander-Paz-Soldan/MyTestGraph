package com.example.mytestgraph.model;

import java.util.HashMap;
import java.util.Map;

public class WordMap {

        public String uid;
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

        public WordMap(String uid, String owner, String name, String description) {
            this.uid = uid;
            this.owner = owner;
            this.name = name;
            this.description = description;
            cards = new HashMap<Long, Card>();
            arrows = new HashMap<Long, Arrow>();
        }

        public Card createCard() {
            long uid = nextCardUid;
            nextCardUid++;

            Card newCard = new Card();
            newCard.uid = uid;
            cards.put(uid, newCard);

            return newCard;
        }

        public Arrow createArrow() {
            long uid = nextArrowUid;
            nextArrowUid++;

            Arrow newArrow = new Arrow();
            newArrow.uid = uid;
            arrows.put(uid, newArrow);

            return newArrow;
        }

        public void removeCard(Card card) {
            cards.remove(card.uid);
        }

        public void removeArrow(Arrow arrow) {
            arrows.remove(arrow.uid);
        }

        public String toJSON() {
            // TODO
            return "";
        };

        static public WordMap fromJSON(String json) {
            WordMap wordMap = new WordMap();
            // TODO
            return wordMap;
        }

}
