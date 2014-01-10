package com.epam.issuetracker.repository.impl;

import com.epam.issuetracker.domain.issue.Issue;
import com.epam.issuetracker.repository.MyBatisSqlSessionFactory;
import com.epam.issuetracker.repository.api.IIssueRepository;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public class IssueRepository implements IIssueRepository {

    private SqlSession session;

    @Override
    public List<Issue> findAllIssues(String projectId) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            return issueRepository.findAllIssues(projectId);
        } finally {
            session.close();
        }
    }

    @Override
    public Issue findIssue(String issueId) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            return issueRepository.findIssue(issueId);
        } finally {
            session.close();
        }
    }

    @Override
    public void insertIssue(Issue issue, String projectId) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            issueRepository.insertIssue(issue, projectId);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateIssue(Issue issue) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            issueRepository.updateIssue(issue);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<String> findStatuses() {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            return issueRepository.findStatuses();
        } finally {
            session.close();
        }
    }

    @Override
    public String findStatusById(String name) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            return issueRepository.findStatusById(name);
        } finally {
            session.close();
        }
    }

    @Override
    public List<String> findSeverities() {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            return issueRepository.findSeverities();
        } finally {
            session.close();
        }
    }

    @Override
    public String findSeverityById(String name) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            return issueRepository.findSeverityById(name);
        } finally {
            session.close();
        }
    }

    @Override
    public List<String> findResolutions() {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            return issueRepository.findResolutions();
        } finally {
            session.close();
        }
    }

    @Override
    public String findResolutionById(String name) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            return issueRepository.findResolutionById(name);
        } finally {
            session.close();
        }
    }

    @Override
    public List<String> findPriorities() {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            return issueRepository.findPriorities();
        } finally {
            session.close();
        }
    }

    @Override
    public String findPriorityById(String name) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IIssueRepository issueRepository =
                session.getMapper(IIssueRepository.class);
            return issueRepository.findPriorityById(name);
        } finally {
            session.close();
        }
    }

}
