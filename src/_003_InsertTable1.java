import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class _003_InsertTable1
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        int eno=sc.nextInt();
        String ename=sc.next();
        float esal=sc.nextFloat();
        String eaddr=sc.next();
        String sql_query="insert into employee values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')";
        st.executeUpdate(sql_query);
        System.out.println("Values Inserted Successfully");
        con.close();
    }
}