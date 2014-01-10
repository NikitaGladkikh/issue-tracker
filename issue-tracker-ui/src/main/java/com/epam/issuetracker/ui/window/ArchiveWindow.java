package com.epam.issuetracker.ui.window;

import com.epam.issuetracker.service.impl.ProjectService;
import com.epam.issuetracker.ui.event.ProjectRefreshEvent;
import com.epam.issuetracker.ui.util.LayoutFactory;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

/**
 * Window to archiveButton put the project to archive.
 * <p/>
 * Date: 12/17/13
 *
 * @author Mikita_Hladkikh
 */
public class ArchiveWindow extends Window {

    private static final String QUESTION_LABEL = "Do you realy want to put the project into archive?";
    private static final String BUTTON_WIDTH = "100px";

    private static final String CONFIRM_LABEL = "Confirm";
    private static final String NO_BUTTON = "No";
    private static final String YES_BUTTON = "Yes";

    static final Method CANCEL_LISTENER = ReflectTools.findMethod(ArchiveWindow.class, "onCancelClicked");
    static final Method ARCHIVE_LISTENER = ReflectTools.findMethod(ArchiveWindow.class, "onArchiveClicked");

    private Label questionLabel = new Label(QUESTION_LABEL);

    private Button cancelButton = new Button(NO_BUTTON);
    private Button archiveButton = new Button(YES_BUTTON);

    private HorizontalLayout buttonsLayout;
    private VerticalLayout windowLayout;
    private ProjectService service = new ProjectService();
    private String projectId;

    public ArchiveWindow() {
        super(CONFIRM_LABEL);
        center();
        setResizable(false);
        initButtons();
        initLayout();
        setModal(true);
        setContent(windowLayout);
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * Cancel event for no button.
     */
    public void onCancelClicked() {
        close();
    }

    /**
     * Archive event for yes button.
     */
    public void onArchiveClicked() {
        service.archiveProject(projectId);
        fireEvent(new ProjectRefreshEvent(this));
        close();
    }

    private void initButtons() {
        cancelButton.addListener(Button.ClickEvent.class, this, CANCEL_LISTENER);
        archiveButton.addListener(Button.ClickEvent.class, this, ARCHIVE_LISTENER);
        archiveButton.setWidth(BUTTON_WIDTH);
        cancelButton.setWidth(BUTTON_WIDTH);
        buttonsLayout = LayoutFactory.createHorizontalLayout(true, true, archiveButton, cancelButton);
        buttonsLayout.setComponentAlignment(archiveButton, Alignment.MIDDLE_CENTER);
        buttonsLayout.setComponentAlignment(cancelButton, Alignment.MIDDLE_CENTER);
        buttonsLayout.setSizeFull();
    }

    private void initLayout() {
        VerticalLayout fieldsLayout = LayoutFactory.createVerticalLayout(true, true, questionLabel);
        windowLayout = LayoutFactory.createVerticalLayout(false, false, fieldsLayout, buttonsLayout);
    }
}
