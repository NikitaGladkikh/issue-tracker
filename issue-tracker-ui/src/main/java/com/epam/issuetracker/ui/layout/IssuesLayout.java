package com.epam.issuetracker.ui.layout;

import com.epam.issuetracker.ui.table.IssuesTable;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Mikita_Hladkikh on 12/12/13.
 */
public class IssuesLayout extends VerticalLayout {

    public IssuesLayout() {
        IssuesTable table = new IssuesTable();
        addComponent(table);
        setSizeFull();
    }
}
