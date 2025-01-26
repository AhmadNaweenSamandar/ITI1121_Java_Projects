import java.util.Arrays;
import java.util.Collections;

public class Q3_ReverseSortDemo {
    public static void main(String[] args) {
        char[] unorderedLetters;
        unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
        
        // Sort the array in reverse order
        reverseSort(unorderedLetters);

        // Print sorted characters
        for (int i = 0; i < unorderedLetters.length; i++)
            System.out.print(unorderedLetters[i]);
    }

    // Method that sorts a char array into reverse alphabetical order
    public static void reverseSort(char[] values) {
        // Convert char array to Character array to use built-in sorting methods
        Character[] charArray = new Character[values.length];
        for (int i = 0; i < values.length; i++) {
            charArray[i] = values[i];
        }

        // Sort in reverse order
        Arrays.sort(charArray, Collections.reverseOrder());

        // Convert sorted Character array back to char array
        for (int i = 0; i < values.length; i++) {
            values[i] = charArray[i];
        }
    }
}
