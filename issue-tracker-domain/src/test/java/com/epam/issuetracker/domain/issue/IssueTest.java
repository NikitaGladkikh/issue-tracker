package com.epam.issuetracker.domain.issue;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.epam.issuetracker.domain.comment.Comment;
import com.epam.issuetracker.domain.enums.TypeEnum;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for testing issue methods.
 * <p/>
 * Date: 12/19/13
 *
 * @author Mikita_Hladkikh
 */
public class IssueTest {

    private static final String KEY = "key";
    private static final String SUMMARY = "summary";
    private static final String STATUS = "status";
    private static final String PRIORITY = "priority";
    private static final String RESOLUTION = "resolution";
    private static final String SEVERITY = "severity";
    private static final String USER = "user";
    private static final String COMMENT = "comments Comment";

    private Issue issue;
    private List<Comment> commentList;

    @Before
    public void initData() {
        issue = buildIssue();
        commentList = new LinkedList<Comment>();
        commentList.add(buildComment());
        commentList.add(buildComment());
        issue.setComments(commentList);
    }

    @Test
    public void testGetters() {
        assertEquals(KEY, issue.getKey());
        assertEquals(SUMMARY, issue.getSummary());
        assertEquals(TypeEnum.BUG, issue.getType());
        assertEquals(STATUS, issue.getStatus());
        assertEquals(PRIORITY, issue.getPriority());
        assertEquals(RESOLUTION, issue.getResolution());
        assertEquals(SEVERITY, issue.getSeverity());
        assertEquals(commentList, issue.getComments());
    }

    @Test
    public void testToString() {
        String issueString = issue.toString();
        assertThat(issueString, containsString(KEY));
        assertThat(issueString, containsString(SUMMARY));
        assertThat(issueString, containsString(TypeEnum.BUG.toString()));
        assertThat(issueString, containsString(STATUS));
        assertThat(issueString, containsString(PRIORITY));
        assertThat(issueString, containsString(RESOLUTION));
        assertThat(issueString, containsString(SEVERITY));
        assertThat(issueString, containsString(USER));
        assertThat(issueString, containsString(COMMENT));
    }

    @Test
    public void testEqualsWithNull() {
        assertFalse(issue.equals(null));
    }

    @Test
    public void testEqualsWithOneIssue() {
        assertTrue(issue.equals(issue));
    }

    @Test
    public void testEqualsWithSameIssues() {
        Issue newIssue = buildIssue();
        newIssue.setComments(commentList);
        assertTrue(issue.equals(newIssue) == newIssue.equals(issue));
    }

    @Test
    public void testHashCode() {
        Issue newIssue = buildIssue();
        newIssue.setComments(commentList);
        assertEquals(issue.hashCode(), newIssue.hashCode());
        newIssue.setPriority(PRIORITY + KEY);
        assertNotEquals(issue.hashCode(), newIssue.hashCode());
    }

    private Issue buildIssue() {
        Issue newIssue = new Issue();
        newIssue.setKey(KEY);
        newIssue.setSummary(SUMMARY);
        newIssue.setType(TypeEnum.BUG);
        newIssue.setStatus(STATUS);
        newIssue.setPriority(PRIORITY);
        newIssue.setResolution(RESOLUTION);
        newIssue.setSeverity(SEVERITY);
        return newIssue;
    }

    private Comment buildComment() {
        Comment comment = new Comment();
        comment.setUser(USER);
        comment.setComment(COMMENT);
        return comment;
    }
}
