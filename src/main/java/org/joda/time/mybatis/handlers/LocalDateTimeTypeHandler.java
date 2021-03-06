//package org.joda.time.mybatis.handlers;
//
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.TypeHandler;
//import org.joda.time.DateTimeZone;
//import org.joda.time.LocalDateTime;
//
//public class LocalDateTimeTypeHandler implements TypeHandler
//{
//    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException
//    {
//        ps.setTimestamp(i, new java.sql.Timestamp(((LocalDateTime) parameter).toDateTime(DateTimeZone.UTC).toDate()
//                .getTime()));
//    }
//
//    public Object getResult(ResultSet rs, String columnName) throws SQLException
//    {
//        return new LocalDateTime(rs.getTimestamp(columnName).getTime(), DateTimeZone.UTC);
//    }
//
//    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException
//    {
//        return new LocalDateTime(cs.getTimestamp(columnIndex).getTime(), DateTimeZone.UTC);
//    }
//}
