public class DoorLock {

    // Constant.
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables.
    private Combination combination;
    private boolean open;
    private boolean activated;
    private int numberOfAttempts;

    // Constructor.
    public DoorLock(Combination combination) {
        this.combination = combination;  // Correctly initialize the instance variable
        open = false;                    // Door is initially closed
        activated = true;                // Lock is initially activated
        numberOfAttempts = 0;            // No failed attempts initially
    }

    // Access methods.
    public boolean isOpen() {
        return open;
    }

    public boolean isActivated() {
        return activated;
    }

    // Method to attempt unlocking the door.
    public boolean open(Combination combination) {
        if (!activated) {                // If lock is deactivated, deny access
            return false;
        }

        if (this.combination.equals(combination)) {  // Check if combination matches
            open = true;             // Open the door
            numberOfAttempts = 0;    // Reset failed attempts
            return true;
        } else {
            numberOfAttempts++;      // Increment failed attempts

            if (numberOfAttempts >= MAX_NUMBER_OF_ATTEMPTS) {
                activated = false;   // Deactivate the lock if attempts exceed max
            }
            return false;
        }
    }

    // Method to activate the door lock.
    public void activate(Combination c) {
        if (this.combination.equals(c)) {  // Activate only if the combination matches
            activated = true;
        }
    }
}
