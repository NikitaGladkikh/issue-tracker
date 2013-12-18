package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.util.LayoutFactory;
import com.epam.issuetracker.ui.window.CommentWindow;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

/**
 * Layout for display info about issue.
 * <p/>
 * Date: 12/13/13
 *
 * @author Mikita_Hladkikh
 */
public class IssueLayout extends VerticalLayout {

    private static final String ISSUE_LABEL = "ISSUE: ";
    private static final String ISSUE_KEY_LABEL = "prj-007";
    private static final String ISSUE_SUMMARY_LABEL =
        "Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue Issue";
    private static final String ISSUE_DESCRIPTION_LABEl =
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

    private static final String DETAILS_LABEL = "Details:";
    private static final String TYPE_LABEL = "typeLabel:";
    private static final String ISSUE_TYPE_LABEL = "bug";
    private static final String PRIORITY_LABEL = "priorityLabel:";
    private static final String ISSUE_PRIORITY_LABEL = "high";
    private static final String SEVERITY_LABEL = "severityLabel:";
    private static final String STATUS_LABEL = "statusLabel:";
    private static final String ISSUE_STATUS_LABEL = "closed";
    private static final String RESOLUTION_LABEL = "resolutionLabel:";
    private static final String USER_LABEL = "User###";
    private static final String BUTTON_COMMENT = "Leave Comment";

    private static final String COMMENTS_LABEL = "Comments:";
    private static final String COMMENT_LABEL =
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

    private VerticalLayout summaryLayout;
    private VerticalLayout detailsLayout;
    private VerticalLayout commentsLayout;

    private Button leaveCommentButton = new Button(BUTTON_COMMENT);

    private static final String COMMENT_METHOD = "commentClick";
    static final Method COMMENT_LISTENER = ReflectTools.findMethod(IssueLayout.class, COMMENT_METHOD);

    public IssueLayout() {
        init();
    }

    private void initSummary() {
        Label issueKeyLabel = new Label(ISSUE_KEY_LABEL);
        issueKeyLabel.setCaption(ISSUE_LABEL);
        Label issueSummaryLabel = new Label(ISSUE_SUMMARY_LABEL);
        Label issueDescriptionLabel = new Label(ISSUE_DESCRIPTION_LABEl);

        summaryLayout =
            LayoutFactory.createVerticalLayout(true, true, issueKeyLabel, issueSummaryLabel, issueDescriptionLabel);
        summaryLayout.setSizeFull();
        summaryLayout.setExpandRatio(issueDescriptionLabel, 1.0f);
    }

    private void initDetails() {
        Label detailsLabel = new Label();
        detailsLabel.setCaption(DETAILS_LABEL);
        Label issueTypeLabel = new Label(ISSUE_TYPE_LABEL);
        issueTypeLabel.setCaption(TYPE_LABEL);
        Label issuePriorityLabel = new Label(ISSUE_PRIORITY_LABEL);
        issuePriorityLabel.setCaption(PRIORITY_LABEL);
        Label issueSeverityLabel = new Label(SEVERITY_LABEL);
        issueSeverityLabel.setCaption(SEVERITY_LABEL);
        Label issueStatusLabel = new Label(ISSUE_STATUS_LABEL);
        issueStatusLabel.setCaption(STATUS_LABEL);
        Label issueResolutionLabel = new Label(RESOLUTION_LABEL);
        issueResolutionLabel.setCaption(RESOLUTION_LABEL);
        HorizontalLayout typeLay = LayoutFactory.createHorizontalLayout(true, false, issueTypeLabel, issueStatusLabel);
        typeLay.setSizeFull();
        HorizontalLayout statusLay = LayoutFactory.createHorizontalLayout(true, false, issueSeverityLabel,
            issueResolutionLabel);
        statusLay.setSizeFull();
        detailsLayout =
            LayoutFactory.createVerticalLayout(true, true, detailsLabel, typeLay, statusLay, issuePriorityLabel);
        detailsLayout.setSizeFull();
    }

    private void initComments() {
        Label commentsLabel = new Label();
        commentsLabel.setCaption(COMMENTS_LABEL);
        Label userLabel = new Label(USER_LABEL);
        Label commentLabel = new Label(COMMENT_LABEL);

        leaveCommentButton.addListener(Button.ClickEvent.class, this, COMMENT_LISTENER);
        VerticalLayout userComment = LayoutFactory.createVerticalLayout(true, false, userLabel, commentLabel);

        VerticalLayout allCommentsLayout =
            LayoutFactory.createVerticalLayout(true, false, userComment, leaveCommentButton);
        allCommentsLayout.setComponentAlignment(leaveCommentButton, Alignment.BOTTOM_RIGHT);
        allCommentsLayout.setSizeFull();
        allCommentsLayout.setExpandRatio(userComment, 1.0f);

        commentsLayout = LayoutFactory.createVerticalLayout(true, true, commentsLabel, allCommentsLayout);
        commentsLayout.setSizeFull();
        commentsLayout.setExpandRatio(allCommentsLayout, 1.0f);
    }

    private void init() {
        initSummary();
        initDetails();
        initComments();

        VerticalLayout issueInfoLayout =
            LayoutFactory.createVerticalLayout(false, false, summaryLayout, detailsLayout, commentsLayout);
        issueInfoLayout.setSizeFull();
        issueInfoLayout.setExpandRatio(summaryLayout, 2.0f);
        issueInfoLayout.setExpandRatio(detailsLayout, 1.0f);
        issueInfoLayout.setExpandRatio(commentsLayout, 3.0f);
        addComponent(issueInfoLayout);
    }

    /**
     * Click event for leave comment.
     */
    public void commentClick() {
        CommentWindow commentWindow = new CommentWindow();
        UI.getCurrent().addWindow(commentWindow);
    }
}
