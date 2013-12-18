package com.epam.issuetracker.ui.table;

import com.vaadin.ui.Table;

/**
 * Table to consist all issues.
 * <p/>
 * Date: 12/12/13
 *
 * @author Mikita_Hladkikh
 */
public class IssuesTable extends Table {

    private static final String KEY_HEADER = "key";
    private static final String NAME_HEADER = "summary";
    private static final String PRIORITY_HEADER = "priority";
    private static final String SEVERITY_HEADER = "severity";
    private static final String TYPE_HEADER = "type";
    private static final String STATUS_HEADER = "status";

    private static final String PRJ_KEY_CAPTION = "prj-";
    private static final String PRJ_NAME_CAPTION = "Project_1";
    private static final int COUNT = 100;

    /**
     * Default constructor.
     */
    public IssuesTable() {
        initTable();
        setSizeFull();
        setColumnExpandRatio(NAME_HEADER, 1.0f);
    }

    private void initTable() {
        addContainerProperty(KEY_HEADER, String.class, null, KEY_HEADER, null, Table.Align.CENTER);
        addContainerProperty(NAME_HEADER, String.class, null, NAME_HEADER, null, Table.Align.CENTER);
        addContainerProperty(PRIORITY_HEADER, String.class, null, PRIORITY_HEADER, null, Table.Align.CENTER);
        addContainerProperty(SEVERITY_HEADER, String.class, null, SEVERITY_HEADER, null, Table.Align.CENTER);
        addContainerProperty(TYPE_HEADER, String.class, null, TYPE_HEADER, null, Table.Align.CENTER);
        addContainerProperty(STATUS_HEADER, String.class, null, STATUS_HEADER, null, Table.Align.CENTER);

        setSortEnabled(true);

        for (int i = 0; i < COUNT; i++) {
            addItem(
                new Object[]{PRJ_KEY_CAPTION + String.valueOf(
                    COUNT - i), PRJ_NAME_CAPTION, PRIORITY_HEADER, SEVERITY_HEADER, TYPE_HEADER, STATUS_HEADER},
                i);
        }
        setColumnCollapsingAllowed(true);
        setSelectable(true);
        setImmediate(true);
    }
}
