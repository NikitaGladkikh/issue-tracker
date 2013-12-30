package com.epam.issuetracker.ui.event;

import com.vaadin.ui.Component;

/**
 * Event for selected project.
 * Date: 12/26/13
 *
 * @author Mikita_Hladkikh
 */
public class ProjectSelectedEvent extends Component.Event {

    private String projectId;

    /**
     * Constructs a new event with the specified source component.
     *
     * @param source the source component of the event
     */
    public ProjectSelectedEvent(Component source, String projectId) {
        super(source);
        this.projectId = projectId;
    }

    /**
     * Get id of project.
     *
     * @return id of project.
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * Set id of project.
     *
     * @param projectId
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
