package com.epam.issuetracker.ui.tabs;

import com.epam.issuetracker.ui.layout.IssuesLayout;
import com.epam.issuetracker.ui.layout.ProjectLayout;
import com.vaadin.ui.TabSheet;

/**
 * Created by Mikita_Hladkikh on 12/12/13.
 */
public class MainTabs extends TabSheet {

    public MainTabs() {
        addTab(new ProjectLayout(), "Project");
        addTab(new IssuesLayout(), "Issues");
        setSizeFull();
    }
}
