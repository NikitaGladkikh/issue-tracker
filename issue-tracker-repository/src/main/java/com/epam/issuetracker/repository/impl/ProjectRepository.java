package com.epam.issuetracker.repository.impl;

import com.epam.issuetracker.domain.project.Project;
import com.epam.issuetracker.repository.api.IProjectInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of project repository interface.
 * <p/>
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public class ProjectRepository implements IProjectInterface {

    private static final String NAME = "NAME";
    private static final String SHORT_NAME = "Short Name";
    private static final String DESCRIPTION = "Description";

    private List<Project> projects = buildProjects();

    @Override
    public List<Project> findAllProjects() {
        return projects;
    }

    @Override
    public Project findProject(String projectId) {
        Project project = new Project();
        project.setName(projectId);
        project.setShortName(projectId);
        project.setDescription(projectId);
        return project;
    }

    @Override
    public void insertProject(Project project) {
        projects.add(project);
    }

    @Override
    public void updateProject(Project project) {
        projects.add(project);
    }

    @Override
    public void archiveProject(String projectId) {
        projects.remove(7);
    }

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
}
