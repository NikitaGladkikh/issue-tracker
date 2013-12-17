package com.epam.issuetracker.ui.table;

import com.vaadin.ui.Table;

/**
 * Table to consist all issues.
 *
 * @author Mikita_Hladkikh on 12/12/13.
 */
public class IssuesTable extends Table {


    private static final String KEY = "key";
    private static final String NAME = "summary";
    private static final String PRIORITY = "priority";
    private static final String SEVERITY = "severity";
    private static final String TYPE = "type";
    private static final String STATUS = "status";

    private static final String PRJ_KEY = "prj-";
    private static final String PRJ_NAME = "Project_1";

    private static final int COUNT = 100;

    /**
     * Default constructor.
     */
    public IssuesTable() {

        addContainerProperty(KEY, String.class, null, KEY, null, Table.Align.CENTER);
        addContainerProperty(NAME, String.class, null, NAME, null, Table.Align.CENTER);
        addContainerProperty(PRIORITY, String.class, null, PRIORITY, null, Table.Align.CENTER);
        addContainerProperty(SEVERITY, String.class, null, SEVERITY, null, Table.Align.CENTER);
        addContainerProperty(TYPE, String.class, null, TYPE, null, Table.Align.CENTER);
        addContainerProperty(STATUS, String.class, null, STATUS, null, Table.Align.CENTER);

        setSortEnabled(true);


        for (int i = 0; i < COUNT; i++) {
            addItem(
                new Object[]{PRJ_KEY + String.valueOf(COUNT - i), PRJ_NAME, PRIORITY, SEVERITY, TYPE, STATUS},
                i);
        }
        setColumnCollapsingAllowed(true);
        setSelectable(true);
        setImmediate(true);

        setSizeFull();
        setColumnExpandRatio(NAME, 1.0f);
    }
}
