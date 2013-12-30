package com.epam.issuetracker.service.impl;

import com.epam.issuetracker.domain.enums.TypeEnum;
import com.epam.issuetracker.domain.issue.Issue;
import com.epam.issuetracker.service.api.IIssueService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of issue service interface.
 * Date: 12/24/13
 *
 * @author Mikita_Hladkikh
 */
public class IssueService implements IIssueService {

    private static final String KEY = "Key";
    private static final String SUMMARY = "Summary";
    private static final String DESCRIPTION = "Description";
    private static final String STATUS = "Status ";
    private static final String PRIORITY = "Priority ";
    private static final String RESOLUTION = "Resolution ";
    private static final String SEVERITY = "Severity ";

    private List<Issue> issues = buildIssues();

    private CommentService service = new CommentService();

    @Override
    public List<Issue> getAllIssues(String id) {
        if (null != id) {
            return issues;
        }
        return new ArrayList<>();
    }

    @Override
    public Issue getIssue(String id) {
        Issue issue = new Issue();
        issue.setType(TypeEnum.lookById(String.valueOf(1 + (int) (Math.random() * 3))));
        issue.setKey(KEY);
        issue.setSummary(SUMMARY);
        issue.setDescription(DESCRIPTION);
        issue.setStatus(STATUS);
        issue.setPriority(PRIORITY);
        issue.setResolution(RESOLUTION);
        issue.setSeverity(SEVERITY);
        issue.setComments(service.getAllComments(id));
        return issue;
    }

    @Override
    public void updateIssue(Issue issue) {
        issues.add(issue);
    }

    @Override
    public List<String> getStatuses() {
        List<String> statusList = new ArrayList<>();
        statusList.add(STATUS + 1);
        statusList.add(STATUS + 2);
        statusList.add(STATUS + 3);
        statusList.add(STATUS + 4);
        statusList.add(STATUS + 5);
        return statusList;
    }

    @Override
    public List<String> getSeverities() {
        List<String> severityList = new ArrayList<>();
        severityList.add(SEVERITY + 1);
        severityList.add(SEVERITY + 2);
        severityList.add(SEVERITY + 3);
        severityList.add(SEVERITY + 4);
        severityList.add(SEVERITY + 5);
        return severityList;
    }

    @Override
    public List<String> getResolutions() {
        List<String> resolutionList = new ArrayList<>();
        resolutionList.add(RESOLUTION + 1);
        resolutionList.add(RESOLUTION + 2);
        resolutionList.add(RESOLUTION + 3);
        resolutionList.add(RESOLUTION + 4);
        resolutionList.add(RESOLUTION + 5);
        return resolutionList;
    }

    @Override
    public List<String> getPriorities() {
        List<String> priorityList = new ArrayList<>();
        priorityList.add(PRIORITY + 1);
        priorityList.add(PRIORITY + 2);
        priorityList.add(PRIORITY + 3);
        priorityList.add(PRIORITY + 4);
        priorityList.add(PRIORITY + 5);
        return priorityList;
    }

    private List<Issue> buildIssues() {
        List<Issue> tempIssue = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Issue issue = new Issue();
            issue.setId(UUID.randomUUID().toString());
            int random = 1 + (int) (Math.random() * 3);
            issue.setType(TypeEnum.lookById(String.valueOf(random)));
            issue.setKey(KEY);
            issue.setSummary(SUMMARY);
            issue.setStatus(STATUS);
            issue.setPriority(PRIORITY);
            issue.setResolution(RESOLUTION);
            issue.setSeverity(SEVERITY);
            tempIssue.add(issue);
        }
        return tempIssue;
    }
}
