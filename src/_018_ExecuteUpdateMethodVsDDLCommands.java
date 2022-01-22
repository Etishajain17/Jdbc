import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _018_ExecuteUpdateMethodVsDDLCommands
{
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        int x = st.executeUpdate("drop table employee");
        //int x = st.executeUpdate("drop table employee");
        System.out.println(x);
        System.out.println("...............................");
        con.close();
    }
}
