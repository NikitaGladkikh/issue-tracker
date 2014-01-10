package com.epam.issuetracker.repository;

import com.epam.issuetracker.domain.enums.TypeEnum;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Date: 1/9/14
 *
 * @author Mikita_Hladkikh
 */
public class EnumTypeHandler extends BaseTypeHandler<TypeEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, TypeEnum parameter, JdbcType jdbcType)
        throws SQLException {
        ps.setString(i, parameter == null ? null : parameter.getId());
    }

    @Override
    public TypeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String s = rs.getString(columnName);
        return s == null ? null : TypeEnum.lookById(s);
    }

    @Override
    public TypeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String s = rs.getString(columnIndex);
        return s == null ? null : TypeEnum.lookById(s);
    }

    @Override
    public TypeEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String s = cs.getString(columnIndex);
        return s == null ? null : TypeEnum.lookById(s);
    }
}
