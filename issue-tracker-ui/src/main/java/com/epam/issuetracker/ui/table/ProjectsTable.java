package com.epam.issuetracker.ui.table;

import com.vaadin.ui.Table;

/**
 * Table of all projects.
 *
 * @author Mikita_Hladkikh on 12/12/13.
 */
public class ProjectsTable extends Table {

    private static final String ALL_PROJECTS = "All Projects";
    private static final String PROJECT = "Project_";

    /**
     * Default constructor.
     */
    public ProjectsTable() {
        addContainerProperty(ALL_PROJECTS, String.class, null, ALL_PROJECTS, null, Table.Align.CENTER);
        for (int i = 0; i < 100; i++) {
            addItem(new Object[]{PROJECT + String.valueOf(i)}, i);
        }
        setSelectable(true);
        setSizeFull();
    }
}
