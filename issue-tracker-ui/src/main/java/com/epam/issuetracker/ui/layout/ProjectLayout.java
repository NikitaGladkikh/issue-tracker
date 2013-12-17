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
 *
 * @author Mikita_Hladkikh on 12/12/13.
 */
public class ProjectLayout extends VerticalLayout {

    private static final String LABEL_NAME = "Name:";
    private static final String LABEL_SHORT_NAME = "Short Name:";
    private static final String LABEL_DESCRIPTION = "Description:";
    private static final String EDIT_METHOD = "editClick";
    private static final String DELETE_METHOD = "deleteClick";

    private static final String BUTTON_EDIT = "Edit";
    private static final String DELETE_BUTTON = "Archive";

    private static final String PRJ_NAME = "Project_1";
    private static final String PRJ_SHORT_NAME = "prj_1";
    private static final String PRJ_DESCRIPTION = "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 Project_1 " +
        "Project_1 Project_1 Project_1 Project_1 vv";

    private static final String BUTTON_WIDTH = "100px";

    private Label prjName = new Label();
    private Label prjShortName = new Label();
    private Label prjDescription = new Label();
    private Label name;
    private Label shortName;
    private Label description;


    private Button edit = new Button(BUTTON_EDIT);
    private Button delete = new Button(DELETE_BUTTON);

    static final Method EDIT_CLICK_LISTENER = ReflectTools.findMethod(ProjectLayout.class, EDIT_METHOD);
    static final Method DELETE_CLICK_LISTENER = ReflectTools.findMethod(ProjectLayout.class, DELETE_METHOD);

    /**
     * Default constructor.
     */
    public ProjectLayout() {
        init();

        edit.addListener(Button.ClickEvent.class, this, EDIT_CLICK_LISTENER);
        edit.setWidth(BUTTON_WIDTH);
        delete.addListener(Button.ClickEvent.class, this, DELETE_CLICK_LISTENER);
        delete.setWidth(BUTTON_WIDTH);

        prjName.setValue(PRJ_NAME);
        prjShortName.setValue(PRJ_SHORT_NAME);

        initLayouts();
    }

    private void init() {
        name = new Label(LABEL_NAME);
        shortName = new Label(LABEL_SHORT_NAME);
        description = new Label(LABEL_DESCRIPTION);
    }

    private void initLayouts() {
        prjDescription.setValue(PRJ_DESCRIPTION);

        VerticalLayout layName = newVerLayout(name, prjName);
        layName.setSizeUndefined();

        VerticalLayout layShortName = newVerLayout(shortName, prjShortName);
        layShortName.setSizeUndefined();

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponents(edit, delete);
        buttons.setSpacing(true);
        buttons.setMargin(true);
        buttons.setSizeUndefined();

        VerticalLayout vDescription = newVerLayout(description, prjDescription);

        addComponents(layName, layShortName, vDescription, buttons);
        setComponentAlignment(buttons, Alignment.MIDDLE_RIGHT);
        setSizeFull();
        setExpandRatio(layName, 1.0f);
        setExpandRatio(layShortName, 1.0f);
        setExpandRatio(vDescription, 10.0f);
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
     * Click event for edit button.
     */
    public void editClick() {
        ProjectWindow sub = new ProjectWindow(prjName.getValue(), prjShortName.getValue(), prjDescription.getValue());
        UI.getCurrent().addWindow(sub);
    }

    /**
     * Click event for archive button.
     */
    public void deleteClick() {
        ArchiveWindow sub = new ArchiveWindow();
        UI.getCurrent().addWindow(sub);
    }
}
