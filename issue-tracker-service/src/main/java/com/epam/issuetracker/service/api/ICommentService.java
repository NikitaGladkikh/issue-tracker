package com.epam.issuetracker.service.api;

import com.epam.issuetracker.domain.comment.Comment;

import java.util.List;

/**
 * Represents interface of service for comment logic.
 * <p/>
 * Date: 12/24/13
 *
 * @author Mikita_Hladkikh
 */
public interface ICommentService {

    /**
     * Get all comments of issue.
     *
     * @param idIssue id of issue
     * @return list of comments
     */
    List<Comment> getAllComments(String idIssue);

    /**
     * Add comment to issue.
     *
     * @param comment
     * @param idIssue id of issue
     */
    void addComment(Comment comment, String idIssue);
}
