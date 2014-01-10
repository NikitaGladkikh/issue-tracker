package com.epam.issuetracker.service.impl;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.epam.issuetracker.domain.enums.TypeEnum;
import com.epam.issuetracker.domain.issue.Issue;
import com.epam.issuetracker.repository.impl.IssueRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public class IssueServiceTest {

    private static final String PROJECT_ID = "ProjectId";
    private static final String ISSUE_ID = "IssueId";
    private static final String PROPERTY_ID = "10";
    private static final String BLANK_STRING = "";
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
        service.getAllIssues(PROJECT_ID);
        verify(repository);
    }

    @Test
    public void testGetIssue() {
        expect(repository.findIssue(ISSUE_ID)).andReturn(new Issue());
        replay(repository);
        service.getIssue(ISSUE_ID);
        verify(repository);
    }

    @Test
    public void testUpdateIssue() {
        Issue issue = new Issue();
        issue.setType(TypeEnum.BUG);
        issue.setSeverity(PROPERTY_ID);
        issue.setPriority(PROPERTY_ID);
        issue.setStatus(PROPERTY_ID);
        issue.setResolution(PROPERTY_ID);
        issue.setId(ISSUE_ID);
        expect(repository.findStatusById(PROPERTY_ID)).andReturn(BLANK_STRING);
        expect(repository.findPriorityById(PROPERTY_ID)).andReturn(BLANK_STRING);
        expect(repository.findSeverityById(PROPERTY_ID)).andReturn(BLANK_STRING);
        expect(repository.findResolutionById(PROPERTY_ID)).andReturn(BLANK_STRING);
        repository.updateIssue(issue);
        replay(repository);
        service.updateIssue(issue, PROJECT_ID);
        verify(repository);
    }

    @Test
    public void testGetStatuses() {
        expect(repository.findStatuses()).andReturn(new ArrayList<String>());
        replay(repository);
        service.getStatuses();
        verify(repository);
    }

    @Test
    public void testGetPriorities() {
        expect(repository.findPriorities()).andReturn(new ArrayList<String>());
        replay(repository);
        service.getPriorities();
        verify(repository);
    }

    @Test
    public void testGetSevereties() {
        expect(repository.findSeverities()).andReturn(new ArrayList<String>());
        replay(repository);
        service.getSeverities();
        verify(repository);
    }

    @Test
    public void testGetResolutions() {
        expect(repository.findResolutions()).andReturn(new ArrayList<String>());
        replay(repository);
        service.getResolutions();
        verify(repository);
    }
}
