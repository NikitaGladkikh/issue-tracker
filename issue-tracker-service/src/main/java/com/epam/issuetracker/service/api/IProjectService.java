package com.epam.issuetracker.service.api;

import com.epam.issuetracker.domain.project.Project;

import java.util.List;

/**
 * Represents interface for project logic.
 * Date: 12/24/13
 *
 * @author Mikita_Hladkikh
 */
public interface IProjectService {

    /**
     * Get list of all projects.
     *
     * @return list of projects.
     */
    List<Project> getAllProjects();

    /**
     * Get project.
     *
     * @param id of project.
     * @return project.
     */
    Project getProject(String id);

    /**
     * Add project.
     *
     * @param project
     */
    void updateProject(Project project);

    /**
     * Archive project
     *
     * @param id of project.
     */
    void archiveProject(String id);
}
