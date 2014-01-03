package com.epam.issuetracker.service.impl;

import com.epam.issuetracker.domain.comment.Comment;
import com.epam.issuetracker.repository.impl.CommentRepository;
import com.epam.issuetracker.service.api.ICommentService;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of comment service interface.
 * Date: 12/24/13
 *
 * @author Mikita_Hladkikh
 */
public class CommentService implements ICommentService {

    private CommentRepository repository = new CommentRepository();

    @Override
    public List<Comment> getAllComments(String idIssue) {
        return repository.findComments(idIssue);
    }

    @Override
    public void addComment(Comment comment, String idIssue) {
        comment.setId(UUID.randomUUID().toString());
        repository.insertComment(comment, idIssue);
    }

    public void setCommentRepository(CommentRepository repository) {
        this.repository = repository;
    }
}
