package com.epam.issuetracker.repository.api;

import com.epam.issuetracker.domain.project.Project;

import java.util.List;

/**
 * Represents interface of repository for projects.
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public interface IProjectRepository {

    /**
     * Find all projects.
     *
     * @return list of projects.
     */
    List<Project> findAllProjects();

    /**
     * Find project by id.
     * @param projectId id of project.
     * @return project.
     */
    Project findProject(String projectId);
    /**
     * Insert new project.
     *
     * @param project instance of project.
     */
    void insertProject(Project project);

    /**
     * Update selected project.
     *
     * @param project instance of project.
     */
    void updateProject(Project project);

    /**
     * Archive selected project
     *
     * @param projectId id of project.
     */
    void archiveProject(String projectId);
}
