import java.io.IOException;
import java.sql.*;

public class _049_ScrollSensitiveResultSet
{
    /*
    Only for Type-2 Driver
     */
    public static void main(String[] args) throws SQLException, IOException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=st.executeQuery("select eno,ename,esal,eaddr from employee");
        System.out.println("Records Before Updation");
        System.out.println("ENO \t ENAME \t ESAL \t EADDR");
        System.out.println("...............................");
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                    rs.getString(4));
        }
        System.out.println("Apllication is going to pausing state,update database..");
        System.in.read();
        rs.beforeFirst();
        System.out.println("Records After Updation");
        while(rs.next())
        {
            rs.refreshRow();
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                    rs.getString(4));
        }
        con.close();
    }
}
