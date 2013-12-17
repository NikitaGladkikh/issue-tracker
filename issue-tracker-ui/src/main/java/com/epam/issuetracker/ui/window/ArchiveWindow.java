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
 * Window to confirm put the project to archive.
 *
 * @author Mikita_Hladkikh on 12/17/13.
 */
public class ArchiveWindow extends Window {

    private static final String QUESTION = "Do you realy want to put the project into archive?";
    private static final String BUTTON_WIDTH = "100px";

    private static final String CONFIRM = "Confirm";
    private static final String NO = "No";
    private static final String YES = "Yes";

    private static final String CANCEL_METHOD = "cancelClick";

    static final Method CANCEL_LISTENER = ReflectTools.findMethod(ArchiveWindow.class, CANCEL_METHOD);

    private Label question = new Label(QUESTION);

    private Button cancel = new Button(NO);
    private Button confirm = new Button(YES);

    /**
     * Default constructor.
     */
    public ArchiveWindow() {
        super(CONFIRM);
        center();
        setResizable(false);

        VerticalLayout fields = new VerticalLayout();
        fields.addComponents(question);
        fields.setSpacing(true);
        fields.setMargin(true);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSizeFull();
        confirm.setWidth(BUTTON_WIDTH);
        cancel.setWidth(BUTTON_WIDTH);
        buttons.addComponents(confirm, cancel);
        buttons.setComponentAlignment(confirm, Alignment.MIDDLE_CENTER);
        buttons.setComponentAlignment(cancel, Alignment.MIDDLE_CENTER);
        buttons.setSpacing(true);
        buttons.setMargin(true);

        cancel.addListener(Button.ClickEvent.class, this, CANCEL_LISTENER);

        VerticalLayout window = new VerticalLayout();
        window.addComponents(fields, buttons);

        setModal(true);
        setContent(window);
    }

    /**
     * Cancel event for no button.
     */
    public void cancelClick() {
        close();
    }
}
