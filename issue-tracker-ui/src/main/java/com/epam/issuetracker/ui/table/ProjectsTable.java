package com.epam.issuetracker.ui.table;

import com.vaadin.ui.Table;

/**
 * Created by Mikita_Hladkikh on 12/12/13.
 */
public class ProjectsTable extends Table {
    public ProjectsTable() {
        addContainerProperty("name", String.class, null, "All Projects", null, Table.Align.CENTER);
        for (int i = 0; i < 100; i++) {
            addItem(new Object[]{"Project " + String.valueOf(i)}, i);
        }
        setSelectable(true);
        setSizeFull();
    }
}
