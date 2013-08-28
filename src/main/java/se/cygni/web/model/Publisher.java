package se.cygni.web.model;

public class Publisher {
    public final int id;
    public final String name;
    public final String shortName;

    public Publisher(int id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }
}
