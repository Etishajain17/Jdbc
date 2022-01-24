import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _025_BatchWithStatement
{
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        st.addBatch("insert into employee values(1002,'Manvi',1230.67,'Punjab')");
        st.addBatch("update employee set esal=esal+700 where esal<6000");
        st.addBatch("delete from employee where esal>10000");
        //st.addBatch("select * from employee");       (BatchUpdateException for select)
        int[] counter=st.executeBatch();
        int updateCount=0;
        for(int x: counter)
        {
            updateCount=updateCount+x;
        }
        System.out.println("Number Of rows updated:"+updateCount);
        con.close();
    }
}
