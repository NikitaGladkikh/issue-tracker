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
        if (this == object) {
            return true;
        }
        if (!(object instanceof Issue)) {
            return false;
        }
        Issue that = (Issue) object;
        if (null != comments ? !comments.equals(that.comments) : null != that.comments) {
            return false;
        }
        if (null != key ? !key.equals(that.key) : null != that.key) {
            return false;
        }
        if (null != priority ? !priority.equals(that.priority) : null != that.priority) {
            return false;
        }
        if (null != resolution ? !resolution.equals(that.resolution) : null != that.resolution) {
            return false;
        }
        if (null != severity ? !severity.equals(that.severity) : null != that.severity) {
            return false;
        }
        if (null != status ? !status.equals(that.status) : null != that.status) {
            return false;
        }
        if (null != summary ? !summary.equals(that.summary) : null != that.summary) {
            return false;
        }
        if (null != type ? !type.equals(that.type) : null != that.type) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 37 + (null == comments ? 0 : comments.hashCode());
        result = 31 * result + (null == key ? 0 : key.hashCode());
        result = 31 * result + (null == priority ? 0 : priority.hashCode());
        result = 31 * result + (null == resolution ? 0 : resolution.hashCode());
        result = 31 * result + (null == severity ? 0 : severity.hashCode());
        result = 31 * result + (null == status ? 0 : status.hashCode());
        result = 31 * result + (null == summary ? 0 : summary.hashCode());
        return 31 * result + (null == type ? 0 : type.hashCode());
    }

    @Override
    public String toString() {
        return new StringBuilder("Key: ").append(key)
            .append(", Summary: ")
            .append(summary)
            .append(", Type: ")
            .append(type)
            .append(", Status: ")
            .append(status)
            .append(", Priority: ")
            .append(priority)
            .append(", Resolution: ")
            .append(resolution)
            .append(", Severity: ")
            .append(severity)
            .append(", Comments: ")
            .append(comments).toString();
    }
}
