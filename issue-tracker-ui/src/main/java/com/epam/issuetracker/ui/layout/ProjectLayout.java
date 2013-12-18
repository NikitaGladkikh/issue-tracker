package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.window.ArchiveWindow;
import com.epam.issuetracker.ui.window.ProjectWindow;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
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
    private static final String EDIT_METHOD = "editClick";
    private static final String DELETE_METHOD = "deleteClick";

    private static final String EDIT_BUTTON = "Edit";
    private static final String DELETE_BUTTON = "Archive";

    private static final String PRJ_NAME_LABEL = "Project_1";
    private static final String PRJ_SHORT_NAME_LABEL = "prj_1";
    private static final String PRJ_DESCRIPTION_LABEL = "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 vv";

    private static final String BUTTON_WIDTH = "100px";

    private Label prjNameLabel = new Label();
    private Label prjShortNameLabel = new Label();
    private Label prjDescriptionLabel = new Label();

    private Button editButton = new Button(EDIT_BUTTON);
    private Button deleteButton = new Button(DELETE_BUTTON);

    static final Method EDIT_CLICK_LISTENER = ReflectTools.findMethod(ProjectLayout.class, EDIT_METHOD);
    static final Method DELETE_CLICK_LISTENER = ReflectTools.findMethod(ProjectLayout.class, DELETE_METHOD);

    /**
     * Default constructor.
     */
    public ProjectLayout() {
        init();
    }

    private void init() {
        editButton.addListener(Button.ClickEvent.class, this, EDIT_CLICK_LISTENER);
        editButton.setWidth(BUTTON_WIDTH);
        deleteButton.addListener(Button.ClickEvent.class, this, DELETE_CLICK_LISTENER);
        deleteButton.setWidth(BUTTON_WIDTH);
        initLayouts();
    }

    private void initLayouts() {
        prjNameLabel.setValue(PRJ_NAME_LABEL);
        prjNameLabel.setCaption(NAME_LABEL);
        prjShortNameLabel.setValue(PRJ_SHORT_NAME_LABEL);
        prjShortNameLabel.setCaption(SHORT_NAME_LABEL);
        prjDescriptionLabel.setValue(PRJ_DESCRIPTION_LABEL);
        prjDescriptionLabel.setCaption(DESCRIPTION_LABEL);


        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponents(editButton, deleteButton);
        buttons.setSpacing(true);
        buttons.setMargin(true);
        buttons.setSizeUndefined();

        addComponents(prjNameLabel, prjShortNameLabel, prjDescriptionLabel, buttons);
        setComponentAlignment(buttons, Alignment.MIDDLE_RIGHT);
        setSpacing(true);
        setMargin(true);
        setSizeFull();
        setExpandRatio(prjNameLabel, 1.0f);
        setExpandRatio(prjShortNameLabel, 1.0f);
        setExpandRatio(prjDescriptionLabel, 10.0f);
        setExpandRatio(buttons, 1.0f);
    }

    private VerticalLayout newVerLayout(Component component1, Component component2) {
        VerticalLayout ver = new VerticalLayout();
        ver.addComponent(component1);
        ver.addComponent(component2);
        ver.setSpacing(true);
        ver.setMargin(true);
        return ver;
    }

    /**
     * Click event for editButton button.
     */
    public void editClick() {
        ProjectWindow projectWindow =
            new ProjectWindow(prjNameLabel.getValue(), prjShortNameLabel.getValue(), prjDescriptionLabel
                .getValue());
        UI.getCurrent().addWindow(projectWindow);
    }

    /**
     * Click event for archive button.
     */
    public void deleteClick() {
        ArchiveWindow archiveWindow = new ArchiveWindow();
        UI.getCurrent().addWindow(archiveWindow);
    }
}
