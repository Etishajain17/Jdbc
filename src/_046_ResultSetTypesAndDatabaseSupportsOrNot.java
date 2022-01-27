import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class _046_ResultSetTypesAndDatabaseSupportsOrNot
{
    /*
    Division-1:Based on operations performed(allowed values for mode/concurrency)
    - Read Only ResultSets(Static ResultSets)   ---->CONCUR_READ_ONLY ->1007(by default)
    - Updatable ResultSets(Dynamic ResultSets)  ---->CONCUR_UPDATABLE ->1008

    Division-2:Based on Cursor Movement(allowed values for type)
    - Forward Only(Non-Scrollable) ResultSet    ---->TYPE_FORWARD_ONLY ->1003(by default)
    - Scrollable ResultSets
          - Scroll Insensitive ResultSet        ---->TYPE_SCROLL_INSENSITIVE ->1004
          - Scroll Sensitive ResultSet          ---->TYPE_SCROLL_SENSITIVE   ->1005

          Statement st=con.createStatement(int type,int mode);
          PreparedStatement pst=con.prepareStatement(Query,int type,int mode);

    Division-3:Based on Holdability
    - HOLD_CURSORS_OVER_COMMIT ---->1(by default)
    - CLOSE_CURSORS_AT_COMMIT  ---->2

    */
    public static void main(String[] args) throws Exception
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        DatabaseMetaData dbmd=con.getMetaData();
        // dbmd.supportsResultSetsConcurrency(int type,int concurrency);
        // dbmd.supportsResultSetType(int type);
        System.out.println(dbmd.supportsResultSetConcurrency(1003,1007));
        System.out.println(dbmd.supportsResultSetConcurrency(1003,1008));
        System.out.println(dbmd.supportsResultSetType(1003));
        System.out.println(dbmd.supportsResultSetType(1004));
        System.out.println(dbmd.supportsResultSetType(1005));
        con.close();
    }
}
