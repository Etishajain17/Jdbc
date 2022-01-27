import java.sql.*;

public class _051_UpdatableResultSet2
{
    /*
    Only For Type-1 Driver
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=st.executeQuery("select * from employee");
        rs.moveToInsertRow();   //creates an empty record
        rs.updateInt(1,1008);
        rs.updateString(2,"prateek");
        rs.updateFloat(3,98789);
        rs.updateString(4,"jaipur");
        rs.insertRow();
        con.close();
    }
}
