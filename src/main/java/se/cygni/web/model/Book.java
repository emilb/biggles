package se.cygni.web.model;

public class Book {

    public final int id;
    public final String titleSwedish;
    public final String titleEnglish;
    public final String author;
    public final String translator;
    public final String illustrator;
    public final String publisherSwedish;
    public final String publisherEnglish;
    public final String yearFirstEditionSwedish;
    public final String yearFirstEditionEnglish;
    public final String yearThisEdition;
    public final String noofEditions;
    public final String coverNumber;
    public final boolean hasCover;
    public final String story;
    public final String coverImagePath;
    public final int chrono;

    public Book(int id, String titleSwedish, String titleEnglish,
                String author, String translator, String illustrator, String publisherSwedish,
                String publisherEnglish, String yearFirstEditionSwedish,
                String yearFirstEditionEnglish, String yearThisEdition,
                String noofEditions, String coverNumber, boolean hasCover,
                String story, String coverImagePath, int chrono) {

        this.id = id;
        this.titleSwedish = titleSwedish;
        this.titleEnglish = titleEnglish;
        this.author = author;
        this.translator = translator;
        this.illustrator = illustrator;
        this.publisherSwedish = publisherSwedish;
        this.publisherEnglish = publisherEnglish;
        this.yearFirstEditionSwedish = yearFirstEditionSwedish;
        this.yearFirstEditionEnglish = yearFirstEditionEnglish;
        this.yearThisEdition = yearThisEdition;
        this.noofEditions = noofEditions;
        this.coverNumber = coverNumber;
        this.hasCover = hasCover;
        this.story = story;
        this.coverImagePath = coverImagePath;
        this.chrono = chrono;
    }
}
