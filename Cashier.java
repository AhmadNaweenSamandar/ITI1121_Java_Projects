public class Cashier {

    // Instance variables
    private Queue<Customer> queue;
    private Customer currentCustomer;
    private int totalCustomersServed;
    private int totalWaitTime;
    private int totalItemsServed;

    // Constructor
    public Cashier() {
        queue = new ArrayQueue<>();
        currentCustomer = null;
        totalCustomersServed = 0;
        totalWaitTime = 0;
        totalItemsServed = 0;
    }

    // Adds a customer to the queue
    public void addCustomer(Customer c) {
        queue.enqueue(c);
    }

    // Returns the number of customers waiting in the queue
    public int getQueueSize() {
        return queue.size();
    }

    // Serves customers at the current time
    public void serveCustomers(int currentTime) {
        // If no customer is being served, take the next customer from the queue
        if (currentCustomer == null && !queue.isEmpty()) {
            currentCustomer = queue.dequeue();
            totalWaitTime += (currentTime - currentCustomer.getArrivalTime()); // Add waiting time
            totalCustomersServed++; // Increment total customers served
        }

        // Serve one item from the current customer
        if (currentCustomer != null) {
            currentCustomer.serve(); // Decrement the number of items
            totalItemsServed++; // Increment total items served

            // If the customer has no more items, remove them
            if (currentCustomer.getNumberOfItems() == 0) {
                currentCustomer = null; // No customer is being served now
            }
        }
    }

    // Returns the total waiting time of all customers
    public int getTotalCustomerWaitTime() {
        return totalWaitTime;
    }

    // Returns the total number of items served
    public int getTotalItemsServed() {
        return totalItemsServed;
    }

    // Returns the total number of customers served
    public int getTotalCustomersServed() {
        return totalCustomersServed;
    }

    // Returns a string summarizing the statistics of the cashier
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The total number of customers served is ").append(totalCustomersServed).append("\n");
        sb.append("The average number of items per customer was ").append(totalItemsServed / totalCustomersServed).append("\n");
        sb.append("The average waiting time (in seconds) was ").append(totalWaitTime / totalCustomersServed).append("\n");
        return sb.toString();
    }
}