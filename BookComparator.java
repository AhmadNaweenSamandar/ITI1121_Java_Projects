import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        // Compare first by author
        int authorComparison = b1.getAuthor().compareTo(b2.getAuthor());
        if (authorComparison != 0) {
            return authorComparison;
        }

        // If authors are the same, compare by title
        int titleComparison = b1.getTitle().compareTo(b2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }

        // If both author and title are the same, compare by year
        return Integer.compare(b1.getYear(), b2.getYear());
    }
}
