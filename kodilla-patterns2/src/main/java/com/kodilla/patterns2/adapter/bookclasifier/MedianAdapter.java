package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookB;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<BookA> books) {
        Map<BookSignature, BookB> booksMap = new HashMap<>();
        books.forEach(bookA -> {
            booksMap.put(new BookSignature(bookA.getSignature()),
                    new BookB(bookA.getAuthor(), bookA.getTitle(), bookA.getPublicationYear()));
        });
        return medianPublicationYear(booksMap);
    }
}
