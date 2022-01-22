import java.sql.*;

public class _012_AggregateTable1
{
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        String sql_query="select count(*) from employee";
        ResultSet rs = st.executeQuery(sql_query);
        if(rs.next())
        {
            System.out.println("Total number of rows in Table : "+rs.getInt(1));
        }
        System.out.println("...............................");
        con.close();
    }
}
