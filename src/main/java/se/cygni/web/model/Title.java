package se.cygni.web.model;

import com.github.slugify.Slugify;

public class Title {

    public final int id;
    public final String name;
    public final String nameSlug;
    public final String nameEnglish;
    public final int chrono;

    public Title(int id, String name, String nameEnglish, int chrono) {
        this.name = name;
        this.nameEnglish = nameEnglish;
        this.id = id;
        this.chrono = chrono;
        this.nameSlug = new Slugify(true).slugify(name);
    }
}
