package com.epam.issuetracker.service.impl;

import com.epam.issuetracker.domain.comment.Comment;
import com.epam.issuetracker.service.api.ICommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of comment service interface.
 * Date: 12/24/13
 *
 * @author Mikita_Hladkikh
 */
public class CommentService implements ICommentService {

    private static final String USER = "User";
    private static final String COMMENT = "CommentCommentCommentCommentCommentComment";

    private List<Comment> comments = buildComments();

    private List<Comment> buildComments() {
        List<Comment> tempComments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setId(UUID.randomUUID().toString());
            comment.setUser(new StringBuilder(USER).append(i).toString());
            comment.setComment(new StringBuilder(COMMENT).append(i).toString());
            tempComments.add(comment);
        }
        return tempComments;
    }

    @Override
    public List<Comment> getAllComments(String idIssue) {
        return comments;
    }

    @Override
    public void addComment(Comment comment, String idIssue) {
        comments.add(comment);
    }
}
