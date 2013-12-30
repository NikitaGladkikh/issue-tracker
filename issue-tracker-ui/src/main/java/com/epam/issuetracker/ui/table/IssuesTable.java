package com.epam.issuetracker.ui.table;

import com.epam.issuetracker.domain.enums.TypeEnum;
import com.epam.issuetracker.domain.issue.Issue;
import com.epam.issuetracker.service.impl.IssueService;
import com.epam.issuetracker.ui.event.ProjectSelectedEvent;
import com.vaadin.data.Item;
import com.vaadin.data.util.AbstractBeanContainer;
import com.vaadin.data.util.BeanContainer;
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

    private IssueService service = new IssueService();
    private BeanContainer<String, Issue> container = new BeanContainer<>(Issue.class);


    /**
     * Default constructor.
     */
    public IssuesTable() {
        initTable();
        setSizeFull();
        setColumnExpandRatio(NAME_HEADER, 1.0f);
    }

    /**
     * Refresh data of container.
     *
     * @param event
     */
    public void refresh(ProjectSelectedEvent event) {
        container.removeAllItems();
        if (null != event.getProjectId()) {
            container.addAll(service.getAllIssues(event.getProjectId()));
        }
    }

    private void initTable() {
        initContainer();
        setContainerDataSource(container);
        setVisibleColumns(KEY_HEADER, NAME_HEADER, PRIORITY_HEADER, SEVERITY_HEADER, TYPE_HEADER, STATUS_HEADER);
        setSortEnabled(true);
        setColumnCollapsingAllowed(true);
        setSelectable(true);
        setImmediate(true);
        setColumnAlignment(TYPE_HEADER, Align.CENTER);


        setCellStyleGenerator(new CellStyleGenerator() {
            @Override
            public String getStyle(Table source, Object itemId, Object propertyId) {
                Item item = getItem(itemId);
                if ("type".equals(propertyId)) {
                    for (TypeEnum type : TypeEnum.values()) {
                        if (type.equals(item.getItemProperty("type").getValue())) {
                            return type.getType();
                        }
                    }
                }
                return null;
            }
        });
        addGeneratedColumn("type", new ColumnGenerator() {
            @Override
            public Object generateCell(Table source, Object itemId, Object columnId) {
                Item item = getItem(itemId);
                for (TypeEnum type : TypeEnum.values()) {
                    if (type.equals(item.getItemProperty("type").getValue())) {
                        return type.getType().toUpperCase().charAt(0);
                    }
                }
                return null;
            }
        });

    }

    private void initContainer() {
        container.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, Issue>() {
            @Override
            public String getIdForBean(Issue bean) {
                return bean.getId();
            }
        });
    }
}
