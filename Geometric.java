public class Geometric extends AbstractSeries {
    private int i = 0; // Step counter
    private double sum = 0.0; // Stores the running sum

    public double next() {
        sum += 1.0 / Math.pow(2, i); // Add next term in series
        i++; // Move to the next step
        return sum;
    }
}
