package com.epam.issuetracker.service.impl;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.epam.issuetracker.domain.project.Project;
import com.epam.issuetracker.repository.impl.ProjectRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public class ProjectServiceTest {

    private static final String PROJECT_ID = "Project ID";
    private ProjectService service;
    private ProjectRepository repository;

    @Before
    public void init() {
        service = new ProjectService();
        repository = createMock(ProjectRepository.class);
        service.setProjectRepository(repository);
    }

    @Test
    public void testGetAllProjects() {
        List<Project> projects = new ArrayList<>();
        expect(repository.findAllProjects()).andReturn(projects);
        replay(repository);
        projects = service.getAllProjects();
        verify(repository);
    }

    @Test
    public void testGetProject() {
        Project project = new Project();
        expect(repository.findProject(PROJECT_ID)).andReturn(project);
        replay(repository);
        project = service.getProject(PROJECT_ID);
        verify(repository);
    }

    @Test
    public void testAddBlankProject() {
        Project project = new Project();
        repository.insertProject(project);
        replay(repository);
        service.updateProject(project);
        verify(repository);
    }

    @Test
    public void testUpdateProject() {
        Project project = new Project();
        project.setId(UUID.randomUUID().toString());
        repository.updateProject(project);
        replay(repository);
        service.updateProject(project);
        verify(repository);
    }
}
