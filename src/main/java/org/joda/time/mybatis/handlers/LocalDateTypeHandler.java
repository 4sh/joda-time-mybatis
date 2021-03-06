package org.joda.time.mybatis.handlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

import java.sql.*;

@MappedTypes(LocalDate.class)
public class LocalDateTypeHandler implements TypeHandler
{

    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException
    {

        LocalDate date = (LocalDate) parameter;
        if (date != null)
        {
            ps.setDate(i, new Date(date.toDateTimeAtStartOfDay().toDate().getTime()));
        }
        else
        {
            ps.setDate(i, null);
        }
    }

    public Object getResult(ResultSet rs, String columnName) throws SQLException
    {
        Date date = rs.getDate(columnName);
        if (date != null)
        {
            return new LocalDate(date.getTime()/* see https://github.com/LukeL99/joda-time-mybatis/commit/66ef76c2a65fabdcc2e962e45d1cef38c00e61db#commitcomment-985806 , DateTimeZone.UTC */);
        }
        else
        {
            return null;
        }
    }

    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException
    {
        Date date = cs.getDate(columnIndex);
        if (date != null)
        {
            return new LocalDate(date.getTime() /* https://github.com/LukeL99/joda-time-mybatis/commit/66ef76c2a65fabdcc2e962e45d1cef38c00e61db#commitcomment-985806, DateTimeZone.UTC */);
        }
        else
        {
            return null;
        }
    }

}
