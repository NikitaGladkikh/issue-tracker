package com.epam.issuetracker.repository.impl;

import com.epam.issuetracker.domain.project.Project;
import com.epam.issuetracker.repository.MyBatisSqlSessionFactory;
import com.epam.issuetracker.repository.api.IProjectRepository;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Implementation of project repository interface.
 * <p/>
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public class ProjectRepository implements IProjectRepository {

    private SqlSession session;

    @Override
    public List<Project> findAllProjects() {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IProjectRepository projectRepository =
                session.getMapper(IProjectRepository.class);
            return projectRepository.findAllProjects();
        } finally {
            session.close();
        }
    }

    @Override
    public Project findProject(String projectId) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IProjectRepository projectRepository =
                session.getMapper(IProjectRepository.class);
            return projectRepository.findProject(projectId);
        } finally {
            session.close();
        }
    }

    @Override
    public void insertProject(Project project) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IProjectRepository projectRepository =
                session.getMapper(IProjectRepository.class);
            projectRepository.insertProject(project);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateProject(Project project) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IProjectRepository projectRepository =
                session.getMapper(IProjectRepository.class);
            projectRepository.updateProject(project);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void archiveProject(String projectId) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            IProjectRepository projectRepository =
                session.getMapper(IProjectRepository.class);
            projectRepository.archiveProject(projectId);
            session.commit();
        } finally {
            session.close();
        }
    }
}
