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
 *
 * @author Mikita_Hladkikh on 12/12/13.
 */
public class ProjectWindow extends Window {

    private static final String FIELD_WIDTH = "250px";
    private static final String BUTTON_WIDTH = "100px";

    private static final String NAME = "Name";
    private static final String SHORT_NAME = "Short Name";
    private static final String DESCRIPTION = "Description";
    private static final String CANCEL = "Cancel";
    private static final String SAVE = "Save";
    private static final String PROJECT = "Project";

    private static final String CANCEL_METHOD = "cancelClick";

    static final Method ADD_CANCEL_LISTENER = ReflectTools.findMethod(ProjectWindow.class, CANCEL_METHOD);

    private TextField name = new TextField(NAME);
    private TextField shortName = new TextField(SHORT_NAME);
    private TextArea description = new TextArea(DESCRIPTION);

    private Button cancel = new Button(CANCEL);
    private Button save = new Button(SAVE);

    /**
     * Default constructor.
     */
    public ProjectWindow() {
        super(PROJECT);
        center();
        setResizable(false);

        name.setWidth(FIELD_WIDTH);
        shortName.setWidth(FIELD_WIDTH);
        description.setWidth(FIELD_WIDTH);

        VerticalLayout fields = new VerticalLayout();
        fields.addComponents(name, shortName, description);
        fields.setSpacing(true);
        fields.setMargin(true);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSizeFull();
        save.setWidth(BUTTON_WIDTH);
        cancel.setWidth(BUTTON_WIDTH);
        buttons.addComponents(save, cancel);
        buttons.setComponentAlignment(save, Alignment.MIDDLE_CENTER);
        buttons.setComponentAlignment(cancel, Alignment.MIDDLE_CENTER);
        buttons.setSpacing(true);
        buttons.setMargin(true);

        cancel.addListener(Button.ClickEvent.class, this, ADD_CANCEL_LISTENER);

        VerticalLayout window = new VerticalLayout();
        window.addComponents(fields, buttons);

        setModal(true);
        setContent(window);
    }

    /**
     * Constructs new window based on name, short name and description.
     *
     * @param name
     * @param shortName
     * @param description
     */
    public ProjectWindow(String name, String shortName, String description) {
        this();
        this.name.setValue(name);
        this.shortName.setValue(shortName);
        this.description.setValue(description);
    }


    /**
     * Cancel event for cancel button.
     */
    public void cancelClick() {
        close();
    }
}
