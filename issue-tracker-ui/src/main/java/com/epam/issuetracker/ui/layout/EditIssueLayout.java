package com.epam.issuetracker.ui.layout;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


/**
 * Layout for edit needed issue.
 * <p/>
 * Date: 12/17/13
 *
 * @author Mikita_Hladkikh
 */
public class EditIssueLayout extends VerticalLayout {

    private static final String ISSUE_LABEL = "ISSUE: ";
    private static final String ISSUE_LABEL_KEY = "prj-007";
    private static final String ISSUE_CAPTION_SUMMARY = "Summary";
    private static final String ISSUE_CAPTION_DESCRIPTION = "Description";

    private static final String DETAILS_LABEL = "Details:";
    private static final String TYPE_CAPTION = "Type:";
    private static final String PRIORITY_CAPTION = "Priority:";
    private static final String SEVERITY_CAPTION = "Severity:";
    private static final String STATUS_CAPTION = "Status:";
    private static final String RESOLUTION_CAPTION = "Resolution:";

    private static final String TEXT_FIELD_WIDTH = "100%";

    private VerticalLayout summaryLayout = new VerticalLayout();
    private VerticalLayout detailsLayout = new VerticalLayout();


    private TextField issueSummaryTextField = new TextField(ISSUE_CAPTION_SUMMARY);
    private TextArea issueDescriptionTextArea = new TextArea(ISSUE_CAPTION_DESCRIPTION);


    private ComboBox typeComboBox = new ComboBox(TYPE_CAPTION);
    private ComboBox priorityComboBox = new ComboBox(PRIORITY_CAPTION);
    private ComboBox severityComboBox = new ComboBox(SEVERITY_CAPTION);
    private ComboBox statusComboBox = new ComboBox(STATUS_CAPTION);
    private ComboBox resolutionComboBox = new ComboBox(RESOLUTION_CAPTION);

    /**
     * Default constructor.
     */
    public EditIssueLayout() {
        initSummary();
        initDetails();

        addComponents(summaryLayout, detailsLayout);
        setSizeFull();
    }

    private void initSummary() {
        Label issueKeyLabel = new Label();
        issueKeyLabel.setCaption(ISSUE_LABEL + ISSUE_LABEL_KEY);
        issueSummaryTextField.setWidth(TEXT_FIELD_WIDTH);
        issueDescriptionTextArea.setSizeFull();

        summaryLayout = new VerticalLayout();
        summaryLayout.addComponents(issueKeyLabel, issueSummaryTextField, issueDescriptionTextArea);
        summaryLayout.setSpacing(true);
        summaryLayout.setMargin(true);
        summaryLayout.setSizeFull();
        summaryLayout.setExpandRatio(issueDescriptionTextArea, 1.0f);
    }

    public void initDetails() {
        HorizontalLayout typeStatusLayout = setDetailsHorLayout(typeComboBox, statusComboBox);
        HorizontalLayout priorityResolutionLayout = setDetailsHorLayout(priorityComboBox, resolutionComboBox);

        Label detailsLabel = new Label();
        detailsLabel.setCaption(DETAILS_LABEL);
        detailsLayout = new VerticalLayout();
        detailsLayout.addComponents(detailsLabel, typeStatusLayout, priorityResolutionLayout, severityComboBox);
        detailsLayout.setSpacing(true);
        detailsLayout.setMargin(true);
        detailsLayout.setSizeFull();
    }

    private HorizontalLayout setDetailsHorLayout(Component component1, Component component2) {
        HorizontalLayout newLayout = new HorizontalLayout();
        newLayout.addComponents(component1, component2);
        newLayout.setSpacing(true);
        newLayout.setSizeFull();
        return newLayout;
    }
}
