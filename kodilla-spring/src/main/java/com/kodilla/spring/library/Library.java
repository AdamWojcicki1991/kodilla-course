package com.kodilla.spring.library;

import java.util.ArrayList;
import java.util.List;

public final class Library {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    public Library(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public Library() {
    }

//    @Autowired
//    private LibraryDbController libraryDbController;

//    @Autowired
//    public Library(final LibraryDbController libraryDbController) {
//        this.libraryDbController = libraryDbController;
//    }

//    @Autowired
//    public void setLibraryDbController(LibraryDbController libraryDbController) {
//        this.libraryDbController = libraryDbController;
//    }

//    public Library() {
//    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}
