package com.epam.issuetracker.repository.api;

import com.epam.issuetracker.domain.comment.Comment;

import java.util.List;

/**
 * Interface interface of repository for comment.
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public interface ICommentRepository {

    /**
     * Find comments for selected issue.
     *
     * @param issueId id of issue.
     * @return list of comments.
     */
    List<Comment> findComments(String issueId);

    /**
     * Insert comment for selected issue.
     *
     * @param issueId id of issue.
     */
    void insertComment(Comment comment, String issueId);
}
