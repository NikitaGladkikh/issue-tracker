package com.epam.issuetracker.ui.layout;

import com.vaadin.data.Property;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

/**
 * Layout to display table of issues and selected issue.
 *
 * @author Mikita_Hladkikh on 12/13/13.
 */
public class AllIssuesLayout extends VerticalLayout {

    private static final String VIEW_ISSUE = "View";
    private static final String VIEW_ISSUES = "Return to list of issues";
    private static final String ADD_ISSUE = "Add Issue";
    private static final String EDIT_ISSUE = "Edit";
    private static final String SAVE_ISSUE = "Save";
    private static final String CANCEL = "Cancel";

    private static final String VIEW_ISSUE_METHOD = "viewIssue";
    private static final String VIEW_ISSUES_METHOD = "viewIssues";
    private static final String EDIT_ISSUE_METHOD = "editIssue";

    private static final String BUTTON_WIDTH = "100px";

    static final Method DISPLAY_ISSUE_LISTENER = ReflectTools.findMethod(AllIssuesLayout.class, VIEW_ISSUE_METHOD);
    static final Method DISPLAY_ISSUES_LISTENER = ReflectTools.findMethod(AllIssuesLayout.class, VIEW_ISSUES_METHOD);
    static final Method EDIT_ISSUE_LISTENER = ReflectTools.findMethod(AllIssuesLayout.class, EDIT_ISSUE_METHOD);


    private IssuesLayout issuesLayout = new IssuesLayout();
    private IssueLayout issueLayout = new IssueLayout();
    private EditIssueLayout editIssueLayout = new EditIssueLayout();

    private VerticalLayout issues = new VerticalLayout();
    private VerticalLayout issue = new VerticalLayout();
    private VerticalLayout edit = new VerticalLayout();

    private Button viewIssue = new Button(VIEW_ISSUE);
    private Button addIssue = new Button(ADD_ISSUE);
    private Button viewIssues = new Button(VIEW_ISSUES);
    private Button editIssue = new Button(EDIT_ISSUE);
    private Button saveIssue = new Button(SAVE_ISSUE);
    private Button cancel = new Button(CANCEL);

    /**
     * Default constructor.
     */
    public AllIssuesLayout() {
        initButtons();
        init();
    }

    private void init() {
        initIssuesLayout();
        initIssueLayout();
        initEditLayout();

        addComponents(issues, issue, edit);
        setSizeFull();
    }

    private void initButtons() {
        viewIssue.setEnabled(false);
        editIssue.setEnabled(false);

        addIssue.setWidth(BUTTON_WIDTH);
        viewIssue.setWidth(BUTTON_WIDTH);
        editIssue.setWidth(BUTTON_WIDTH);
        cancel.setWidth(BUTTON_WIDTH);
        saveIssue.setWidth(BUTTON_WIDTH);

        viewIssue.addListener(Button.ClickEvent.class, this, DISPLAY_ISSUE_LISTENER);
        addIssue.addListener(Button.ClickEvent.class, this, EDIT_ISSUE_LISTENER);
        viewIssues.addListener(Button.ClickEvent.class, this, DISPLAY_ISSUES_LISTENER);
        editIssue.addListener(Button.ClickEvent.class, this, EDIT_ISSUE_LISTENER);
        cancel.addListener(Button.ClickEvent.class, this, DISPLAY_ISSUES_LISTENER);
    }

    private void initIssuesLayout() {
        issuesLayout.getTable().addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                if (event.getProperty().getValue() != null) {
                    viewIssue.setEnabled(true);
                    editIssue.setEnabled(true);
                } else {
                    viewIssue.setEnabled(false);
                    editIssue.setEnabled(false);
                }
            }
        });

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponents(addIssue, viewIssue, editIssue);
        buttons.setSpacing(true);
        buttons.setMargin(true);
        buttons.setSizeUndefined();

        issues.addComponents(issuesLayout, buttons);
        issues.setSizeFull();
        issues.setComponentAlignment(buttons, Alignment.MIDDLE_RIGHT);
        issues.setExpandRatio(issuesLayout, 1.0f);
    }

    private void initIssueLayout() {
        issue.addComponents(viewIssues, issueLayout);
        issue.setVisible(false);
        issue.setComponentAlignment(viewIssues, Alignment.MIDDLE_RIGHT);
        issue.setSpacing(true);
        issue.setMargin(true);
        issue.setSizeFull();
        issue.setExpandRatio(issueLayout, 1.0f);
    }

    private void initEditLayout() {
        HorizontalLayout editbuttons = new HorizontalLayout();
        editbuttons.addComponents(saveIssue, cancel);
        editbuttons.setSpacing(true);
        editbuttons.setMargin(true);
        editbuttons.setSizeUndefined();

        edit.addComponents(editIssueLayout, editbuttons);
        edit.setVisible(false);
        edit.setSpacing(true);
        edit.setMargin(true);
        edit.setComponentAlignment(editbuttons, Alignment.BOTTOM_RIGHT);
        edit.setSizeFull();
        edit.setExpandRatio(editIssueLayout, 1.0f);
    }

    public void viewIssue() {
        issues.setVisible(false);
        issue.setVisible(true);
        edit.setVisible(false);
    }

    public void viewIssues() {
        issues.setVisible(true);
        issue.setVisible(false);
        edit.setVisible(false);
    }

    public void editIssue() {
        issues.setVisible(false);
        issue.setVisible(false);
        edit.setVisible(true);
    }
}
