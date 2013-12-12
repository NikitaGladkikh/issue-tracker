package com.epam.issuetracker.ui.table;

import com.vaadin.ui.Table;

/**
 * Created by Mikita_Hladkikh on 12/12/13.
 */
public class IssuesTable extends Table {

    public IssuesTable() {

        addContainerProperty("№", Integer.class, null, "№", null, Table.Align.CENTER);
        addContainerProperty("short name", String.class, null, "SHORT NAME", null, Table.Align.CENTER);
        addContainerProperty("name", String.class, null, "NAME", null, Table.Align.CENTER);
        addContainerProperty("priority", String.class, null, "PRIORITY", null, Table.Align.CENTER);
        addContainerProperty("severity", String.class, null, "SEVERITY", null, Table.Align.CENTER);
        addContainerProperty("type ", String.class, null, "TYPE", null, Table.Align.CENTER);
        addContainerProperty("status", String.class, null, "STATUS", null, Table.Align.CENTER);
        setSortEnabled(true);

        for (int i = 0; i < 100; i++) {
            addItem(new Object[]{i, "prj-" + String.valueOf(100 - i), "Project_1", "priority", "severity", "type", "status"}, i);
        }
        setColumnCollapsingAllowed(true);
        setColumnCollapsed("born", true);
        setSelectable(true);
        setImmediate(true);

        setSizeFull();
    }
}
