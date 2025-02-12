import java.util.Date;

public class Post implements Likeable, Comparable<Post> {

    private String userName;
    private int likes;
    private Date timeStamp;

    public Post(String userName) {
        this.userName = userName;
        this.likes = 0;  // Default likes count is 0
        this.timeStamp = new Date();  // Set the current date and time as the timestamp
    }

    // Implementing the getLikes method from Likeable interface
    @Override
    public int getLikes() {
        return likes;
    }

    // Method to like a post (incrementing likes)
    public void like() {
        likes++;
    }

    // Implementing the compareTo method from Comparable<Post> to compare by timeStamp
    @Override
    public int compareTo(Post other) {
        return this.timeStamp.compareTo(other.timeStamp);
    }

    // Method to return a string representation of the post
    @Override
    public String toString() {
        return "Post: " + timeStamp.toString() + ", " + userName + ", likes = " + likes;
    }

    // Getter for userName
    public String getUserName() {
        return userName;
    }

    // Getter for timestamp
    public Date getTimeStamp() {
        return timeStamp;
    }

}
