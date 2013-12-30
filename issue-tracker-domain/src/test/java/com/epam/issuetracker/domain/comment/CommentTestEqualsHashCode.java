package com.epam.issuetracker.domain.comment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * Date: 12/19/13
 *
 * @author Mikita_Hladkikh
 */
@RunWith(Parameterized.class)
public class CommentTestEqualsHashCode {
    private static final String ID = "id";
    private static final String USER = "user";
    private static final String COMMENT = "comment";

    private Comment comment1;
    private Object comment2;
    private boolean expected;

    public CommentTestEqualsHashCode(Comment comment1, Object comment2, boolean expected) {
        this.comment1 = comment1;
        this.comment2 = comment2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> stepUpCommentValues() {
        Comment comment = buildComment(ID, USER, USER);
        return Arrays.asList(new Object[][]{
            {comment, comment, true},
            {buildComment(ID, USER, COMMENT), new Object(), false},
            {buildComment(ID, USER, COMMENT), null, false},
            {new Comment(), new Comment(), true},
            {buildComment(ID, USER, COMMENT), buildComment(ID, USER, COMMENT), true},
            {buildComment(ID, USER, null), buildComment(ID, USER, COMMENT), false},
            {buildComment(ID, USER, COMMENT), buildComment(USER, COMMENT, ID), false},
        });
    }

    @Test
    public void testEquals() {
        assertEquals(expected, comment1.equals(comment2));
    }

    @Test
    public void testHashCode() {
        assertEquals(expected, Objects.hashCode(comment1) == Objects.hashCode(comment2));
    }

    static Comment buildComment(String id, String user, String comment) {
        Comment newComment = new Comment();
        newComment.setId(id);
        newComment.setUser(user);
        newComment.setComment(comment);
        return newComment;
    }
}
