package com.epam.issuetracker.service.impl;

import com.epam.issuetracker.domain.project.Project;
import com.epam.issuetracker.service.api.IProjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of project service interface.
 * Date: 12/24/13
 *
 * @author Mikita_Hladkikh
 */
public class ProjectService implements IProjectService {

    private static final String NAME = "NAME";
    private static final String SHORT_NAME = "Short Name";
    private static final String DESCRIPTION = "Description";

    private List<Project> projects = buildProjects();

    private List<Project> buildProjects() {
        List<Project> tempProject = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Project project = new Project();
            project.setId(UUID.randomUUID().toString());
            project.setName(NAME);
            project.setShortName(SHORT_NAME);
            project.setDescription(DESCRIPTION);
            tempProject.add(project);
        }
        return tempProject;
    }


    @Override
    public List<Project> getAllProjects() {
        return projects;
    }

    @Override
    public Project getProject(String id) {
        Project project = new Project();
        project.setName(id);
        project.setShortName(id);
        project.setDescription(id);
        return project;
    }

    @Override
    public void updateProject(Project project) {
        projects.add(project);
    }

    @Override
    public void archiveProject(String id) {
        projects.remove(7);
    }
}
