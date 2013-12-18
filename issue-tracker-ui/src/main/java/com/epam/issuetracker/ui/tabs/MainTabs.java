package com.epam.issuetracker.ui.tabs;

import com.epam.issuetracker.ui.layout.AllIssuesLayout;
import com.epam.issuetracker.ui.layout.ProjectLayout;
import com.vaadin.ui.TabSheet;

/**
 * Main tabsheet to display project and issues tabs.
 * <p/>
 * Date: 12/12/13
 *
 * @author Mikita_Hladkikh
 */
public class MainTabs extends TabSheet {

    private static final String PROJECT_TAB = "Project";
    private static final String ISSUES_TAB = "Issues";

    public MainTabs() {
        addTab(new ProjectLayout(), PROJECT_TAB);
        addTab(new AllIssuesLayout(), ISSUES_TAB);
        setSizeFull();
    }
}
