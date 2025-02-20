public class Arithmetic extends AbstractSeries {
    private int i = 0; // Tracks the step in sequence
    private double sum = 0.0; // Stores current sum

    public double next() {
        i++; // Increment step
        sum += i; // Add step to sum
        return sum;
    }
}
