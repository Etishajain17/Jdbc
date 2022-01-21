import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTable2
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        while(true)
        {
            int eno = sc.nextInt();
            String ename = sc.next();
            float esal = sc.nextFloat();
            String eaddr = sc.next();
            String sql_query = String.format("insert into employee values (%d,'%s',%f,'%s')", eno, ename, esal, eaddr);
            st.executeUpdate(sql_query);
            System.out.println("Records Inserted Successfully");
            System.out.println("Want to insert more[yes/no] ");
            String choice=sc.next();
            if(choice.equalsIgnoreCase("no"))
            {
                break;
            }
        }
        con.close();
    }
}
