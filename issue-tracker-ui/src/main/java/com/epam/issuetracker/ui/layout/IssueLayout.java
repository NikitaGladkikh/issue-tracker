package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.domain.comment.Comment;
import com.epam.issuetracker.domain.issue.Issue;
import com.epam.issuetracker.service.impl.IssueService;
import com.epam.issuetracker.ui.event.IssueSelectedEvent;
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
    private static final String DETAILS_LABEL = "Details:";
    private static final String TYPE_LABEL = "type:";
    private static final String PRIORITY_LABEL = "priority:";
    private static final String SEVERITY_LABEL = "severity:";
    private static final String STATUS_LABEL = "statusLabel:";
    private static final String RESOLUTION_LABEL = "resolution:";
    private static final String BUTTON_COMMENT = "Leave Comment";
    private static final String COMMENTS_LABEL = "Comments:";

    private VerticalLayout summaryLayout;
    private VerticalLayout detailsLayout;
    private VerticalLayout commentsLayout;

    private Button leaveCommentButton = new Button(BUTTON_COMMENT);

    static final Method COMMENT_LISTENER = ReflectTools.findMethod(IssueLayout.class, "onLeaveCommentClicked");

    private Label issueKeyLabel = new Label();
    private Label issueSummaryLabel = new Label();
    private Label issueDescriptionLabel = new Label();
    private Label detailsLabel = new Label();
    private Label issueTypeLabel = new Label();
    private Label issuePriorityLabel = new Label();
    private Label issueSeverityLabel = new Label();
    private Label issueStatusLabel = new Label();
    private Label issueResolutionLabel = new Label();
    private VerticalLayout userComment = new VerticalLayout();

    private Issue issue;

    public IssueLayout() {
        init();
    }

    /**
     * Click event for leave comment.
     */
    public void onLeaveCommentClicked() {
        CommentWindow commentWindow = new CommentWindow(issue.getId());
        UI.getCurrent().addWindow(commentWindow);
    }

    /**
     * Set data of issue to labels.
     *
     * @param event
     */
    void setIssueInfo(IssueSelectedEvent event) {
        IssueService service = new IssueService();
        issue = service.getIssue(event.getIssueId());
        issueKeyLabel.setValue(issue.getKey());
        issueSummaryLabel.setValue(issue.getSummary());
        issueDescriptionLabel.setValue(issue.getDescription());
        issueTypeLabel.setValue(issue.getType().toString());
        issuePriorityLabel.setValue(issue.getPriority());
        issueStatusLabel.setValue(issue.getStatus());
        issueSeverityLabel.setValue(issue.getSeverity());
        issueResolutionLabel.setValue(issue.getResolution());
        setComment();
    }

    private void initSummary() {
        issueKeyLabel.setCaption(ISSUE_LABEL);
        summaryLayout =
            LayoutFactory.createVerticalLayout(true, true, issueKeyLabel, issueSummaryLabel, issueDescriptionLabel);
        summaryLayout.setSizeFull();
        summaryLayout.setExpandRatio(issueDescriptionLabel, 1.0f);
    }

    private void initDetails() {
        detailsLabel.setCaption(DETAILS_LABEL);
        issueTypeLabel.setCaption(TYPE_LABEL);
        issuePriorityLabel.setCaption(PRIORITY_LABEL);
        issueSeverityLabel.setCaption(SEVERITY_LABEL);
        issueStatusLabel.setCaption(STATUS_LABEL);
        issueResolutionLabel.setCaption(RESOLUTION_LABEL);
        HorizontalLayout typeLayout =
            LayoutFactory.createHorizontalLayout(true, false, issueTypeLabel, issueStatusLabel);
        typeLayout.setSizeFull();
        HorizontalLayout statusLayout = LayoutFactory.createHorizontalLayout(true, false, issueSeverityLabel,
            issueResolutionLabel);
        statusLayout.setSizeFull();
        detailsLayout =
            LayoutFactory.createVerticalLayout(true, true, detailsLabel, typeLayout, statusLayout, issuePriorityLabel);
        detailsLayout.setSizeFull();
    }

    private void initComments() {
        Label commentsLabel = new Label();
        commentsLabel.setCaption(COMMENTS_LABEL);
        leaveCommentButton.addListener(Button.ClickEvent.class, this, COMMENT_LISTENER);

        userComment.setMargin(false);
        userComment.setSpacing(true);

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

    private void setComment() {
        for (Comment comment : issue.getComments()) {
            VerticalLayout commentLayout = new VerticalLayout();
            commentLayout.addComponents(new Label(comment.getUser()), new Label(comment.getComment()));
            userComment.addComponents(commentLayout);
        }
    }
}
