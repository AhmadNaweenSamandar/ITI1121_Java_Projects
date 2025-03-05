public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        /* Your code here */
		elems = new Pair[INITIAL_CAPACITY];
		count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        /* Your code here */
		if (key == null || value == null){
			throw new IllegalArgumentException("Key and Value cannot be null");
		}
		if (count == elems.length){
			increaseCapacity();
		}
		elems[count++] = new Pair(key, value);
	
    }

    private void increaseCapacity() {
        /* Your code here.  Use this in put() where necessary. */
		Pair[] newElems = new Pair[elems.length + INCREMENT];
		System.arraycopy(elems, 0, newElems, 0, count);
		elems = newElems;
	}
    

    @Override
    public boolean contains(String key) {
        /* Your code here. */
		if (key == null){
			throw new IllegalArgumentException("Key cannot be null.");
		}
		for(int i = count - 1; i >= 0; i--){
			if (elems[i].getKey().equals(key)){
				return true;
			}
		}
		return false;
    }

    @Override
    public Integer get(String key) {
        /* Your code here. */
		if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
		for (int i = count - 1; i >= 0; i--){
			if (elems[i].getKey().equals(key)) {
				return elems[i].getValue();
			}
		}
		return null;
    }

    @Override
    public void replace(String key, Integer value) {
        /* Your code here. */
		if (key == null || value == null) {
            throw new IllegalArgumentException("Key and Value cannot be null.");
        }
		for (int i = count - 1; i >= 0; i--){
			if (elems[i].getKey().equals(key)){
				elems[i].setValue(value);
				return;
			}
		}
	
    }

    @Override
    public Integer remove(String key) {
        /* Your code here. */
		if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
		for (int i = count - 1; i >= 0; i--){
			if (elems[i].getKey().equals(key)){
				Integer removedValue = elems[i].getValue();
				System.arraycopy(elems, i + 1, elems, i, count - i - 1);
				elems[--count] = null;
				return removedValue;
			}
		}
		return null;
    }

    @Override
    public String toString() {
      StringBuilder res = new StringBuilder("Dictionary: {elems = [");
      for (int i = count-1; i >= 0 ; i--) {
          res.append(elems[i]);
          if(i > 0) {
              res.append(", ");
          }
      }
	  res.append("]}");
      return res.toString();
    }

}