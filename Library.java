import java.util.ArrayList;
import java.util.Collections;

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();

    // Method to add a book to the library
    public void addBook(Book b) {
        library.add(b);
    }

    // Method to get a book by index
    public Book getBook(int i) {
        return library.get(i);
    }

    // Method to get the total number of books in the library
    public int getSize() {
        return library.size();
    }

    // Method to sort books using a comparator
    public void sort() {
        Collections.sort(library, new BookComparator());
    }

    // Method to print all books in the library
    public void printLibrary() {
        for (Book book : library) {
            System.out.println(book);
        }
    }
}
