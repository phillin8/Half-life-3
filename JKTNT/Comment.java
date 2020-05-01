import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;

public class Comment {
    private String user;
    private String comment;
    private int rating;
    private ArrayList<Comment> replies;
    private JButton upDoot;
    private JButton downDoot;
    private JButton reply;
    
    public Comment(String user, String comment, int rating) {
        this.user = user;
        this.comment = comment;
        this.rating = rating;
        upDoot = new JButton("/\\");
        upDoot.setPreferredSize(new Dimension(5, 5));
        downDoot = new JButton("\\/");
        downDoot.setPreferredSize(new Dimension(5, 5));
        reply = new JButton("reply");
        reply.setPreferredSize(new Dimension(5, 5));
        
    }
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }
    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }
    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }
    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    /**
     * @return the replies
     */
    public ArrayList<Comment> getReplies() {
        return replies;
    }
    /**
     * @param replies the replies to set
     */
    public void setReplies(ArrayList<Comment> replies) {
        this.replies = replies;
    }
    
    
}
