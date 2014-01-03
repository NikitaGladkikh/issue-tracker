package com.epam.issuetracker.service.impl;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.epam.issuetracker.domain.comment.Comment;
import com.epam.issuetracker.repository.impl.CommentRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public class CommentServiceTest {

    private static final String ISSUE_ID = "Issue id";
    private CommentService service;
    private CommentRepository repository;

    @Before
    public void init() {
        service = new CommentService();
        repository = createMock(CommentRepository.class);
        service.setCommentRepository(repository);
    }

    @Test
    public void testGetAllComments() {
        expect(repository.findComments(ISSUE_ID)).andReturn(new ArrayList<Comment>());
        replay(repository);
        List<Comment> comments = service.getAllComments(ISSUE_ID);
        verify(repository);
    }

    @Test
    public void testAddComment() {
        Comment comment = new Comment();
        repository.insertComment(comment, ISSUE_ID);
        replay(repository);
        service.addComment(comment, ISSUE_ID);
        verify(repository);
    }
}
