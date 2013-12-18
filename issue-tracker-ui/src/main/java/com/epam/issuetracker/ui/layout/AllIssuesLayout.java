package com.epam.issuetracker.ui.layout;

import com.vaadin.data.Property;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

/**
 * Layout to display table of issues,and add/edit issue.
 * <p/>
 * Date: 12/13/13
 *
 * @author Mikita_Hladkikh
 */
public class AllIssuesLayout extends VerticalLayout {

    private static final String VIEW_ISSUE_BUTTON = "View";
    private static final String VIEW_ISSUES_BUTTON = "Return to list of issues";
    private static final String ADD_ISSUE_BUTTON = "Add Issue";
    private static final String EDIT_ISSUE_BUTTON = "Edit";
    private static final String SAVE_ISSUE_BUTTON = "Save";
    private static final String CANCEL_BUTTON = "Cancel";

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

    private VerticalLayout issuesHeadLayout = new VerticalLayout();
    private VerticalLayout issueHeadLayout = new VerticalLayout();
    private VerticalLayout editLyaout = new VerticalLayout();

    private Button viewIssueButton = new Button(VIEW_ISSUE_BUTTON);
    private Button addIssueButton = new Button(ADD_ISSUE_BUTTON);
    private Button viewIssuesButton = new Button(VIEW_ISSUES_BUTTON);
    private Button editIssueButton = new Button(EDIT_ISSUE_BUTTON);
    private Button saveIssueButton = new Button(SAVE_ISSUE_BUTTON);
    private Button cancelButton = new Button(CANCEL_BUTTON);

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
        addComponents(issuesHeadLayout, issueHeadLayout, editLyaout);
        setSizeFull();
    }

    private void initButtons() {
        viewIssueButton.setEnabled(false);
        editIssueButton.setEnabled(false);

        addIssueButton.setWidth(BUTTON_WIDTH);
        viewIssueButton.setWidth(BUTTON_WIDTH);
        editIssueButton.setWidth(BUTTON_WIDTH);
        cancelButton.setWidth(BUTTON_WIDTH);
        saveIssueButton.setWidth(BUTTON_WIDTH);

        viewIssueButton.addListener(Button.ClickEvent.class, this, DISPLAY_ISSUE_LISTENER);
        addIssueButton.addListener(Button.ClickEvent.class, this, EDIT_ISSUE_LISTENER);
        viewIssuesButton.addListener(Button.ClickEvent.class, this, DISPLAY_ISSUES_LISTENER);
        editIssueButton.addListener(Button.ClickEvent.class, this, EDIT_ISSUE_LISTENER);
        cancelButton.addListener(Button.ClickEvent.class, this, DISPLAY_ISSUES_LISTENER);
    }

    private void initIssuesLayout() {
        issuesLayout.getTableIssues().addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                if (event.getProperty().getValue() != null) {
                    viewIssueButton.setEnabled(true);
                    editIssueButton.setEnabled(true);
                } else {
                    viewIssueButton.setEnabled(false);
                    editIssueButton.setEnabled(false);
                }
            }
        });

        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.addComponents(addIssueButton, viewIssueButton, editIssueButton);
        buttonsLayout.setSpacing(true);
        buttonsLayout.setMargin(true);
        buttonsLayout.setSizeUndefined();

        issuesHeadLayout.addComponents(issuesLayout, buttonsLayout);
        issuesHeadLayout.setSizeFull();
        issuesHeadLayout.setComponentAlignment(buttonsLayout, Alignment.MIDDLE_RIGHT);
        issuesHeadLayout.setExpandRatio(issuesLayout, 1.0f);
    }

    private void initIssueLayout() {
        issueHeadLayout.addComponents(viewIssuesButton, issueLayout);
        issueHeadLayout.setVisible(false);
        issueHeadLayout.setComponentAlignment(viewIssuesButton, Alignment.MIDDLE_RIGHT);
        issueHeadLayout.setSpacing(true);
        issueHeadLayout.setMargin(true);
        issueHeadLayout.setSizeFull();
        issueHeadLayout.setExpandRatio(issueLayout, 1.0f);
    }

    private void initEditLayout() {
        HorizontalLayout editButtonsLayout = new HorizontalLayout();
        editButtonsLayout.addComponents(saveIssueButton, cancelButton);
        editButtonsLayout.setSpacing(true);
        editButtonsLayout.setMargin(true);
        editButtonsLayout.setSizeUndefined();

        editLyaout.addComponents(editIssueLayout, editButtonsLayout);
        editLyaout.setVisible(false);
        editLyaout.setSpacing(true);
        editLyaout.setMargin(true);
        editLyaout.setComponentAlignment(editButtonsLayout, Alignment.BOTTOM_RIGHT);
        editLyaout.setSizeFull();
        editLyaout.setExpandRatio(editIssueLayout, 1.0f);
    }

    public void viewIssue() {
        issuesHeadLayout.setVisible(false);
        issueHeadLayout.setVisible(true);
        editLyaout.setVisible(false);
    }

    public void viewIssues() {
        issuesHeadLayout.setVisible(true);
        issueHeadLayout.setVisible(false);
        editLyaout.setVisible(false);
    }

    public void editIssue() {
        issuesHeadLayout.setVisible(false);
        issueHeadLayout.setVisible(false);
        editLyaout.setVisible(true);
    }
}
