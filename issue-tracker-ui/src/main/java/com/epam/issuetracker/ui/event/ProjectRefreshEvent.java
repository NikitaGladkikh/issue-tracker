package com.epam.issuetracker.ui.event;

import com.vaadin.ui.Component;

/**
 * Date: 1/10/14
 *
 * @author Mikita_Hladkikh
 */
public class ProjectRefreshEvent extends Component.Event {

    /**
     * Constructs a new event with the specified source component.
     *
     * @param source the source component of the event
     */
    public ProjectRefreshEvent(Component source) {
        super(source);
    }
}
