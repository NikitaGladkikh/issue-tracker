package com.epam.issuetracker.domain.comment;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Date: 12/23/13
 *
 * @author Mikita_Hladkikh
 */
public class CommentTestGetterToString {

    private static final String USER = "user";
    private static final String COMMENT = "comment";

    private Comment comment1;

    @Before
    public void setUpComment() {
        comment1 = CommentTestEqualsHashCode.buildComment(USER, COMMENT);
    }

    @Test
    public void testGetters() {
        assertEquals(USER, comment1.getUser());
        assertEquals(COMMENT, comment1.getComment());
    }

    @Test
    public void testToString() {
        String commentString = comment1.toString();
        assertThat(commentString, containsString(USER));
        assertThat(commentString, containsString(COMMENT));
    }
}
