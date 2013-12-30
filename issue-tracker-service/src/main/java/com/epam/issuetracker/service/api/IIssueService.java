package com.epam.issuetracker.service.api;

import com.epam.issuetracker.domain.issue.Issue;

import java.util.List;

/**
 * Represents interface of service for issue logic.
 * Date: 12/24/13
 *
 * @author Mikita_Hladkikh
 */
public interface IIssueService {

    /**
     * Get all issues of project.
     *
     * @param idProject id of project.
     * @return list of issues.
     */
    List<Issue> getAllIssues(String idProject);

    /**
     * Get issue.
     *
     * @param id issue.
     * @return issue.
     */
    Issue getIssue(String id);

    /**
     * Add issue to project.
     *
     * @param issue
     */
    void updateIssue(Issue issue);

    /**
     * Get list of statuses for issue.
     *
     * @return list of statuses.
     */
    List<String> getStatuses();

    /**
     * Get list of severities for issue.
     *
     * @return list of severities.
     */
    List<String> getSeverities();

    /**
     * Get list of resolutions for issue.
     *
     * @return list of resolutions.
     */
    List<String> getResolutions();

    /**
     * Get list of properties for issue.
     *
     * @return list of priorities.
     */
    List<String> getPriorities();
}
