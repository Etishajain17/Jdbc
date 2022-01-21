import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable1
{
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        String sql_query="update employee set esal=7777.5 where ename='Etisha'";
        Statement st=con.createStatement();
        int UpdatedCount=st.executeUpdate(sql_query);
        System.out.println("Rows Updated : "+ UpdatedCount);
        con.close();
    }
}