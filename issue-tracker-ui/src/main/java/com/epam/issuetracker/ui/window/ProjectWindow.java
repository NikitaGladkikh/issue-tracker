package com.epam.issuetracker.ui.window;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;


/**
 * Window to add/edit project.
 * <p/>
 * Date: 12/12/13
 *
 * @author Mikita_Hladkikh
 */
public class ProjectWindow extends Window {

    private static final String FIELD_WIDTH = "250px";
    private static final String BUTTON_WIDTH = "100px";

    private static final String NAME_LABEL = "Name";
    private static final String SHORT_NAME_LABEL = "Short Name";
    private static final String DESCRIPTION_LABEL = "Description";
    private static final String CANCEL_BUTTON = "Cancel";
    private static final String SAVE_BUTTON = "Save";
    private static final String PROJECT_LABEL = "Project";

    private static final String CANCEL_METHOD = "cancelClick";

    static final Method ADD_CANCEL_LISTENER = ReflectTools.findMethod(ProjectWindow.class, CANCEL_METHOD);

    private TextField nameTextField = new TextField(NAME_LABEL);
    private TextField shortNameTextField = new TextField(SHORT_NAME_LABEL);
    private TextArea descriptionTextArea = new TextArea(DESCRIPTION_LABEL);

    private Button cancelButton = new Button(CANCEL_BUTTON);
    private Button saveButton = new Button(SAVE_BUTTON);

    private HorizontalLayout buttonsLayout = new HorizontalLayout();
    private VerticalLayout windowLayout = new VerticalLayout();

    /**
     * Default constructor.
     */
    public ProjectWindow() {
        super(PROJECT_LABEL);
        center();
        setResizable(false);
        initButtons();
        initLayout();
        setModal(true);
        setContent(windowLayout);
    }

    private void initButtons() {
        cancelButton.addListener(Button.ClickEvent.class, this, ADD_CANCEL_LISTENER);
        buttonsLayout.setSizeFull();
        saveButton.setWidth(BUTTON_WIDTH);
        cancelButton.setWidth(BUTTON_WIDTH);
        buttonsLayout.addComponents(saveButton, cancelButton);
        buttonsLayout.setComponentAlignment(saveButton, Alignment.MIDDLE_CENTER);
        buttonsLayout.setComponentAlignment(cancelButton, Alignment.MIDDLE_CENTER);
        buttonsLayout.setSpacing(true);
        buttonsLayout.setMargin(true);
    }

    private void initLayout() {
        nameTextField.setWidth(FIELD_WIDTH);
        shortNameTextField.setWidth(FIELD_WIDTH);
        descriptionTextArea.setWidth(FIELD_WIDTH);
        VerticalLayout fieldsLayout = new VerticalLayout();
        fieldsLayout.addComponents(nameTextField, shortNameTextField, descriptionTextArea);
        fieldsLayout.setSpacing(true);
        fieldsLayout.setMargin(true);
        windowLayout.addComponents(fieldsLayout, buttonsLayout);
    }

    /**
     * Constructs new window based on name, short name and description.
     *
     * @param name        of the project
     * @param shortName   of the project
     * @param description of the project
     */
    // TODO: Replace arguments with domain object
    public ProjectWindow(String name, String shortName, String description) {
        this();
        this.nameTextField.setValue(name);
        this.shortNameTextField.setValue(shortName);
        this.descriptionTextArea.setValue(description);
    }

    /**
     * Cancel event for cancel button.
     */
    public void cancelClick() {
        close();
    }
}
