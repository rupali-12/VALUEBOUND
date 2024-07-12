package librarysystem;

import customexception.*;
import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> registeredMembers = new ArrayList<>();

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book + " has been Added");
    }

    // Remove book from library
    public void removeBook(String title) throws BookNotFoundException {
        Book removedBook = findBookByTitle(title);
        if (removedBook != null) {
            books.remove(removedBook);
            System.out.println(removedBook + " has been Removed");
        } else {
            throw new BookNotFoundException("Book with title \"" + title + "\" not found");
        }
    }

    // Register a New Member
    public void registerMember(Member m) {
        registeredMembers.add(m);
        System.out.println(m + " has been Registered");
    }

    // Remove a Member
    public void removeMember(int mId) throws MemberNotFoundException {
        Member m = findMemberById(mId);
        if (m != null) {
            registeredMembers.remove(m);
            System.out.println(m + " has been Removed");
        } else {
            throw new MemberNotFoundException("Member with ID " + mId + " not found");
        }
    }

    // Borrow a book if available
    public void borrowBook(String title, int mId)
            throws BookNotAvailableException, BookNotFoundException, MemberNotFoundException {
        Book book = findBookByTitle(title);
        Member member = findMemberById(mId);
        if (book == null) {
            throw new BookNotFoundException("Book with title \"" + title + "\" not found");
        }
        if (!book.isAvailable) {
            throw new BookNotAvailableException("Book with title \"" + title + "\" is not available");
        }

        if (member == null) {
            throw new MemberNotFoundException("Member with ID " + mId + " not found");
        }

        member.borrowedBooks.add(book);
        books.remove(book);
        System.out.println(book + " has been borrowed by " + member.name + "(" + member.memberId + ")");
    }

    // Return a book (a member returns a borrowed book).
    public void returnBook(String title, int mId) throws BookNotFoundException, MemberNotFoundException {
        Book bookToReturn = findBookByTitle(title);
        Member member = findMemberById(mId);

        if (bookToReturn == null) {
            throw new BookNotFoundException("Book with title \"" + title + "\" not found");
        }

        if (member == null) {
            throw new MemberNotFoundException("Member with ID " + mId + " not found");
        }

        books.add(bookToReturn);
        member.borrowedBooks.remove(bookToReturn);
        bookToReturn.isAvailable = true;
        System.out.println(bookToReturn.title + " has been returned by " + member.name + "(" + member.memberId + ")");
    }

    // List all available books in Library
    public void allAvailableBooks() {
        System.out.println("Here, List of available books are shown here: ");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // List all available Members in Library
    public void allAvailableMembers() {
        System.out.println("Here, List of available members are shown here: ");
        for (Member members : registeredMembers) {
            System.out.println(members);
        }
    }

    // findBookByTitle
    private Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // findMemberById
    private Member findMemberById(int mId) {
        for (Member member : registeredMembers) {
            if (member.memberId == mId) {
                return member;
            }
        }
        return null;
    }

}