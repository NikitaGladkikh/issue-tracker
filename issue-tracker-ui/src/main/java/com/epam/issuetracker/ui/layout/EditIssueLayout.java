package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.domain.enums.TypeEnum;
import com.epam.issuetracker.domain.issue.Issue;
import com.epam.issuetracker.service.impl.IssueService;
import com.epam.issuetracker.ui.event.IssueSelectedEvent;
import com.epam.issuetracker.ui.util.LayoutFactory;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import java.util.EnumSet;


/**
 * Layout for edit selected issue.
 * <p/>
 * Date: 12/17/13
 *
 * @author Mikita_Hladkikh
 */
public class EditIssueLayout extends VerticalLayout {

    private static final String DETAILS_LABEL = "Details:";
    private static final String TYPE_CAPTION = "Type:";
    private static final String PRIORITY_CAPTION = "Priority:";
    private static final String SEVERITY_CAPTION = "Severity:";
    private static final String STATUS_CAPTION = "Status:";
    private static final String RESOLUTION_CAPTION = "Resolution:";

    private static final String TEXT_FIELD_WIDTH = "100%";

    private VerticalLayout summaryLayout;
    private GridLayout detailsLayout;

    private Label issueKeyLabel = new Label();

    private TextField summaryTextField = new TextField();
    private TextArea descriptionTextArea = new TextArea();

    private Issue issue;
    private IssueService service = new IssueService();

    private ComboBox typeComboBox = new ComboBox(TYPE_CAPTION, EnumSet.allOf(TypeEnum.class));
    private ComboBox priorityComboBox = new ComboBox(PRIORITY_CAPTION, service.getPriorities());
    private ComboBox severityComboBox = new ComboBox(SEVERITY_CAPTION, service.getSeverities());
    private ComboBox statusComboBox = new ComboBox(STATUS_CAPTION, service.getStatuses());
    private ComboBox resolutionComboBox = new ComboBox(RESOLUTION_CAPTION, service.getResolutions());

    private String projectId;

    /**
     * Default constructor.
     */
    public EditIssueLayout() {
        initSummary();
        initDetails();
        addComponents(summaryLayout, detailsLayout);
        setMargin(true);
        setSpacing(true);
        setSizeFull();
    }

    /**
     * Set data from issue to components.
     *
     * @param event
     */
    public void setEditIssueInfo(IssueSelectedEvent event) {
        issue = service.getIssue(event.getIssueId());
        issueKeyLabel.setValue(issue.getKey());
        summaryTextField.setValue(issue.getSummary());
        descriptionTextArea.setValue(issue.getDescription());
        typeComboBox.setValue(issue.getType());
        statusComboBox.setValue(issue.getStatus());
        severityComboBox.setValue(issue.getSeverity());
        priorityComboBox.setValue(issue.getPriority());
        resolutionComboBox.setValue(issue.getResolution());
    }

    /**
     * Save issue.
     */
    public void saveIssue() {
        issue.setSummary(summaryTextField.getValue());
        issue.setDescription(descriptionTextArea.getValue());
        issue.setType((TypeEnum) typeComboBox.getValue());
        issue.setSeverity(severityComboBox.getValue().toString());
        issue.setStatus(statusComboBox.getValue().toString());
        issue.setPriority(priorityComboBox.getValue().toString());
        issue.setResolution(resolutionComboBox.getValue().toString());
        service.updateIssue(issue, projectId);
    }

    /**
     * Clear issue and components.
     */
    public void clearIssue() {
        issue = new Issue();
        summaryTextField.setValue("");
        descriptionTextArea.setValue("");
    }

    /**
     * Set project id.
     *
     * @param projectId id of project.
     */
    void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    private void initSummary() {
        summaryTextField.setWidth(TEXT_FIELD_WIDTH);
        descriptionTextArea.setSizeFull();

        summaryLayout =
            LayoutFactory.createVerticalLayout(true, false, issueKeyLabel, summaryTextField,
                descriptionTextArea);
        summaryLayout.setSizeFull();
        summaryLayout.setExpandRatio(descriptionTextArea, 1.0f);
    }

    private void initDetails() {
        setComboboxProperties();
        detailsLayout = new GridLayout(2, 3);
        detailsLayout.setCaption(DETAILS_LABEL);
        detailsLayout.addComponents(typeComboBox, statusComboBox, priorityComboBox, resolutionComboBox,
            severityComboBox);
        detailsLayout.setSpacing(true);
        detailsLayout.setMargin(true);
        detailsLayout.setSizeUndefined();
    }

    private void setComboboxProperties() {
        typeComboBox.setNullSelectionAllowed(false);
        priorityComboBox.setNullSelectionAllowed(false);
        severityComboBox.setNullSelectionAllowed(false);
        statusComboBox.setNullSelectionAllowed(false);
        resolutionComboBox.setNullSelectionAllowed(false);
        priorityComboBox.setValue(priorityComboBox.getItemIds().iterator().next());
        severityComboBox.setValue(severityComboBox.getItemIds().iterator().next());
        statusComboBox.setValue(statusComboBox.getItemIds().iterator().next());
        resolutionComboBox.setValue(resolutionComboBox.getItemIds().iterator().next());
        typeComboBox.setValue(typeComboBox.getItemIds().iterator().next());
    }
}
