package com.epam.issuetracker.service.impl;

import com.epam.issuetracker.domain.issue.Issue;
import com.epam.issuetracker.repository.impl.IssueRepository;
import com.epam.issuetracker.service.api.IIssueService;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of issue service interface.
 * Date: 12/24/13
 *
 * @author Mikita_Hladkikh
 */
public class IssueService implements IIssueService {

    private IssueRepository repository = new IssueRepository();

    @Override
    public List<Issue> getAllIssues(String id) {
        return repository.findAllIssues(id);
    }

    @Override
    public Issue getIssue(String id) {
        return repository.findIssue(id);
    }

    @Override
    public void updateIssue(Issue issue, String projectId) {
        if (null == issue.getId()) {
            issue.setId(UUID.randomUUID().toString());
            repository.insertIssue(issue, projectId);
        } else {
            repository.updateIssue(issue);
        }
    }

    @Override
    public List<String> getStatuses() {
        return repository.findStatuses();
    }

    @Override
    public List<String> getSeverities() {
        return repository.findSeverities();
    }

    @Override
    public List<String> getResolutions() {
        return repository.findResolutions();
    }

    @Override
    public List<String> getPriorities() {
        return repository.findPriorities();
    }

    public void setRepository(IssueRepository repository) {
        this.repository = repository;
    }
}
