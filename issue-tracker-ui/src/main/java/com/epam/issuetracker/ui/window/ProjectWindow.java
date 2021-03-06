package com.epam.issuetracker.ui.window;

import com.epam.issuetracker.domain.project.Project;
import com.epam.issuetracker.service.impl.ProjectService;
import com.epam.issuetracker.ui.event.ProjectRefreshEvent;
import com.epam.issuetracker.ui.util.LayoutFactory;
import com.vaadin.data.Validator;
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
    private static final String BLANK_FIELD = "";
    private static final String START_WITH_WHITESPACE = "Name can not start with whitespace symbol";
    private static final String END_WITH_WHITESPACE = "Name can not end with whitespace symbol";
    private static final String NAME_LENGTH = "Length of Name can not exceed 20 symbols";

    static final Method CANCEL_LISTENER = ReflectTools.findMethod(ProjectWindow.class, "onCancelClicked");
    static final Method ADD_LISTENER = ReflectTools.findMethod(ProjectWindow.class, "onSaveClicked");

    private TextField nameTextField = new TextField(NAME_LABEL);
    private TextField shortNameTextField = new TextField(SHORT_NAME_LABEL);
    private TextArea descriptionTextArea = new TextArea(DESCRIPTION_LABEL);

    private Button cancelButton = new Button(CANCEL_BUTTON);
    private Button saveButton = new Button(SAVE_BUTTON);

    private HorizontalLayout buttonsLayout;
    private VerticalLayout windowLayout;

    private ProjectService service = new ProjectService();
    private Project project;


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

    /**
     * Set project data into window fields.
     *
     * @param project
     */
    public void setProjectData(Project project) {
        this.project = project;
        nameTextField.setValue(project.getName());
        shortNameTextField.setValue(project.getShortName());
        descriptionTextArea.setValue(project.getDescription());
    }

    public void setNullProject() {
        project = new Project();
        nameTextField.setValue(BLANK_FIELD);
        shortNameTextField.setValue(BLANK_FIELD);
        descriptionTextArea.setValue(BLANK_FIELD);
    }

    public void refreshTable(Button.ClickEvent event) {
        fireEvent(new ProjectRefreshEvent(this));
    }

    /**
     * Cancel event for cancel button.
     */
    public void onCancelClicked() {
        close();
    }

    /**
     * Save project.
     */
    public void onSaveClicked() {
        project.setName(nameTextField.getValue());
        project.setShortName(shortNameTextField.getValue());
        project.setDescription(descriptionTextArea.getValue());
        service.updateProject(project);
        fireEvent(new ProjectRefreshEvent(this));
        close();
    }

    private void initButtons() {
        cancelButton.addListener(Button.ClickEvent.class, this, CANCEL_LISTENER);
        saveButton.addListener(Button.ClickEvent.class, this, ADD_LISTENER);
        saveButton.setWidth(BUTTON_WIDTH);
        cancelButton.setWidth(BUTTON_WIDTH);
        buttonsLayout = LayoutFactory.createHorizontalLayout(true, true, saveButton, cancelButton);
        buttonsLayout.setComponentAlignment(saveButton, Alignment.MIDDLE_CENTER);
        buttonsLayout.setComponentAlignment(cancelButton, Alignment.MIDDLE_CENTER);
        buttonsLayout.setSizeFull();
    }

    private void initLayout() {
        Validator projectNameValidator = new Validator() {
            public void validate(Object value) {
                if (value.toString().startsWith(" ")) {
                    throw new InvalidValueException(START_WITH_WHITESPACE);
                }
                if (value.toString().endsWith(" ")) {
                    throw new InvalidValueException(END_WITH_WHITESPACE);
                }
                if (value.toString().length() >= 20) {
                    throw new InvalidValueException(NAME_LENGTH);
                }
            }
        };
        nameTextField.setWidth(FIELD_WIDTH);
        nameTextField.addValidator(projectNameValidator);
        nameTextField.setImmediate(true);
        shortNameTextField.setWidth(FIELD_WIDTH);
        descriptionTextArea.setWidth(FIELD_WIDTH);
        VerticalLayout fieldsLayout =
            LayoutFactory.createVerticalLayout(true, true, nameTextField, shortNameTextField, descriptionTextArea);
        windowLayout = LayoutFactory.createVerticalLayout(false, false, fieldsLayout, buttonsLayout);
    }
}
