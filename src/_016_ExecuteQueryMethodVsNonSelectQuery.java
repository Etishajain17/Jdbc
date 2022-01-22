import java.sql.*;

public class _016_ExecuteQueryMethodVsNonSelectQuery
{
    public static void main(String[] args) throws SQLException
    {
        try
        {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
            Statement st=con.createStatement();
            String sql_query="update employee set esal=9000 where ename='Etisha'";
            ResultSet rs = st.executeQuery(sql_query);
            System.out.println("...............................");
            con.close();
        }
        catch(SQLException s)
        {
            System.out.println();
            System.out.println(" Exception because "+s.getMessage());
        }
    }
}
