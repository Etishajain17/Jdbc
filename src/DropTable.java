import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable
{
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        String sql_query="drop table employee";
        Statement st=con.createStatement();
        st.executeUpdate(sql_query);
        System.out.println("Table Deleted Successfully");
        con.close();
    }
}
