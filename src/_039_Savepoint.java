import java.sql.*;

public class _039_Savepoint
{
    /*
    - Savepoint sp=con.setSavepoint()   ----> if we want to rollback particular operations based on some condition
    - con.rollback(sp)                  ----> to perform rollback based on condition
    - con.releaseSavepoint(sp)          ----> to release or delete savepoint
     */
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        con.setAutoCommit(false);
        st.executeUpdate("insert into politician values('siddhu','congress')");
        st.executeUpdate("insert into politician values('kejriwal','AAP')");
        Savepoint sp=con.setSavepoint();
        st.executeUpdate("insert into politician values('rahul','bjp')");
        System.out.println("oops..wrong entry just rollback");
        con.rollback(sp);
        con.releaseSavepoint(sp);
        System.out.println("Operations are rollback from Savepoint");
        con.commit();
        con.close();
    }
}
