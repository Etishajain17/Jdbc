import java.sql.*;
import java.util.Scanner;

public class _021_SQLInjection
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        System.out.println("Enter the name whose record you want to display");
        String name=sc.next();
        ResultSet rs =st.executeQuery("select * from employee where ename='"+ name +"' or 2=2 ");
        System.out.println("ENO \t ENAME \t ESAL \t EADDR");
        System.out.println("...............................");
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                    rs.getString(4));
        }
        System.out.println("...............................");
        con.close();
    }
}
