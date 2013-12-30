package com.epam.issuetracker.ui.event;

import com.vaadin.ui.Component;

/**
 * Event for selected issue.
 * Date: 12/26/13
 *
 * @author Mikita_Hladkikh
 */
public class IssueSelectedEvent extends Component.Event {

    private String issueId;

    /**
     * Constructs a new event with the specified source component.
     *
     * @param source the source component of the event
     */
    public IssueSelectedEvent(Component source, String issueId) {
        super(source);
        this.issueId = issueId;
    }

    /**
     * Get issue id.
     *
     * @return id of issue.
     */
    public String getIssueId() {
        return issueId;
    }

    /**
     * Set id of issue.
     *
     * @param issueId id of issue.
     */
    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }
}
