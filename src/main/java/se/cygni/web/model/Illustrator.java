package se.cygni.web.model;

import com.github.slugify.Slugify;

public class Illustrator {

    public final int id;
    public final String name;
    public final String nameSlug;

    public Illustrator(int id, String name) {
        this.name = name;
        this.id = id;
        this.nameSlug = Slugify.slugify(name);
    }
}
