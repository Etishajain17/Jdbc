import java.sql.*;
import java.util.Scanner;

public class _019_PreparedStatement1
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        String sql_query="insert into employee values(?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(sql_query);
        while (true)
        {
            System.out.println("Enter Employee number");
            int eno=sc.nextInt();
            System.out.println("Enter Employee name");
            String ename=sc.next();
            System.out.println("Enter Employee salary");
            float esal=sc.nextFloat();
            System.out.println("Enter Employee address");
            String eaddr=sc.next();
            pst.setInt(1,eno);
            pst.setString(2,ename);
            pst.setFloat(3,esal);
            pst.setString(4,eaddr);
            pst.executeUpdate();
            System.out.println("Record Inserted Successfully");
            System.out.println("Want to insert more[yes/no] : ");
            String choice=sc.next();
            if(choice.equalsIgnoreCase("no"))
            {
                break;
            }
        }
        System.out.println("...............................");
        con.close();
    }
}
