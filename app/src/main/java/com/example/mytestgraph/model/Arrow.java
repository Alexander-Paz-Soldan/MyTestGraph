package com.example.mytestgraph.model;

public class Arrow {

    public enum Type {
        NORMAL
    }

    public long uid;
    public Card origin;
    public Card destination;
    public Type type;

    /**
     * for the Firebase app
     * @return
     */
    public String toJSON() {
        return "";
    }

}
