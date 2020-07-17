package com.kodilla.patterns2.adapter.bookclasifier.librarya;

import java.util.Objects;

public class Book {
    private final String author;
    private final String title;
    private final int publicationYear;
    private final String signature;

    public Book(final String author, final String title, final int publicationYear, final String signature) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.signature = signature;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                Objects.equals(publicationYear, book.publicationYear) &&
                Objects.equals(signature, book.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, publicationYear, signature);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", signature='" + signature + '\'' +
                '}' + "\n";
    }
}
