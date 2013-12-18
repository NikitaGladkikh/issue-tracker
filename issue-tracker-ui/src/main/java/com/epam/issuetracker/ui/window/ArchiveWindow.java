package com.epam.issuetracker.ui.window;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

/**
 * Window to confirmButton put the project to archive.
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

    private static final String CANCEL_METHOD = "cancelClick";

    static final Method CANCEL_LISTENER = ReflectTools.findMethod(ArchiveWindow.class, CANCEL_METHOD);

    private Label questionLabel = new Label(QUESTION_LABEL);

    private Button cancelButton = new Button(NO_BUTTON);
    private Button confirmButton = new Button(YES_BUTTON);

    private HorizontalLayout buttonsLayout = new HorizontalLayout();
    private VerticalLayout windowLayout = new VerticalLayout();

    /**
     * Default constructor.
     */
    public ArchiveWindow() {
        super(CONFIRM_LABEL);
        center();
        setResizable(false);
        initButtons();
        initLayout();
        setModal(true);
        setContent(windowLayout);
    }

    private void initButtons() {
        cancelButton.addListener(Button.ClickEvent.class, this, CANCEL_LISTENER);
        confirmButton.setWidth(BUTTON_WIDTH);
        cancelButton.setWidth(BUTTON_WIDTH);
        buttonsLayout.addComponents(confirmButton, cancelButton);
        buttonsLayout.setComponentAlignment(confirmButton, Alignment.MIDDLE_CENTER);
        buttonsLayout.setComponentAlignment(cancelButton, Alignment.MIDDLE_CENTER);
        buttonsLayout.setSpacing(true);
        buttonsLayout.setMargin(true);
        buttonsLayout.setSizeFull();
    }

    private void initLayout() {
        VerticalLayout fieldsLayout = new VerticalLayout();
        fieldsLayout.addComponents(questionLabel);
        fieldsLayout.setSpacing(true);
        fieldsLayout.setMargin(true);
        windowLayout.addComponents(fieldsLayout, buttonsLayout);
    }

    /**
     * Cancel event for no button.
     */
    public void cancelClick() {
        close();
    }
}
