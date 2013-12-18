package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.table.IssuesTable;
import com.vaadin.ui.VerticalLayout;

/**
 * Layout to display the tableIssues of issues.
 * <p/>
 * Date: 12/12/13
 *
 * @author Mikita_Hladkikh
 */
public class IssuesLayout extends VerticalLayout {

    private IssuesTable tableIssues = new IssuesTable();

    /**
     * Default constructor.
     */
    public IssuesLayout() {
        addComponent(tableIssues);
        setSizeFull();
    }

    /**
     * Getter for tableIssues of issues.
     *
     * @return
     */
    public IssuesTable getTableIssues() {
        return tableIssues;
    }
}
