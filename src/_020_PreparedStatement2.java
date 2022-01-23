import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _020_PreparedStatement2
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        String sql_query="delete from employee where ename=?";
        PreparedStatement ps=con.prepareStatement(sql_query);
        System.out.println("Enter the name whose record you want to delete");
        String name=sc.next();
        ps.setString(1,name);
        int updateCount=ps.executeUpdate();
        System.out.println("Number of rows deleted : "+ updateCount);
        System.out.println("...............................");
        con.close();
    }
}
