package se.cygni.web.model;

import com.github.slugify.Slugify;

public class Translator {

    public final int id;
    public final String name;
    public final String nameSlug;

    public Translator(int id, String name) {
        this.name = name;
        this.id = id;
        this.nameSlug = new Slugify(true).slugify(name);
    }
}
