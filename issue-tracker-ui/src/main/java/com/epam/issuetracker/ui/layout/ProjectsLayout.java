package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.table.ProjectsTable;
import com.epam.issuetracker.ui.window.ProjectWindow;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

/**
 * Layout to display section view of all projects.
 *
 * @author Mikita_Hladkikh on 12/12/13.
 */
public class ProjectsLayout extends VerticalLayout {

    private static final String BUTTON_WIDTH = "100%";
    private static final String BUTTON_ADD = "Add Project";

    private static final String ADD_METHOD = "addClick";

    static final Method ADD_CLICK_LISTENER = ReflectTools.findMethod(ProjectsLayout.class, ADD_METHOD);

    /**
     * Default constructor.
     */
    public ProjectsLayout() {
        Button addProject = new Button(BUTTON_ADD);
        addProject.setWidth(BUTTON_WIDTH);
        addProject.addListener(Button.ClickEvent.class, this, ADD_CLICK_LISTENER);
        ProjectsTable projectsTable = new ProjectsTable();
        addComponents(addProject, projectsTable);
        setSizeFull();
        setExpandRatio(projectsTable, 1.0f);
    }

    /**
     * Click event for add project button.
     */
    public void addClick() {
        ProjectWindow sub = new ProjectWindow();
        UI.getCurrent().addWindow(sub);
    }
}
