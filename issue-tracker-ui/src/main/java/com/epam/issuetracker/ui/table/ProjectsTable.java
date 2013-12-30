package com.epam.issuetracker.ui.table;

import com.epam.issuetracker.domain.project.Project;
import com.epam.issuetracker.service.impl.ProjectService;
import com.vaadin.data.util.AbstractBeanContainer;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.Table;

/**
 * Table of all projects.
 * <p/>
 * Date: 12/12/13
 *
 * @author Mikita_Hladkikh
 */
public class ProjectsTable extends Table {

    private ProjectService service = new ProjectService();
    private BeanContainer<String, Project> container = new BeanContainer<>(Project.class);

    private static final String ALL_PROJECTS_HEADER = "All Projects";
    private static final String ID_NAME_COLUMN = "name";

    /**
     * Default constructor.
     */
    public ProjectsTable() {
        initContainer();
        setContainerDataSource(container);
        setColumnHeader(ID_NAME_COLUMN, ALL_PROJECTS_HEADER);
        setVisibleColumns(ID_NAME_COLUMN);
        setColumnAlignment(ID_NAME_COLUMN, Align.CENTER);
        setSelectable(true);
        setImmediate(true);
        setSizeFull();
    }

    private void initContainer() {
        container.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, Project>() {
            @Override
            public String getIdForBean(Project bean) {
                return bean.getId();
            }
        });
        container.addAll(service.getAllProjects());
    }
}
