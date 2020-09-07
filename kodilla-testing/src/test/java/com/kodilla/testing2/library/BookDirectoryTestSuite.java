package com.kodilla.testing2.library;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    private static int testCounter = 0;

    private static List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for (int i = 1; i <= booksQuantity; i++) {
            Book theBook = new Book("Title " + i, "Author " + i, 1970 + i);
            resultList.add(theBook);
        }
        return resultList;
    }

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, never()).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfNoBorrowedBooksByUser() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Paul", "Stevens", "91040800456");
        List<Book> resultListBooksInHandsOf = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(anyObject())).thenReturn(resultListBooksInHandsOf);

        // When
        List<Book> listNoBorrowedBooksByUser = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        assertEquals(0, listNoBorrowedBooksByUser.size());
        verify(libraryDatabaseMock).listBooksInHandsOf(libraryUser);
    }

    @Test
    public void testListBooksInHandsOfOneBorrowedBookByUser() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Jack", "Stevens", "91040800456");
        List<Book> resultListBooksInHandsOf = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(anyObject())).thenReturn(resultListBooksInHandsOf);

        // When
        List<Book> listOneBorrowedBookByUser = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        assertEquals(1, listOneBorrowedBookByUser.size());
        verify(libraryDatabaseMock).listBooksInHandsOf(libraryUser);
    }

    @Test
    public void testListBooksInHandsOfFiveBorrowedBooksByUser() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Arthur", "Stevens", "91040800456");
        List<Book> resultListBooksInHandsOf = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(anyObject())).thenReturn(resultListBooksInHandsOf);

        // When
        List<Book> listFiveBorrowedBooksByUser = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        assertEquals(5, listFiveBorrowedBooksByUser.size());
        verify(libraryDatabaseMock).listBooksInHandsOf(libraryUser);
    }
}
