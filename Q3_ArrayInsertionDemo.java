public class Q3_ArrayInsertionDemo {

    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert) {
        // Create a new array with one extra space
        int[] newArray = new int[beforeArray.length + 1];

        // Copying elements before the insertion index
        for (int i = 0; i < indexToInsert; i++) {
            newArray[i] = beforeArray[i];
        }

        // Insert the new value at the specified index
        newArray[indexToInsert] = valueToInsert;

        // Copying elements after insertion
        for (int i = indexToInsert; i < beforeArray.length; i++) {
            newArray[i + 1] = beforeArray[i];
        }

        return newArray;  // Return the newly created array
    }

    // Method to print the array elements line by line
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        // Original Array Print
        int[] beforeArray = {1, 5, 4, 7, 9, 6};
        System.out.println("Array before insertion:");
        printArray(beforeArray);

        int indexToInsert = 3;
        int valueToInsert = 15;

        // Call the function to insert the value and store the result
        int[] newArray = insertIntoArray(beforeArray, indexToInsert, valueToInsert);

        // Print the updated array
        System.out.println("Array after insertion of " + valueToInsert + " at position " + indexToInsert + ":");
        printArray(newArray);
    }
}
