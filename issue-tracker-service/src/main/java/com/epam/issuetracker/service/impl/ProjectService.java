package com.epam.issuetracker.service.impl;

import com.epam.issuetracker.domain.project.Project;
import com.epam.issuetracker.repository.impl.ProjectRepository;
import com.epam.issuetracker.service.api.IProjectService;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of project service interface.
 * Date: 12/24/13
 *
 * @author Mikita_Hladkikh
 */
public class ProjectService implements IProjectService {

    private ProjectRepository repository = new ProjectRepository();

    @Override
    public List<Project> getAllProjects() {
        return repository.findAllProjects();
    }

    @Override
    public Project getProject(String id) {
        return repository.findProject(id);
    }

    @Override
    public void updateProject(Project project) {
        if (null == project.getId()) {
            project.setId(UUID.randomUUID().toString());
            repository.insertProject(project);
        } else {
            repository.updateProject(project);
        }
    }

    @Override
    public void archiveProject(String id) {
        repository.archiveProject(id);
    }

    public void setProjectRepository(ProjectRepository repository) {
        this.repository = repository;
    }
}
