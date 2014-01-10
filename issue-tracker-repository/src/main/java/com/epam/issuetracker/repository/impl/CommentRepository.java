package com.epam.issuetracker.repository.impl;

import com.epam.issuetracker.domain.comment.Comment;
import com.epam.issuetracker.repository.MyBatisSqlSessionFactory;
import com.epam.issuetracker.repository.api.ICommentRepository;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Implementation of comment repository interface.
 * Date: 1/3/14
 *
 * @author Mikita_Hladkikh
 */
public class CommentRepository implements ICommentRepository {

    private SqlSession session;

    @Override
    public List<Comment> findComments(String issueId) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            ICommentRepository commentRepository =
                session.getMapper(ICommentRepository.class);
            return commentRepository.findComments(issueId);
        } finally {
            session.close();
        }
    }

    @Override
    public void insertComment(Comment comment, String issueId) {
        session = MyBatisSqlSessionFactory.openSession();
        try {
            ICommentRepository commentRepository =
                session.getMapper(ICommentRepository.class);
            commentRepository.insertComment(comment, issueId);
            session.commit();
        } finally {
            session.close();
        }
    }
}
