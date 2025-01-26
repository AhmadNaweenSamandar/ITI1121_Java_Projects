public class Q3_SquareArray {

    //Creating array of int size, iterating through it and multiplying each array member within itself
    public static int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i * i;
        }
        return array;
    }

    // printing array with it's address as i and the value as theMainArray
    public static void main(String[] args) {
        int[] theMainArray = createArray(13);
        for (int i = 0; i < theMainArray.length; i++) {
            System.out.println("The square of " + i + " is " + theMainArray[i]);
        }
    }
}
