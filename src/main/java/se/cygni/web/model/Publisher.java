package se.cygni.web.model;

import com.github.slugify.Slugify;

public class Publisher {
    public final int id;
    public final String name;
    public final String nameSlug;
    public final String shortName;

    public Publisher(int id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.nameSlug = new Slugify(true).slugify(name);
        this.shortName = shortName;
    }
}
