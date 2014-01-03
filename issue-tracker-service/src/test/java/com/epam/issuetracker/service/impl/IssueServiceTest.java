package com.epam.issuetracker.service.impl;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.epam.issuetracker.domain.issue.Issue;
import com.epam.issuetracker.repository.impl.IssueRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public class IssueServiceTest {

    private static final String PROJECT_ID = "ProjectId";
    private static final String ISSUE_ID = "IssueId";
    private IssueService service;
    private IssueRepository repository;

    @Before
    public void init() {
        service = new IssueService();
        repository = createMock(IssueRepository.class);
        service.setRepository(repository);
    }

    @Test
    public void testGetAllIssues() {
        expect(repository.findAllIssues(PROJECT_ID)).andReturn(new ArrayList<Issue>());
        replay(repository);
        List<Issue> actualIssues = service.getAllIssues(PROJECT_ID);
        verify(repository);
    }

    @Test
    public void testGetIssue() {
        expect(repository.findIssue(ISSUE_ID)).andReturn(new Issue());
        replay(repository);
        Issue issue = service.getIssue(ISSUE_ID);
        verify(repository);
    }

    @Test
    public void testAddBlankIssue() {
        Issue issue = new Issue();
        repository.insertIssue(issue, PROJECT_ID);
        replay(repository);
        service.updateIssue(issue, PROJECT_ID);
        verify(repository);
    }

    @Test
    public void testUpdateIssue() {
        Issue issue = new Issue();
        issue.setId(ISSUE_ID);
        repository.updateIssue(issue);
        replay(repository);
        service.updateIssue(issue, PROJECT_ID);
        verify(repository);
    }

    @Test
    public void testGetStatuses() {
        expect(repository.findStatuses()).andReturn(new ArrayList<String>());
        replay(repository);
        List<String> statuses = service.getStatuses();
        verify(repository);
    }

    @Test
    public void testGetPriorities() {
        expect(repository.findPriorities()).andReturn(new ArrayList<String>());
        replay(repository);
        List<String> priorities = service.getPriorities();
        verify(repository);
    }

    @Test
    public void testGetSevereties() {
        expect(repository.findSeverities()).andReturn(new ArrayList<String>());
        replay(repository);
        List<String> severities = service.getSeverities();
        verify(repository);
    }

    @Test
    public void testGetResolutions() {
        expect(repository.findResolutions()).andReturn(new ArrayList<String>());
        replay(repository);
        List<String> resolutions = service.getResolutions();
        verify(repository);
    }
}
