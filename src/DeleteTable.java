import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTable
{
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        String sql_query="delete from employee where ename='Anam'";
        Statement st=con.createStatement();
        int UpdatedCount=st.executeUpdate(sql_query);
        System.out.println("Rows Deleted : "+ UpdatedCount);
        con.close();
    }
}
