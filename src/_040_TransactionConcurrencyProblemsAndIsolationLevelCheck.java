import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _040_TransactionConcurrencyProblemsAndIsolationLevelCheck
{
    /*
    Three Major Problems
    - Dirty Read Problem           ----> Before committing the transaction ,if its intermediate results used by any other transaction
    - Non-Repeatable Read Problem  ----> For same read operation,in same transaction if we get different results at different times
    - Phantom Read Problem         ----> One transaction reads all rows that satisfy a where condition and second transaction insert \
                                         a new row that satisfy same where condition.
     */

    /*
    Common Isolation Levels
    - TRANSACTION_READ_UNCOMMITTED -->1
    - TRANSACTION_READ_COMMITTED   -->2
    - TRANSACTION_REPEATABLE_READ  -->4
    - TRANSACTION_SERIALIZABLE     -->8
     */
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        System.out.println(con.getTransactionIsolation());
        con.setTransactionIsolation(1);
        System.out.println(con.getTransactionIsolation());
    }
}
