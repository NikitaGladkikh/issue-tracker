package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.table.IssuesTable;
import com.vaadin.ui.VerticalLayout;

/**
 * Layout to display the table of issues.
 *
 * @author Mikita_Hladkikh on 12/12/13.
 */
public class IssuesLayout extends VerticalLayout {

    private IssuesTable table = new IssuesTable();

    /**
     * Default constructor.
     */
    public IssuesLayout() {
        addComponent(table);
        setSizeFull();
    }

    /**
     * Getter for table of issues.
     *
     * @return
     */
    public IssuesTable getTable() {
        return table;
    }
}
