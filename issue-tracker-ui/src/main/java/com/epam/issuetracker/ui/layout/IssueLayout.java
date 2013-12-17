package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.window.CommentWindow;
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
 * @author Mikita_Hladkikh on 12/13/13.
 */
public class IssueLayout extends VerticalLayout {

    private static final String ISSUE = "ISSUE: ";
    private static final String ISS_NUMBER = "prj-007";
    private static final String ISS_SUMMARY =
        "Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue";
    private static final String ISS_DESC =
        "Description Description Description Description Description Description Description" +
            " Description Description Description Description Description Description Description" +
            " Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description " +
            " Description Description Description Description Description Description Description" +
            " Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description " +
            " Description Description Description Description Description Description Description" +
            " Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description " +
            "Description Description Description Description Description Description Description ";


    private static final String DETAILS = "Details:";
    private static final String TYPE = "type:";
    private static final String ISS_TYPE = "bug";
    private static final String PRIORITY = "priority:";
    private static final String ISS_PRIORITY = "high";
    private static final String SEVERITY = "severity:";
    private static final String STATUS = "status:";
    private static final String ISS_STATUS = "closed";
    private static final String RESOLUTION = "resolution:";
    private static final String USER = "User###";
    private static final String BUTTON_COMMENT = "Leave Comment";

    private static final String COMMENTS = "Comments:";
    private static final String COMMENT =
        "It's will be...I think...It's will be...I think...It's will be...I think...It's " +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think..." +
            "will be...I think...It's will be...I think...It's will be...I think...It's will be..." +
            "I think...It's will be...I think...It's will be...I think...";

    private Label issNumb = new Label(ISSUE + ISS_NUMBER);
    private Label issSummary = new Label(ISS_SUMMARY);
    private Label issDesc = new Label(ISS_DESC);
    private Label details = new Label(DETAILS);
    private Label type = new Label(TYPE);
    private Label issType = new Label(ISS_TYPE);
    private Label priority = new Label(PRIORITY);
    private Label issPriority = new Label(ISS_PRIORITY);
    private Label severity = new Label(SEVERITY);
    private Label issSeverity = new Label(SEVERITY);
    private Label status = new Label(STATUS);
    private Label issStatus = new Label(ISS_STATUS);
    private Label resolution = new Label(RESOLUTION);
    private Label issResolution = new Label(RESOLUTION);
    private Label comments = new Label(COMMENTS);
    private Label userCom = new Label(USER);
    private Label comment = new Label(COMMENT);

    private VerticalLayout summary = new VerticalLayout();
    private VerticalLayout detailsLay = new VerticalLayout();
    private VerticalLayout commentsLay = new VerticalLayout();

    private Button leaveComment = new Button(BUTTON_COMMENT);

    private static final String COMMENT_METHOD = "commentClick";
    static final Method COMMENT_LISTENER = ReflectTools.findMethod(IssueLayout.class, COMMENT_METHOD);

    public IssueLayout() {
        init();
    }

    private void initSummary() {
        summary = new VerticalLayout();
        summary.addComponents(issNumb, issSummary, issDesc);
        summary.setSpacing(true);
        summary.setMargin(true);
        summary.setSizeFull();
        summary.setExpandRatio(issDesc, 1.0f);
    }

    private void initDetails() {
        HorizontalLayout typeLay = setDetailsHorLayout(type, issType);
        HorizontalLayout statusLay = setDetailsHorLayout(status, issStatus);
        HorizontalLayout priorityLay = setDetailsHorLayout(priority, issPriority);
        HorizontalLayout resolutionLay = setDetailsHorLayout(resolution, issResolution);
        HorizontalLayout severityLay = setDetailsHorLayout(severity, issSeverity);

        HorizontalLayout typeStatus = setHorLayout(typeLay, statusLay);
        HorizontalLayout priorityReso = setHorLayout(priorityLay, resolutionLay);

        detailsLay = new VerticalLayout();
        detailsLay.addComponents(details, typeStatus, priorityReso, severityLay);
        detailsLay.setSpacing(true);
        detailsLay.setMargin(true);
        detailsLay.setSizeFull();
    }

    private void initComments() {
        leaveComment.addListener(Button.ClickEvent.class, this, COMMENT_LISTENER);
        VerticalLayout userComment = addComment(userCom, comment);

        VerticalLayout allComments = new VerticalLayout();
        allComments.addComponents(userComment, leaveComment);
        allComments.setComponentAlignment(leaveComment, Alignment.MIDDLE_RIGHT);
        allComments.setSpacing(true);
        allComments.setSizeFull();
        allComments.setExpandRatio(userComment, 1.0f);


        commentsLay.addComponents(comments, allComments);
        commentsLay.setSpacing(true);
        commentsLay.setMargin(true);
        commentsLay.setSizeFull();
        commentsLay.setExpandRatio(allComments, 1.0f);
    }

    private void init() {
        initSummary();
        initDetails();
        initComments();

        VerticalLayout issueInfo = new VerticalLayout();
        issueInfo.addComponents(summary, detailsLay, commentsLay);
        issueInfo.setSizeFull();
        issueInfo.setExpandRatio(summary, 2.0f);
        issueInfo.setExpandRatio(detailsLay, 1.0f);
        issueInfo.setExpandRatio(commentsLay, 3.0f);

        addComponent(issueInfo);
    }

    private HorizontalLayout setDetailsHorLayout(Component component1, Component component2) {
        HorizontalLayout newLay = new HorizontalLayout();
        newLay.addComponents(component1, component2);
        newLay.setSpacing(true);
        newLay.setSizeUndefined();
        return newLay;
    }

    private HorizontalLayout setHorLayout(Component component1, Component component2) {
        HorizontalLayout newLay = new HorizontalLayout();
        newLay.addComponents(component1, component2);
        newLay.setSpacing(true);
        newLay.setSizeFull();
        return newLay;
    }

    private VerticalLayout addComment(Component comp1, Component comp2) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponents(comp1, comp2);
        verticalLayout.setSpacing(true);
        verticalLayout.setSizeFull();
        return verticalLayout;
    }

    /**
     * Click event for leave comment.
     */
    public void commentClick() {
        CommentWindow sub = new CommentWindow();
        UI.getCurrent().addWindow(sub);
    }
}
