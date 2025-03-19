import java.util.Random;

public class Customer {

    // Class variable
    private static final int MAX_NUM_ITEMS = 20; // Example value, adjust as needed

    // Instance variables
    private int arrivalTime;
    private int initialNumberOfItems;
    private int numberOfItems;

    // Constructor
    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;

        // Randomly generate the initial number of items (between 1 and MAX_NUM_ITEMS)
        Random generator = new Random();
        this.initialNumberOfItems = generator.nextInt(MAX_NUM_ITEMS - 1) + 1;
        this.numberOfItems = this.initialNumberOfItems; // Initially, no items have been processed
    }

    // Instance methods

    // Returns the arrival time
    public int getArrivalTime() {
        return arrivalTime;
    }

    // Returns the number of items remaining to be processed
    public int getNumberOfItems() {
        return numberOfItems;
    }

    // Returns the number of items that have been processed
    public int getNumberOfServedItems() {
        return initialNumberOfItems - numberOfItems;
    }

    // Decrements the number of items remaining by 1
    public void serve() {
        if (numberOfItems > 0) {
            numberOfItems--;
        }
    }

    @Override
    public String toString() {
        return "Customer[arrivalTime=" + arrivalTime +
               ", initialNumberOfItems=" + initialNumberOfItems +
               ", numberOfItems=" + numberOfItems + "]";
    }
}