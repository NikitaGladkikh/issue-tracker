package com.epam.issuetracker.domain.project;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Class for testing project methods.
 * <p/>
 * Date: 12/19/13
 *
 * @author Mikita_Hladkikh
 */
public class ProjectTest {

    private static final String ID = "id";
    private static final String NAME = "Name";
    private static final String SHORT_NAME = "Short Name";
    private static final String DESCRIPTION = "Description";

    private Project project;

    @Before
    public void initProject() {
        project = buildProject();
    }

    @Test
    public void testGetters() {
        assertEquals(ID, project.getId());
        assertEquals(NAME, project.getName());
        assertEquals(SHORT_NAME, project.getShortName());
        assertEquals(DESCRIPTION, project.getDescription());
    }

    @Test
    public void testToString() {
        String projectString = project.toString();
        assertThat(projectString, containsString(NAME));
        assertThat(projectString, containsString(SHORT_NAME));
        assertThat(projectString, containsString(DESCRIPTION));
    }

    @Test
    public void testEqualsWithOneProject() {
        assertTrue(project.equals(project));
    }

    @Test
    public void testEqualsWithNull() {
        assertFalse(project.equals(null));
    }

    @Test
    public void testEqualsWithAnotherClass() {
        assertFalse(project.equals(new String(NAME)));
    }

    @Test
    public void testEqualsWithFields() {
        Project thatProject = buildProject();
        assertTrue(project.equals(thatProject));
        thatProject.setShortName(null);
        assertFalse(project.equals(thatProject));
        project.setShortName(null);
        assertTrue(project.equals(thatProject));
    }


    @Test
    public void testHashCode() {
        Project anotherProject = buildProject();
        assertEquals(project.hashCode(), project.hashCode());
        assertEquals(project.hashCode(), anotherProject.hashCode());
        anotherProject.setDescription(DESCRIPTION + NAME);
        assertNotEquals(project.hashCode(), anotherProject.hashCode());
    }

    private Project buildProject() {
        Project newProject = new Project();
        newProject.setId(ID);
        newProject.setName(NAME);
        newProject.setShortName(SHORT_NAME);
        newProject.setDescription(DESCRIPTION);
        return newProject;
    }
}
