package com.epam.issuetracker.domain.comment;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Date: 12/19/13
 *
 * @author Mikita_Hladkikh
 */
public class CommentTest {
    private static final String USER = "User";
    private static final String COMMENT = "Comment comment";

    private Comment comment;

    @Before
    public void initComment() {
        comment = buildComment();
    }

    @Test
    public void testGetters() {
        assertEquals(USER, comment.getUser());
        assertEquals(COMMENT, comment.getComment());
    }

    @Test
    public void testToString() {
        String commentString = comment.toString();
        assertThat(commentString, containsString(USER));
        assertThat(commentString, containsString(COMMENT));
    }

    @Test
    public void testEqualsWithNull() {
        assertFalse(comment.equals(null));
    }

    @Test
    public void testEqualsWithOneComment() {
        assertTrue(comment.equals(comment));
    }

    @Test
    public void testEqualsWithSameComments() {
        Comment newComment = buildComment();
        assertTrue(comment.equals(newComment) == newComment.equals(comment));
    }

    @Test
    public void testHashCode() {
        Comment newComment = buildComment();
        assertEquals(comment.hashCode(), newComment.hashCode());
        newComment.setComment(COMMENT + USER);
        assertNotEquals(comment.hashCode(), newComment.hashCode());
    }

    private Comment buildComment() {
        Comment newComment = new Comment();
        newComment.setUser(USER);
        newComment.setComment(COMMENT);
        return newComment;
    }
}
