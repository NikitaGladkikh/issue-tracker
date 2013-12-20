package com.epam.issuetracker.domain.issue;

import com.epam.issuetracker.domain.comment.Comment;
import com.epam.issuetracker.domain.enums.TypeEnum;

import java.util.List;

/**
 * Represents issue data object.
 * <p/>
 * Date: 12/18/13
 *
 * @author Mikita_Hladkikh
 */
public class Issue {

    private String key;
    private String summary;
    private TypeEnum type;
    private String status;
    private String priority;
    private String resolution;
    private String severity;
    private List<Comment> comments;

    /**
     * Default constructor.
     */
    public Issue() {

    }

    /**
     * Getter for key of issue.
     *
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * Setter for key of issue.
     *
     * @param key set new key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Getter for summary of issue.
     *
     * @return summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Setter for summary of issue.
     *
     * @param summary set new summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Getter for type of issue.
     *
     * @return type
     */
    public TypeEnum getType() {
        return type;
    }

    /**
     * Setter for type of issue.
     *
     * @param type set new type
     */
    public void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * Getter for status of issue.
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter for status of issue.
     *
     * @param status set new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter for priority of issue.
     *
     * @return priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Setter for priority of issue.
     *
     * @param priority set new priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Getter for resolution of issue.
     *
     * @return resolution
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Setter for resolution of issue.
     *
     * @param resolution set new resolution
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * Getter for severity of issue.
     *
     * @return severity
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Setter for severity of issue.
     *
     * @param severity set new severity
     */
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    /**
     * Getter for comments list of issue.
     *
     * @return comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Setter for comments list of issue.
     *
     * @param comments set new comments
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object object) {
        if (null == object) {
            return false;
        }
        if (!(object instanceof Issue)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        Issue issue = (Issue) object;
        return key.equals(issue.key) && summary.equals(issue.summary) && type.equals(issue.type) && status.equals(
            issue.status) && priority.equals(issue.priority) && resolution.equals(issue.resolution) && severity.equals(
            issue.severity) && comments.equals(issue.comments);
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 37 * result + key.hashCode();
        result = 37 * result + summary.hashCode();
        result = 37 * result + type.hashCode();
        result = 37 * result + status.hashCode();
        result = 37 * result + priority.hashCode();
        result = 37 * result + resolution.hashCode();
        result = 37 * result + severity.hashCode();
        result = 37 * result + comments.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Key: ")
            .append(key)
            .append(" , Summary: ")
            .append(summary)
            .append(" , Type: ")
            .append(type)
            .append(" , Status: ")
            .append(status)
            .append(" , Priority: ")
            .append(priority)
            .append(", Resolution: ")
            .append(resolution)
            .append(" , Severity: ")
            .append(severity)
            .append(" , Comment: ")
            .append(comments)
            .toString();
    }
}
