package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.event.ProjectSelectedEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;


/**
 * Main layout of the application.
 * <p/>
 * Date: 12/11/13
 *
 * @author Mikita_Hladkikh
 */
public class MainLayout extends VerticalLayout {

    private HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
    private static final String PROJECT_CAPTION = "Project";
    private static final String ISSUES_CAPTION = "Issues";

    /**
     * Default constructor.
     */
    public MainLayout() {
        init();
        addComponent(horizontalSplitPanel);
        setSizeFull();
    }

    private void init() {
        ProjectLayout projectLayout = new ProjectLayout();
        AllIssuesLayout allIssuesLayout = new AllIssuesLayout();
        TabSheet tabSheet = initTabs(projectLayout, allIssuesLayout);
        horizontalSplitPanel.setSplitPosition(20, Unit.PERCENTAGE);
        horizontalSplitPanel.setSizeFull();
        horizontalSplitPanel.setLocked(true);
        ProjectsLayout projectsLayout = new ProjectsLayout();
        projectsLayout.addListener(ProjectSelectedEvent.class, projectLayout, ProjectLayout.PROJECT_EVENT_LISTENER);
        projectsLayout.addListener(ProjectSelectedEvent.class, allIssuesLayout, AllIssuesLayout.REFRESH_ISSUES_LISTENER);
        horizontalSplitPanel.setFirstComponent(projectsLayout);
        horizontalSplitPanel.setSecondComponent(tabSheet);
    }

    private TabSheet initTabs(VerticalLayout projectLayuot, VerticalLayout allIssuesLayout) {
        TabSheet tabs = new TabSheet();
        tabs.addTab(projectLayuot, PROJECT_CAPTION);
        tabs.addTab(allIssuesLayout, ISSUES_CAPTION);
        tabs.setSizeFull();
        return tabs;
    }
}
