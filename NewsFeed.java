/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
    	// Your code here.
		messages = new Post[MAX_SIZE];
		size = 0;
    }

    public void add(Post message) {
      // Your code here.
	  if (size < MAX_SIZE){
		  messages[size] = message;
		  size++;
	  }
	}
	
	public Post get(int index) {
		if (index >= 0 && index < size){
	     return messages[index];
		} else {
			return null;
		}
	}

    public int size() {
	     return size;
    }

	  public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

  			tmp = messages[argMin];
  			messages[argMin] = messages[i];
  			messages[i] = tmp;
		  }

	  }

  	public NewsFeed getPhotoPost(){
  		// Your code here
		NewsFeed newPhotoPost = new NewsFeed();
		for (int i = 0; i < size;i++){
			if (messages[i] instanceof PhotoPost){
				newPhotoPost.add(messages[i]);
			}
		}
		return newPhotoPost;
  	}

  	public NewsFeed plus(NewsFeed other){

  	  // Your code here
	  NewsFeed combinedNewsFeed = new NewsFeed();
	  for (int i = 0; i < size; i++) {
		  combinedNewsFeed.add(messages[i]);
	  }
	  for (int i = 0; i < other.size(); i++){
		  combinedNewsFeed.add(other.get(i));
	  }
	  combinedNewsFeed.sort();
	  
	  return combinedNewsFeed;
	  
  	}

}
