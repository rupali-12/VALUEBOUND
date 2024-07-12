package librarysystem;

public class Book {

    public String title;
    public String author;
    public String isbn;
    boolean isAvailable;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        isAvailable = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }

}