import java.sql.*;
import java.util.Scanner;

public class _015_ExecuteMethod
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        System.out.println("Enter the Query");
        String sql_query=sc.nextLine();
        boolean flag= st.execute(sql_query);
        if(flag==true)
        {
            ResultSet rs=st.getResultSet();
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                        rs.getString(4));
            }
        }
        else
        {
            int rowCount=st.getUpdateCount();
            System.out.println("Number of records affected : " + rowCount);
        }
        System.out.println("...............................");
        con.close();
    }
}
