package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.event.IssueSelectedEvent;
import com.epam.issuetracker.ui.event.ProjectSelectedEvent;
import com.epam.issuetracker.ui.table.IssuesTable;
import com.epam.issuetracker.ui.util.LayoutFactory;
import com.vaadin.data.Property;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.util.ReflectTools;

import java.lang.reflect.Method;

/**
 * Layout to display table of issues, and layouts with viewing and editing selected issue.
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

    private static final String BUTTON_WIDTH = "100px";
    static final Method DISPLAY_ISSUE_LISTENER = ReflectTools.findMethod(AllIssuesLayout.class, "onViewClicked");
    static final Method DISPLAY_ISSUES_LISTENER = ReflectTools.findMethod(AllIssuesLayout.class, "onReturnClicked");
    static final Method ADD_ISSUE_LISTENER = ReflectTools.findMethod(AllIssuesLayout.class, "onAddIssueClicked");
    static final Method EDIT_ISSUE_LISTENER = ReflectTools.findMethod(AllIssuesLayout.class, "onEditIssueClicked");
    static final Method SAVE_ISSUE_LISTENER = ReflectTools.findMethod(AllIssuesLayout.class, "onSaveIssueClicked");
    static final Method REFRESH_TABLE_LISTENER = ReflectTools.findMethod(AllIssuesLayout.class, "refreshContainer",
        ProjectSelectedEvent.class);

    private IssueLayout issueLayout = new IssueLayout();
    private EditIssueLayout editIssueLayout = new EditIssueLayout();

    private VerticalLayout issuesHeadLayout;
    private VerticalLayout issueHeadLayout;
    private VerticalLayout editLayout;

    private Button viewIssueButton = new Button(VIEW_ISSUE_BUTTON);
    private Button addIssueButton = new Button(ADD_ISSUE_BUTTON);
    private Button viewIssuesButton = new Button(VIEW_ISSUES_BUTTON);
    private Button editIssueButton = new Button(EDIT_ISSUE_BUTTON);
    private Button saveIssueButton = new Button(SAVE_ISSUE_BUTTON);
    private Button cancelButton = new Button(CANCEL_BUTTON);

    private IssueSelectedEvent issueSelectedEvent;
    private IssuesTable issuesTable = new IssuesTable();

    public void refreshContainer(ProjectSelectedEvent event) {
        issuesTable.refresh(event);
    }

    /**
     * Default constructor.
     */
    public AllIssuesLayout() {
        initButtons();
        init();
    }

    /**
     * Display layout with issue info.
     */
    public void onViewClicked() {
        issuesHeadLayout.setVisible(false);
        issueHeadLayout.setVisible(true);
        editLayout.setVisible(false);
        issueLayout.setIssueInfo(issueSelectedEvent);
    }

    /**
     * Display layout with table of issues.
     */
    public void onReturnClicked() {
        issuesHeadLayout.setVisible(true);
        issueHeadLayout.setVisible(false);
        editLayout.setVisible(false);
    }

    /**
     * Display layout for edit issue.
     */
    public void onEditIssueClicked() {
        issuesHeadLayout.setVisible(false);
        issueHeadLayout.setVisible(false);
        editLayout.setVisible(true);
        editIssueLayout.setEditIssueInfo(issueSelectedEvent);
    }

    /**
     * Create issue event basic on ValueChangeEvent.
     *
     * @param event
     */
    public void issueSelect(Property.ValueChangeEvent event) {
        fireEvent(new IssueSelectedEvent(this, event.getProperty().getValue().toString()));
    }

    /**
     * Display layout for add issue.
     */
    public void onAddIssueClicked() {
        issuesHeadLayout.setVisible(false);
        issueHeadLayout.setVisible(false);
        editLayout.setVisible(true);
        editIssueLayout.clearIssue();
    }

    /**
     * Save issue.
     */
    public void onSaveIssueClicked() {
        editIssueLayout.saveIssue();
        onReturnClicked();
    }

    /**
     * Add issue selected listener to component.
     *
     * @param listener
     */
    public void addIssueSelectedListener(IssueSelectedListener listener) {
        addListener(IssueSelectedEvent.class, listener, IssueSelectedListener.ISSUE_SELECT);
    }

    /**
     * Represents interface for issue selected listener.
     */
    public interface IssueSelectedListener {
        Method ISSUE_SELECT =
            ReflectTools.findMethod(IssueSelectedListener.class, "issueSelect", IssueSelectedEvent.class);

        void issueSelect(IssueSelectedEvent event);
    }

    private void init() {
        initIssuesLayout();
        initIssueLayout();
        initEditLayout();
        addComponents(issuesHeadLayout, issueHeadLayout, editLayout);
        setSizeFull();
        addIssueSelectedListener(new IssueSelectedListener() {
            @Override
            public void issueSelect(IssueSelectedEvent event) {
                issueSelectedEvent = event;
                boolean enabled = null != issueSelectedEvent.getIssueId();
                viewIssueButton.setEnabled(enabled);
                editIssueButton.setEnabled(enabled);
            }
        });
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
        addIssueButton.addListener(Button.ClickEvent.class, this, ADD_ISSUE_LISTENER);
        viewIssuesButton.addListener(Button.ClickEvent.class, this, DISPLAY_ISSUES_LISTENER);
        editIssueButton.addListener(Button.ClickEvent.class, this, EDIT_ISSUE_LISTENER);
        cancelButton.addListener(Button.ClickEvent.class, this, DISPLAY_ISSUES_LISTENER);
        saveIssueButton.addListener(Button.ClickEvent.class, this, SAVE_ISSUE_LISTENER);
    }

    private void initIssuesLayout() {

        issuesTable.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                if (null != event.getProperty().getValue()) {
                    fireEvent(new IssueSelectedEvent(AllIssuesLayout.this, event.getProperty().getValue().toString()));
                } else {
                    fireEvent(new IssueSelectedEvent(AllIssuesLayout.this, null));
                }
            }
        });
        HorizontalLayout buttonsLayout =
            LayoutFactory.createHorizontalLayout(true, true, addIssueButton, viewIssueButton, editIssueButton);
        buttonsLayout.setSizeUndefined();

        issuesHeadLayout = LayoutFactory.createVerticalLayout(false, false, issuesTable, buttonsLayout);
        issuesHeadLayout.setSizeFull();
        issuesHeadLayout.setComponentAlignment(buttonsLayout, Alignment.BOTTOM_RIGHT);
        issuesHeadLayout.setExpandRatio(issuesTable, 1.0f);
    }

    private void initIssueLayout() {
        issueHeadLayout = LayoutFactory.createVerticalLayout(true, true, viewIssuesButton, issueLayout);
        issueHeadLayout.setVisible(false);
        issueHeadLayout.setComponentAlignment(viewIssuesButton, Alignment.BOTTOM_RIGHT);
        issueHeadLayout.setSizeFull();
        issueHeadLayout.setExpandRatio(issueLayout, 1.0f);
    }

    private void initEditLayout() {
        HorizontalLayout editButtonsLayout =
            LayoutFactory.createHorizontalLayout(true, true, saveIssueButton, cancelButton);
        editButtonsLayout.setSpacing(true);
        editButtonsLayout.setMargin(true);
        editButtonsLayout.setSizeUndefined();

        editLayout = LayoutFactory.createVerticalLayout(false, false, editIssueLayout, editButtonsLayout);
        editLayout.setVisible(false);
        editLayout.setComponentAlignment(editButtonsLayout, Alignment.BOTTOM_RIGHT);
        editLayout.setSizeFull();
        editLayout.setExpandRatio(editIssueLayout, 1.0f);
    }
}
