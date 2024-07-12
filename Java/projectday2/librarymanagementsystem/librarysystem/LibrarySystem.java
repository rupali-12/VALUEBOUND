/* Problem 1:Library Management System Objective Create a Library Management System using 
Object-Oriented Programming concepts and Java'sArrayList.Requirements Classes and Objects:Create classes for Book,Member,and Library.A Book should have attributes like title,author,isbn,isAvailable(boolean).A Member should have attributes like memberId,name,and a list of borrowedBooks.The Library
class should
manage books
and members.
Library Operations:
Add a
book to
the library.
Remove a
book from
the library.
Register a new
member.
Borrow a

book (a member borrows a book if available).
Return a

book (a member returns a borrowed book).
List all available books.
List all members.
Exception Handling:
Implement custom exceptions for scenarios such as BookNotFoundException, MemberNotFoundException, and BookNotAvailableException.
Data Storage:
Use ArrayList to store books and members in the Library class.
Additional Challenges
Implement a search function to find books by title or author.
Track the borrowing history of each member.
Add a feature to display overdue books and fines for members  */
package librarysystem;

import customexception.*;

public class LibrarySystem {

    public static void main(String[] args) {
        Library library = new Library();

        // Add some books to the library
        Book book1 = new Book("Book One", "Author A", "1111");
        Book book2 = new Book("Book Two", "Author B", "2222");
        library.addBook(book1);
        library.addBook(book2);

        // Register some members
        Member member1 = new Member("Alice", 1);
        Member member2 = new Member("Bob", 2);
        library.registerMember(member1);
        library.registerMember(member2);

        try {
            // Borrow a book
            library.borrowBook("Book One", 1);

            // List available books
            library.allAvailableBooks();

            // Return a book
            library.returnBook("Book One", 1);

            // List available books
            library.allAvailableBooks();
        } catch (BookNotFoundException | MemberNotFoundException | BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
