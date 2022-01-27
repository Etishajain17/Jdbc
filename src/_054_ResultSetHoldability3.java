import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class _054_ResultSetHoldability3
{
    public static void main(String[] args) throws Exception
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        Statement st=con.createStatement();
        System.out.println("Type :"+st.getResultSetType());
        System.out.println("Concurrency :"+st.getResultSetConcurrency());
        System.out.println("Holdability :"+st.getResultSetHoldability());
        con.close();
    }
}
