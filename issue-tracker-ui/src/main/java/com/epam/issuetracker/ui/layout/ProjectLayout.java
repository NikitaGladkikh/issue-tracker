package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.domain.project.Project;
import com.epam.issuetracker.service.impl.ProjectService;
import com.epam.issuetracker.ui.event.ProjectRefreshEvent;
import com.epam.issuetracker.ui.event.ProjectSelectedEvent;
import com.epam.issuetracker.ui.util.LayoutFactory;
import com.epam.issuetracker.ui.window.ArchiveWindow;
import com.epam.issuetracker.ui.window.ProjectWindow;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

/**
 * Layout to display information about project.
 * <p/>
 * Date: 12/12/13
 *
 * @author Mikita_Hladkikh
 */
public class ProjectLayout extends VerticalLayout {

    private static final String NAME_LABEL = "Name:";
    private static final String SHORT_NAME_LABEL = "Short Name:";
    private static final String DESCRIPTION_LABEL = "Description:";
    private static final String BLANK_FIELD = "";

    private static final String EDIT_BUTTON = "Edit";
    private static final String DELETE_BUTTON = "Archive";

    private static final String BUTTON_WIDTH = "100px";

    private Label projectNameLabel = new Label();
    private Label projectShortNameLabel = new Label();
    private Label projectDescriptionLabel = new Label();

    private Button editButton = new Button(EDIT_BUTTON);
    private Button deleteButton = new Button(DELETE_BUTTON);

    static final Method EDIT_CLICK_LISTENER = ReflectTools.findMethod(ProjectLayout.class, "onEditProjectClicked");
    static final Method DELETE_CLICK_LISTENER = ReflectTools.findMethod(ProjectLayout.class, "onArchiveProjectClicked");
    static final Method PROJECT_REFRESH_LISTENER = ReflectTools.findMethod(ProjectLayout.class, "refreshProjectTable",
        ProjectRefreshEvent.class);
    static final Method PROJECT_EVENT_LISTENER =
        ReflectTools.findMethod(ProjectLayout.class, "setProjectInfo", ProjectSelectedEvent.class);

    private Project project = new Project();
    private ProjectService service = new ProjectService();
    private ProjectWindow projectWindow = new ProjectWindow();
    private ArchiveWindow archiveWindow = new ArchiveWindow();

    /**
     * Default constructor.
     */
    public ProjectLayout() {
        init();
    }

    /**
     * Click event for editButton button.
     */
    public void onEditProjectClicked() {
        projectWindow.setProjectData(project);
        UI.getCurrent().addWindow(projectWindow);
    }

    public void refreshProjectTable(ProjectRefreshEvent event) {
        fireEvent(event);
        refreshLayout();
    }

    /**
     * Click event for archive button.
     */
    public void onArchiveProjectClicked() {
        archiveWindow.setProjectId(project.getId());
        UI.getCurrent().addWindow(archiveWindow);
    }

    /**
     * Set data for labels of selected project
     *
     * @param event of selected project.
     */
    public void setProjectInfo(ProjectSelectedEvent event) {
        project = service.getProject(event.getProjectId());
        projectNameLabel.setValue(project.getName());
        projectShortNameLabel.setValue(project.getShortName());
        projectDescriptionLabel.setValue(project.getDescription());
    }

    private void init() {
        editButton.addListener(Button.ClickEvent.class, this, EDIT_CLICK_LISTENER);
        editButton.setWidth(BUTTON_WIDTH);
        deleteButton.addListener(Button.ClickEvent.class, this, DELETE_CLICK_LISTENER);
        deleteButton.setWidth(BUTTON_WIDTH);
        initLayouts();
        projectWindow.addListener(ProjectRefreshEvent.class, this, PROJECT_REFRESH_LISTENER);
        archiveWindow.addListener(ProjectRefreshEvent.class, this, PROJECT_REFRESH_LISTENER);
    }

    private void initLayouts() {
        projectNameLabel.setCaption(NAME_LABEL);
        projectShortNameLabel.setCaption(SHORT_NAME_LABEL);
        projectDescriptionLabel.setCaption(DESCRIPTION_LABEL);
        HorizontalLayout buttonsLayout = LayoutFactory.createHorizontalLayout(true, true, editButton, deleteButton);
        buttonsLayout.setSizeUndefined();
        addComponents(projectNameLabel, projectShortNameLabel, projectDescriptionLabel, buttonsLayout);
        setComponentAlignment(buttonsLayout, Alignment.BOTTOM_RIGHT);
        setSpacing(true);
        setMargin(true);
        setSizeFull();
        setExpandRatio(projectNameLabel, 1.0f);
        setExpandRatio(projectShortNameLabel, 1.0f);
        setExpandRatio(projectDescriptionLabel, 10.0f);
        setExpandRatio(buttonsLayout, 1.0f);
    }

    private void refreshLayout() {
        project = service.getProject(project.getId());
        if (null != project) {
            projectNameLabel.setValue(project.getName());
            projectShortNameLabel.setValue(project.getShortName());
            projectDescriptionLabel.setValue(project.getDescription());
        } else {
            projectNameLabel.setValue(BLANK_FIELD);
            projectShortNameLabel.setValue(BLANK_FIELD);
            projectDescriptionLabel.setValue(BLANK_FIELD);
        }
    }
}
