package se.cygni.web.model;

import com.github.slugify.Slugify;

public class Book {

    public final int id;
    public final String titleSwedish;
    public final String titleSwedishSlug;
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
        this.titleSwedishSlug = new Slugify(true).slugify(titleSwedish);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (chrono != book.chrono) return false;
        if (hasCover != book.hasCover) return false;
        if (id != book.id) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (coverImagePath != null ? !coverImagePath.equals(book.coverImagePath) : book.coverImagePath != null)
            return false;
        if (coverNumber != null ? !coverNumber.equals(book.coverNumber) : book.coverNumber != null) return false;
        if (illustrator != null ? !illustrator.equals(book.illustrator) : book.illustrator != null) return false;
        if (noofEditions != null ? !noofEditions.equals(book.noofEditions) : book.noofEditions != null) return false;
        if (publisherEnglish != null ? !publisherEnglish.equals(book.publisherEnglish) : book.publisherEnglish != null)
            return false;
        if (publisherSwedish != null ? !publisherSwedish.equals(book.publisherSwedish) : book.publisherSwedish != null)
            return false;
        if (story != null ? !story.equals(book.story) : book.story != null) return false;
        if (titleEnglish != null ? !titleEnglish.equals(book.titleEnglish) : book.titleEnglish != null) return false;
        if (titleSwedish != null ? !titleSwedish.equals(book.titleSwedish) : book.titleSwedish != null) return false;
        if (titleSwedishSlug != null ? !titleSwedishSlug.equals(book.titleSwedishSlug) : book.titleSwedishSlug != null)
            return false;
        if (translator != null ? !translator.equals(book.translator) : book.translator != null) return false;
        if (yearFirstEditionEnglish != null ? !yearFirstEditionEnglish.equals(book.yearFirstEditionEnglish) : book.yearFirstEditionEnglish != null)
            return false;
        if (yearFirstEditionSwedish != null ? !yearFirstEditionSwedish.equals(book.yearFirstEditionSwedish) : book.yearFirstEditionSwedish != null)
            return false;
        if (yearThisEdition != null ? !yearThisEdition.equals(book.yearThisEdition) : book.yearThisEdition != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titleSwedish != null ? titleSwedish.hashCode() : 0);
        result = 31 * result + (titleSwedishSlug != null ? titleSwedishSlug.hashCode() : 0);
        result = 31 * result + (titleEnglish != null ? titleEnglish.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (translator != null ? translator.hashCode() : 0);
        result = 31 * result + (illustrator != null ? illustrator.hashCode() : 0);
        result = 31 * result + (publisherSwedish != null ? publisherSwedish.hashCode() : 0);
        result = 31 * result + (publisherEnglish != null ? publisherEnglish.hashCode() : 0);
        result = 31 * result + (yearFirstEditionSwedish != null ? yearFirstEditionSwedish.hashCode() : 0);
        result = 31 * result + (yearFirstEditionEnglish != null ? yearFirstEditionEnglish.hashCode() : 0);
        result = 31 * result + (yearThisEdition != null ? yearThisEdition.hashCode() : 0);
        result = 31 * result + (noofEditions != null ? noofEditions.hashCode() : 0);
        result = 31 * result + (coverNumber != null ? coverNumber.hashCode() : 0);
        result = 31 * result + (hasCover ? 1 : 0);
        result = 31 * result + (story != null ? story.hashCode() : 0);
        result = 31 * result + (coverImagePath != null ? coverImagePath.hashCode() : 0);
        result = 31 * result + chrono;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titleSwedish='" + titleSwedish + '\'' +
                ", titleSwedishSlug='" + titleSwedishSlug + '\'' +
                ", titleEnglish='" + titleEnglish + '\'' +
                ", author='" + author + '\'' +
                ", translator='" + translator + '\'' +
                ", illustrator='" + illustrator + '\'' +
                ", publisherSwedish='" + publisherSwedish + '\'' +
                ", publisherEnglish='" + publisherEnglish + '\'' +
                ", yearFirstEditionSwedish='" + yearFirstEditionSwedish + '\'' +
                ", yearFirstEditionEnglish='" + yearFirstEditionEnglish + '\'' +
                ", yearThisEdition='" + yearThisEdition + '\'' +
                ", noofEditions='" + noofEditions + '\'' +
                ", coverNumber='" + coverNumber + '\'' +
                ", hasCover=" + hasCover +
                ", story='" + story + '\'' +
                ", coverImagePath='" + coverImagePath + '\'' +
                ", chrono=" + chrono +
                '}';
    }
}
