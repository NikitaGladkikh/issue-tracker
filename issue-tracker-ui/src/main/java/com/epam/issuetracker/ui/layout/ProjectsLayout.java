package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.table.ProjectsTable;
import com.epam.issuetracker.ui.window.ProjectWindow;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Mikita_Hladkikh on 12/12/13.
 */
public class ProjectsLayout extends VerticalLayout {

    public ProjectsLayout() {
        Button addProject = new Button("Add Project");
        addProject.setWidth("100%");
        addProject.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                ProjectWindow sub = new ProjectWindow();
                UI.getCurrent().addWindow(sub);
            }
        });
        ProjectsTable projectsTable = new ProjectsTable();
        addComponents(addProject,projectsTable);
        setSizeFull();
        setExpandRatio(projectsTable, 1.0f);
    }
}
