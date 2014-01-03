package com.epam.issuetracker.repository.impl;

import com.epam.issuetracker.domain.comment.Comment;
import com.epam.issuetracker.repository.api.ICommentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of comment repository interface.
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public class CommentRepository implements ICommentRepository {

    private static final String USER = "User";
    private static final String COMMENT = "Comment Comment Comment Comment Comment Comment";

    private List<Comment> comments = buildComments();

    @Override
    public List<Comment> findComments(String issueId) {
        return comments;
    }

    @Override
    public void insertComment(Comment comment, String issueId) {
        comments.add(comment);
    }

    private List<Comment> buildComments() {
        List<Comment> tempComments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setId(UUID.randomUUID().toString());
            comment.setUser(USER);
            comment.setComment(COMMENT);
            tempComments.add(comment);
        }
        return tempComments;
    }
}
