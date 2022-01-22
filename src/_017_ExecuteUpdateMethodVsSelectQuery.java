import java.sql.*;

public class _017_ExecuteUpdateMethodVsSelectQuery
{
    public static void main(String[] args) throws SQLException
    {
        try
        {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
            Statement st=con.createStatement();
            int rowCount = st.executeUpdate("select * from employee");
            System.out.println(rowCount);
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
