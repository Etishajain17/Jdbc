import java.sql.*;

public class _050_UpdatableResultSet
{
    /*
    Only For Type-1 Driver
     */
    public static void main(String[] args) throws SQLException,ClassNotFoundException
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=st.executeQuery("select * from employee");
        rs.last();
        rs.deleteRow();
        System.out.println("Last Record Deleted Successfully");
        con.close();
    }
}