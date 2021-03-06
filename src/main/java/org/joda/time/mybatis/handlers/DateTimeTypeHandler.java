package org.joda.time.mybatis.handlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.*;

@MappedTypes(DateTime.class)
public class DateTimeTypeHandler implements TypeHandler
{

    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException
    {
       
        if (parameter != null)
        {
            ps.setTimestamp(i, new Timestamp(((DateTime) parameter).getMillis()));
        }
        else
        {
            ps.setTimestamp(i, null);
        }
    }

    public Object getResult(ResultSet rs, String columnName) throws SQLException
    {
        Timestamp ts = rs.getTimestamp(columnName);
        if (ts != null)
        {
            return new DateTime(ts.getTime() /* see https://github.com/LukeL99/joda-time-mybatis/commit/66ef76c2a65fabdcc2e962e45d1cef38c00e61db#commitcomment-985806, DateTimeZone.UTC */);
        }
        else
        {
            return null;
        }
    }

    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException
    {
        Timestamp ts = cs.getTimestamp(columnIndex);
        if (ts != null)
        {
            return new DateTime(ts.getTime() /* see https://github.com/LukeL99/joda-time-mybatis/commit/66ef76c2a65fabdcc2e962e45d1cef38c00e61db#commitcomment-985806, DateTimeZone.UTC */);
        }
        else
        {
            return null;
        }
    }

}
