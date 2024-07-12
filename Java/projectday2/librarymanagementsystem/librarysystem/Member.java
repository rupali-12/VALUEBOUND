package librarysystem;

import java.util.ArrayList;

public class Member {
    public int memberId;
    public String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return name + " (ID: " + memberId + ")";
    }
}
