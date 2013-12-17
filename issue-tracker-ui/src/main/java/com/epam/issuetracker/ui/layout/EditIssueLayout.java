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
 *
 * @author Mikita_Hladkikh on 12/17/13.
 */
public class EditIssueLayout extends VerticalLayout {

    private static final String ISSUE = "ISSUE: ";
    private static final String ISS_NUMBER = "prj-007";
    private static final String ISS_SUMMARY = "Summary";
    private static final String ISS_DESC = "Description";

    private static final String DETAILS = "Details:";
    private static final String TYPE = "Type:";
    private static final String PRIORITY = "Priority:";
    private static final String SEVERITY = "Severity:";
    private static final String STATUS = "Status:";
    private static final String RESOLUTION = "Resolution:";

    private static final String TEXT_FIELD_WIDTH = "100%";
    private static final String TEXT_AREA_HEIGHT = "200px";

    private VerticalLayout summary = new VerticalLayout();
    private VerticalLayout detailsLay = new VerticalLayout();

    private Label issNumb = new Label(ISSUE + ISS_NUMBER);
    private TextField issSummary = new TextField(ISS_SUMMARY);
    private TextArea issDesc = new TextArea(ISS_DESC);

    private Label details = new Label(DETAILS);

    private ComboBox type = new ComboBox(TYPE);
    private ComboBox priority = new ComboBox(PRIORITY);
    private ComboBox severity = new ComboBox(SEVERITY);
    private ComboBox status = new ComboBox(STATUS);
    private ComboBox resolution = new ComboBox(RESOLUTION);

    /**
     * Default constructor.
     */
    public EditIssueLayout() {
        initSummary();
        initDetails();

        addComponents(summary, detailsLay);
        setSizeFull();
    }

    private void initSummary() {

        issSummary.setWidth(TEXT_FIELD_WIDTH);

        issDesc.setSizeFull();

        summary = new VerticalLayout();
        summary.addComponents(issNumb, issSummary, issDesc);
        summary.setSpacing(true);
        summary.setMargin(true);
        summary.setSizeFull();
        summary.setExpandRatio(issDesc, 1.0f);
    }

    public void initDetails() {
        HorizontalLayout typeStatus = setDetailsHorLayout(type, status);
        HorizontalLayout priorityReso = setDetailsHorLayout(priority, resolution);

        detailsLay = new VerticalLayout();
        detailsLay.addComponents(details, typeStatus, priorityReso, severity);
        detailsLay.setSpacing(true);
        detailsLay.setMargin(true);
        detailsLay.setSizeFull();
    }

    private HorizontalLayout setDetailsHorLayout(Component component1, Component component2) {
        HorizontalLayout newLay = new HorizontalLayout();
        newLay.addComponents(component1, component2);
        newLay.setSpacing(true);
        newLay.setSizeFull();
        return newLay;
    }

}
