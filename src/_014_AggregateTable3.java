import java.sql.*;
import java.util.Scanner;

public class _014_AggregateTable3
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        System.out.println("Enter the number : ");
        int n=sc.nextInt();
       // String sql_query=String.format("select * from ( select eno,ename,esal,eaddr,rank() over (order by esal desc)rank from employee) where rank=%s",n);
        String sql_query="select * from ( select eno,ename,esal,eaddr, rank() over(order by esal desc) as rank from employee) where rank="+n+"";
        ResultSet rs = st.executeQuery(sql_query);
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
