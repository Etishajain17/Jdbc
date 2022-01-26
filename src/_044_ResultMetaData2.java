import java.sql.*;

public class _044_ResultMetaData2
{
    /*
        ResultSetMetaData
     */
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from employee");
        ResultSetMetaData rsmd=rs.getMetaData();
        System.out.println(rsmd.getColumnName(1)+"\t"+rsmd.getColumnName(2)+"\t"+rsmd.getColumnName(3)+"\t"+rsmd.getColumnName(4));
        System.out.println("...............................");
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                    rs.getString(4));
        }
        System.out.println("...............................");
        con.close();
    }
}
