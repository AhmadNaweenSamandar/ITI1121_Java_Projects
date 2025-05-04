import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
        head = new Node(null, null, null); //this is a dummy node with null values
		head.previous = head; // the previouse is pointing back to head as per dummy
		head.next = head; // the next is pointing back to head as per dummy 
    }

    // Calculates the size of the list

    public int size() {
      	// Remove line below and add your implementation.
		int count = 0; // since it's dummy and we are not allowed to create a size variable so we create a class variable count
		Node p = head.next; // since it's dummy and dummy exists always as node, so the p is head.next (the original head after dummy)
		while(p != head){
			count++;
			p = p.next;
		}
		return count;
	}


    public Object get( int pos ) {
		// check the invalid position input
		if (pos < 0 || pos >= size()){
			throw new IndexOutOfBoundsException("Position is out of bonds");
		}
		
		Node current = head.next; // Start at the first real node (skip dummy)
		for (int i = 0; i < pos; i++){
			current = current.next;
		}
		return current.value;
	}

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {
        // Remove line below and add your implementation.
		// check if o is not null because if o is null so we can add anything to the list and it must return false
		if (o == null){
			throw new IllegalArgumentException();
		}
		
		Node newNode = new Node(o, null, null);
		
		//first case when the list is empthy
		if(head.next == head){ // so when the list is empthy the dummy will be head which is null
			newNode.next = head; // now since head is dummy (head.next) so newNode.next will also be pointing to dummy
			newNode.previous = head; // previous also pointing dummy
			head.next = newNode; // dummy's next is newNode
			head.previous = newNode; // dummy's previous is newNode
			return true;
		}
		
		//Case 2; non-empthy list, find the insertion pointing
		Node current = head.next;
		while (current != head && o.compareTo(current.value) > 0){
			current = current.next;
		}
		
		newNode.next = current;
		newNode.previous = current.previous;
		current.previous.next = newNode;
		current.previous = newNode;
		
		return true;
		
			
		
        
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
          // Check for invalid position
		if (pos < 0 || pos >= size()) {
			throw new IndexOutOfBoundsException("Position " + pos + " is out of bounds");
		}
		  
		Node current = head.next; // Start at first real node (skip dummy)
		for (int i = 0; i < pos; i++){
			current = current.next;
		}
		current.previous.next = current.next;
		current.next.previous = current.previous;
	}

    public void merge(OrderedList other) {
		if (other == null || other.head.next == other.head) {
			throw new IllegalArgumentException(); // Nothing to merge if other list is empty or null
		}

		Node thisCurrent = head.next; // Start of this list (skip dummy)
		Node otherCurrent = other.head.next; // Start of other list (skip dummy)

		while (otherCurrent != other.head) {
			// Find the insertion point in this list
			while (thisCurrent != head && otherCurrent.value.compareTo(thisCurrent.value) > 0) {
				thisCurrent = thisCurrent.next;
				}

			// Create a new node with the same value (don't reuse the other list's node)
			Node newNode = new Node(otherCurrent.value, thisCurrent.previous, thisCurrent);
			thisCurrent.previous.next = newNode;
			thisCurrent.previous = newNode;

			// Move to next node in other list
			otherCurrent = otherCurrent.next;
		}
	}
}