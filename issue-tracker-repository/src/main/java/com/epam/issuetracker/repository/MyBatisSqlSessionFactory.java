package com.epam.issuetracker.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Date: 1/8/14
 *
 * @author Mikita_Hladkikh
 */


public class MyBatisSqlSessionFactory {

    private static final String CONFIG_PATH =
        "com/epam/issuetracker/repository/mapper/mybatis-config.xml";

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {

        if (sqlSessionFactory == null) {
            Reader reader;
            try {
                reader = Resources.getResourceAsReader(CONFIG_PATH);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSession() {
        return getSqlSessionFactory().openSession();
    }
}