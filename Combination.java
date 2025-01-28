public class Combination {

    // Instance variables
    private int firstValue;
    private int secondValue;
    private int thirdValue;

    // Constructor
    public Combination(int first, int second, int third) {
        firstValue = first;
        secondValue = second;
        thirdValue = third;
    }

    // Instance method to check equality
    public boolean equals(Combination other) {
        if (other == null) {
            return false;
        }
        return this.firstValue == other.firstValue &&
               this.secondValue == other.secondValue &&
               this.thirdValue == other.thirdValue;
    }

    // Returns a String representation of this Combination
    public String toString() {
        return firstValue + ":" + secondValue + ":" + thirdValue;
    }

}
