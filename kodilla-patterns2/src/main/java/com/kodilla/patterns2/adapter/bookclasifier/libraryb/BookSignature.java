package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.Objects;

public class BookSignature {
    private final String signature;

    public BookSignature(final String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookSignature bookSignature = (BookSignature) o;

        return Objects.equals(signature, bookSignature.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signature);
    }

    @Override
    public String toString() {
        return "BookSignature{" +
                "signature='" + signature + '\'' +
                '}' + "\n";
    }
}
