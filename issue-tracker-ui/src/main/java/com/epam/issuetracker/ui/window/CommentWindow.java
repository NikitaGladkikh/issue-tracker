package com.epam.issuetracker.ui.window;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;


/**
 * Window to leave the comment.
 *
 * @author Mikita_Hladkikh on 12/12/13.
 */
public class CommentWindow extends Window {

    private static final String FIELD_WIDTH = "250px";
    private static final String BUTTON_WIDTH = "100px";

    private static final String TXT_COMMENT = "Text";
    private static final String CANCEL = "Cancel";
    private static final String COMMENT = "Comment";

    private static final String CANCEL_METHOD = "cancelClick";

    static final Method CANCEL_LISTENER = ReflectTools.findMethod(CommentWindow.class, CANCEL_METHOD);

    private TextArea txtComment = new TextArea(TXT_COMMENT);

    private Button cancel = new Button(CANCEL);
    private Button comment = new Button(COMMENT);

    /**
     * Default constructor.
     */
    public CommentWindow() {
        super(COMMENT);
        center();
        setResizable(false);

        txtComment.setWidth(FIELD_WIDTH);

        VerticalLayout fields = new VerticalLayout();
        fields.addComponents(txtComment);
        fields.setSpacing(true);
        fields.setMargin(true);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSizeFull();
        comment.setWidth(BUTTON_WIDTH);
        cancel.setWidth(BUTTON_WIDTH);
        buttons.addComponents(comment, cancel);
        buttons.setComponentAlignment(comment, Alignment.MIDDLE_CENTER);
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
     * Cancel event for cancel button.
     */
    public void cancelClick() {
        close();
    }
}
