package com.epam.issuetracker.ui;

import com.epam.issuetracker.ui.layout.MainLayout;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * Main entry point for UI.
 * <p/>
 * Date: 12/11/13
 *
 * @author Mikita_Hladkikh
 */
@Theme("issuetracker")
public class IssueTrackerUi extends UI {

    @Override
    protected void init(VaadinRequest request) {
        MainLayout mainLayout = new MainLayout();
        setContent(mainLayout);
        setSizeFull();
    }
}
