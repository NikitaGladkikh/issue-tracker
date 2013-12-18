package com.epam.issuetracker.ui.window;

import com.epam.issuetracker.ui.util.LayoutFactory;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;


/**
 * Window to leave the commentButton.
 * <p/>
 * Date: 12/12/13
 *
 * @author Mikita_Hladkikh
 */
public class CommentWindow extends Window {

    private static final String FIELD_WIDTH = "250px";
    private static final String BUTTON_WIDTH = "100px";

    private static final String TXT_COMMENT_LABEL = "Put your comment here:";
    private static final String CANCEL_BUTTON = "Cancel";
    private static final String COMMENT_BUTTON = "Comment";

    private static final String CANCEL_METHOD = "cancelClick";

    static final Method CANCEL_LISTENER = ReflectTools.findMethod(CommentWindow.class, CANCEL_METHOD);

    private TextArea commentTextArea = new TextArea(TXT_COMMENT_LABEL);

    private Button cancelButton = new Button(CANCEL_BUTTON);
    private Button commentButton = new Button(COMMENT_BUTTON);

    private HorizontalLayout buttonsLayout;
    private VerticalLayout windowLayout;

    /**
     * Default constructor.
     */
    public CommentWindow() {
        super(COMMENT_BUTTON);
        center();
        setResizable(false);
        initButtons();
        initLayout();
        setModal(true);
        setContent(windowLayout);
    }

    private void initButtons() {
        cancelButton.addListener(Button.ClickEvent.class, this, CANCEL_LISTENER);
        commentButton.setWidth(BUTTON_WIDTH);
        cancelButton.setWidth(BUTTON_WIDTH);

        buttonsLayout = LayoutFactory.createHorizontalLayout(true, true, commentButton, cancelButton);
        buttonsLayout.setComponentAlignment(commentButton, Alignment.MIDDLE_CENTER);
        buttonsLayout.setComponentAlignment(cancelButton, Alignment.MIDDLE_CENTER);
        buttonsLayout.setSizeFull();
    }

    private void initLayout() {
        commentTextArea.setWidth(FIELD_WIDTH);
        VerticalLayout fieldsLayout = LayoutFactory.createVerticalLayout(true, true, commentTextArea);
        windowLayout = LayoutFactory.createVerticalLayout(false, false, fieldsLayout, buttonsLayout);
    }

    /**
     * Cancel event for cancelButton button.
     */
    public void cancelClick() {
        close();
    }
}
