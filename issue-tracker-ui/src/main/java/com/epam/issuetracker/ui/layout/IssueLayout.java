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

    private VerticalLayout summaryLayout = new VerticalLayout();
    private VerticalLayout detailsLayout = new VerticalLayout();
    private VerticalLayout commentsLayout = new VerticalLayout();

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
        summaryLayout.addComponents(issueKeyLabel, issueSummaryLabel, issueDescriptionLabel);
        summaryLayout.setSpacing(true);
        summaryLayout.setMargin(true);
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
        HorizontalLayout typeLay = setDetailsHorLayout(issueTypeLabel, issueStatusLabel);
        HorizontalLayout statusLay = setDetailsHorLayout(issueSeverityLabel, issueResolutionLabel);
        detailsLayout.addComponents(detailsLabel, typeLay, statusLay, issuePriorityLabel);
        detailsLayout.setSpacing(true);
        detailsLayout.setMargin(true);
        detailsLayout.setSizeFull();
    }

    private void initComments() {
        Label commentsLabel = new Label();
        commentsLabel.setCaption(COMMENTS_LABEL);
        Label userLabel = new Label(USER_LABEL);
        Label commentLabel = new Label(COMMENT_LABEL);

        leaveCommentButton.addListener(Button.ClickEvent.class, this, COMMENT_LISTENER);
        VerticalLayout userComment = addComment(userLabel, commentLabel);

        VerticalLayout allComments = new VerticalLayout();
        allComments.addComponents(userComment, leaveCommentButton);
        allComments.setComponentAlignment(leaveCommentButton, Alignment.MIDDLE_RIGHT);
        allComments.setSpacing(true);
        allComments.setSizeFull();
        allComments.setExpandRatio(userComment, 1.0f);

        commentsLayout.addComponents(commentsLabel, allComments);
        commentsLayout.setSpacing(true);
        commentsLayout.setMargin(true);
        commentsLayout.setSizeFull();
        commentsLayout.setExpandRatio(allComments, 1.0f);
    }

    private void init() {
        initSummary();
        initDetails();
        initComments();

        VerticalLayout issueInfoLayout = new VerticalLayout();
        issueInfoLayout.addComponents(summaryLayout, detailsLayout, commentsLayout);
        issueInfoLayout.setSizeFull();
        issueInfoLayout.setExpandRatio(summaryLayout, 2.0f);
        issueInfoLayout.setExpandRatio(detailsLayout, 1.0f);
        issueInfoLayout.setExpandRatio(commentsLayout, 3.0f);

        addComponent(issueInfoLayout);
    }

    private HorizontalLayout setDetailsHorLayout(Component component1, Component component2) {
        HorizontalLayout newLay = new HorizontalLayout();
        newLay.addComponents(component1, component2);
        newLay.setSpacing(true);
        newLay.setSizeFull();
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
