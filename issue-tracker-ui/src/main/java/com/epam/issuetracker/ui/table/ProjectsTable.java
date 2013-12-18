package com.epam.issuetracker.ui.table;

import com.vaadin.ui.Table;

/**
 * Table of all projects.
 * <p/>
 * Date: 12/12/13
 *
 * @author Mikita_Hladkikh
 */
public class ProjectsTable extends Table {

    private static final String ALL_PROJECTS_HEADER = "All Projects";
    private static final String PROJECT_CAPTION = "Project_";

    /**
     * Default constructor.
     */
    public ProjectsTable() {
        addContainerProperty(ALL_PROJECTS_HEADER, String.class, null, ALL_PROJECTS_HEADER, null, Table.Align.CENTER);
        for (int i = 0; i < 100; i++) {
            addItem(new Object[]{PROJECT_CAPTION + String.valueOf(i)}, i);
        }
        setSelectable(true);
        setSizeFull();
    }
}
