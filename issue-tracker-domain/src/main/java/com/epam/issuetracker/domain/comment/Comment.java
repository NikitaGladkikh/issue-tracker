package com.epam.issuetracker.domain.comment;

/**
 * Represents comment data object.
 * <p/>
 * Date: 12/19/13
 *
 * @author Mikita_Hladkikh
 */
public class Comment {

    private String id;
    private String user;
    private String comment;

    /**
     * Getter for id of comment.
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for id of comment.
     *
     * @param id set new user
     */
    public void setId(String id) {
        this.id = id;
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
        if (this == object) {
            return true;
        }
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment that = (Comment) object;
        if (null != id ? !id.equals(that.id) : null != that.id) {
            return false;
        }
        if (null != user ? !user.equals(that.user) : null != that.user) {
            return false;
        }
        if (null != comment ? !comment.equals(that.comment) : null != that.comment) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 37 + (null == id ? 0 : id.hashCode());
        result = 37 + (null == user ? 0 : user.hashCode());
        return 31 * result + (null == comment ? 0 : comment.hashCode());
    }

    @Override
    public String toString() {
        return new StringBuilder(", User: ").append(user)
            .append(", Comment: ")
            .append(comment)
            .toString();
    }
}
