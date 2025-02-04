public class Rational {
    /**
     * Returns a rational number after being summed up and compared
     * @author Ahmad Naween Samandar
     * @param numerator an instance variable of int;
     * @param denominator an instance variable of int;
     * @return fraction of numerator and denominator;
     */

    private int numerator;
    private int denominator;

    // Constructors
    public Rational(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;  // Denominator is assumed to be 1
        reduce();  // Reduce the fraction to its simplest form
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();  // Reduce the fraction to its simplest form
    }

    // Getters
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Instance method: plus
    public Rational plus(Rational other) {
        int newNumerator = this.numerator * other.denominator + this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);  // Return a new Rational object
    }

    // Static method: plus
    public static Rational plus(Rational a, Rational b) {
        return a.plus(b);  // Delegate the work to the instance method
    }

    // Private method to calculate the GCD (Greatest Common Divisor)
    private int gcd(int a, int b) {
        a = Math.abs(a);  // Make sure a is positive
        b = Math.abs(b);  // Make sure b is positive
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;  // Return the GCD
    }

    // Reduce method: to reduce the fraction to its simplest form
    private void reduce() {
        if (denominator < 0) {  // Make sure the denominator is positive
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcdValue = gcd(numerator, denominator);
        numerator /= gcdValue;  // Reduce the numerator
        denominator /= gcdValue;  // Reduce the denominator
    }

    // Equals method: Check if two fractions are equivalent
    public boolean equals(Rational other) {
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    // CompareTo method: Compare two fractions for order
    public int compareTo(Rational other) {
        int thisValue = this.numerator * other.denominator;
        int otherValue = other.numerator * this.denominator;
        return Integer.compare(thisValue, otherValue);  // Compare the cross-multiplication results
    }

    // toString method: Returns a string representation of the fraction
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);  // If denominator is 1, return only the numerator
        } else {
            return numerator + "/" + denominator;  // Otherwise, return the fraction in "numerator/denominator" form
        }
    }
}
