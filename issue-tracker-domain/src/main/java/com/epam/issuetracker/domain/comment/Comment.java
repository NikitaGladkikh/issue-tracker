package com.epam.issuetracker.domain.comment;

/**
 * Represents comment data object.
 * <p/>
 * Date: 12/19/13
 *
 * @author Mikita_Hladkikh
 */
public class Comment {

    private String user;
    private String comment;

    /**
     * Default constructor.
     */
    public Comment() {

    }

    /**
     * Getter for user of comment.
     *
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * Setter for user of comment.
     *
     * @param user set new user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Getter for comment of comment.
     *
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter for comment of comment.
     *
     * @param comment set new comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object object) {
        if (null == object) {
            return false;
        }
        if (!(object instanceof Comment)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        Comment newComment = (Comment) object;
        return user.equals(newComment.user) && newComment.equals(newComment.comment);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 37 * result + user.hashCode();
        result = 37 * result + comment.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("User: ")
            .append(user)
            .append(" , Comment: ")
            .append(comment)
            .toString();
    }
}
