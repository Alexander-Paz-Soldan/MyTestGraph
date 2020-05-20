package com.example.mytestgraph.model;

public class Arrow {

    public enum Type {
        NORMAL
    }

    public long uid;
    public Card origin;
    public Card destination;
    public Type type;


    public String toJSON() {
        // TODO
        return "";
    }

}
