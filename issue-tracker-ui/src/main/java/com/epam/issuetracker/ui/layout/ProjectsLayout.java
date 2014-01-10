package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.event.ProjectRefreshEvent;
import com.epam.issuetracker.ui.event.ProjectSelectedEvent;
import com.epam.issuetracker.ui.table.ProjectsTable;
import com.epam.issuetracker.ui.window.ProjectWindow;
import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

/**
 * Layout to display section view of all projects.
 * <p/>
 * Date: 12/12/13
 *
 * @author Mikita_Hladkikh
 */
public class ProjectsLayout extends VerticalLayout {

    private static final String BUTTON_WIDTH = "100%";
    private static final String BUTTON_ADD = "Add Project";

    static final Method ADD_CLICK = ReflectTools.findMethod(ProjectsLayout.class, "onAddProjectClicked");
    static final Method PROJECT_CLICK = ReflectTools.findMethod(ProjectsLayout.class, "selectProject",
        Property.ValueChangeEvent.class);

    static final Method PROJECT_REFRESH_LISTENER = ReflectTools.findMethod(ProjectsLayout.class, "refreshTable",
        ProjectRefreshEvent.class);
    private ProjectsTable projectsTable = new ProjectsTable();
    private ProjectWindow projectWindow = new ProjectWindow();

    /**
     * Default constructor.
     */
    public ProjectsLayout() {
        init();
    }

    public void refreshTable(ProjectRefreshEvent event) {
        projectsTable.refreshContainer();
    }

    /**
     * Click event for add project button.
     */
    public void onAddProjectClicked() {
        projectWindow.setNullProject();
        UI.getCurrent().addWindow(projectWindow);

    }

    /**
     * Create event of selected project.
     *
     * @param event of selected project in table.
     */
    public void selectProject(Property.ValueChangeEvent event) {
        if (null != event.getProperty().getValue()) {
            fireEvent(new ProjectSelectedEvent(this, event.getProperty().getValue().toString()));
        } else {
            fireEvent(new ProjectSelectedEvent(this, null));
        }
    }

    private void init() {
        projectWindow.addListener(ProjectRefreshEvent.class, this, PROJECT_REFRESH_LISTENER);
        Button addProjectButton = new Button(BUTTON_ADD);
        addProjectButton.setWidth(BUTTON_WIDTH);
        addProjectButton.addListener(Button.ClickEvent.class, this, ADD_CLICK);
        projectsTable.addListener(Property.ValueChangeEvent.class, this, PROJECT_CLICK);
        addComponents(addProjectButton, projectsTable);
        setSizeFull();
        setExpandRatio(projectsTable, 1.0f);

    }
}
