import java.util.Objects;

public class Book {

    private String author;
    private String title;
    private int year;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Book book = (Book) other;
        return year == book.year && Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public String toString() {
        return author + ": " + title + " (" + year + ")";
    }
}
