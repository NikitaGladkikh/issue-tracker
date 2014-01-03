package com.epam.issuetracker.repository.api;

import com.epam.issuetracker.domain.issue.Issue;

import java.util.List;

/**
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public interface IIssueRepository {

    /**
     * Find all issues for selected project.
     *
     * @param projectId id of project.
     * @return list of issues.
     */
    List<Issue> findAllIssues(String projectId);


    /**
     * Find impl by id.
     *
     * @param issueId id of impl.
     * @return impl.
     */
    Issue findIssue(String issueId);

    /**
     * Add impl to selected project.
     *
     * @param issue     new impl.
     * @param projectId id of project.
     */
    void insertIssue(Issue issue, String projectId);

    /**
     * Update selected impl.
     *
     * @param issue selected impl.
     */
    void updateIssue(Issue issue);

    /**
     * Find all statuses for impl.
     *
     * @return list of statuses.
     */
    List<String> findStatuses();

    /**
     * Find all of severities for impl.
     *
     * @return list of severities.
     */
    List<String> findSeverities();

    /**
     * Find all of resolutions for impl.
     *
     * @return list of resolutions.
     */
    List<String> findResolutions();

    /**
     * Find all of properties for impl.
     *
     * @return list of priorities.
     */
    List<String> findPriorities();
}
