package com.epam.issuetracker.ui.tabs;

import com.epam.issuetracker.ui.layout.AllIssuesLayout;
import com.epam.issuetracker.ui.layout.ProjectLayout;
import com.vaadin.ui.TabSheet;

/**
 * Main tabsheet to display project and issues tabs.
 *
 * @author Mikita_Hladkikh on 12/12/13.
 */
public class MainTabs extends TabSheet {

    private static final String PROJECT = "Project";
    private static final String ISSUES = "Issues";

    public MainTabs() {
        addTab(new ProjectLayout(), PROJECT);
        addTab(new AllIssuesLayout(), ISSUES);
        setSizeFull();
    }
}
