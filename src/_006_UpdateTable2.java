import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class _006_UpdateTable2
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        double increment=sc.nextDouble();
        double salRange=sc.nextDouble();
        String sql_query=String.format(" update employee set esal=esal+%f where esal<%f ",increment,salRange);
        int UpdatedCount=st.executeUpdate(sql_query);
        System.out.println(" Rows Updated : "+ UpdatedCount);
        con.close();
    }
}