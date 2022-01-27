import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class _055_ResultSetTypeConcurrencyHoldability2
{
    public static void main(String[] args) throws Exception
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.HOLD_CURSORS_OVER_COMMIT);
        System.out.println("Type :"+st.getResultSetType());
        System.out.println("Concurrency :"+st.getResultSetConcurrency());
        System.out.println("Holdability :"+st.getResultSetHoldability());
        con.close();
    }
}