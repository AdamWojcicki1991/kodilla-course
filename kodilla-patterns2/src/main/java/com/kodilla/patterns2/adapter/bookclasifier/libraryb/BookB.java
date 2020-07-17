package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.Objects;

public class BookB {
    private final String author;
    private final String title;
    private final int yearOfPublication;

    public BookB(final String author, final String title, final int yearOfPublication) {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookB bookB = (BookB) o;

        return Objects.equals(author, bookB.author) &&
                Objects.equals(title, bookB.title) &&
                Objects.equals(yearOfPublication, bookB.yearOfPublication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, yearOfPublication);
    }

    @Override
    public String toString() {
        return "BookB{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}' + "\n";
    }
}
