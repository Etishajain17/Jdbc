import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _026_BatchWithPreparedStatement
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
        while(true)
        {
            System.out.println("Employee Number: ");
            int eno=sc.nextInt();
            System.out.println("Employee Name: ");
            String ename=sc.next();
            System.out.println("Employee Salary: ");
            float esal=sc.nextFloat();
            System.out.println("Employee Address: ");
            String eaddr=sc.next();
            ps.setInt(1,eno);
            ps.setString(2,ename);
            ps.setFloat(3,esal);
            ps.setString(4,eaddr);
            ps.addBatch();
            System.out.println("Do you want to insert one more record[yes/no] :");
            String opt =sc.next();
            if(opt.equalsIgnoreCase("no"))
            {
                break;
            }
        }
        ps.executeBatch();
        System.out.println("Records Inserted Successfully");
        con.close();
    }
}