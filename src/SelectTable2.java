import java.sql.*;
import java.util.Scanner;

public class SelectTable2
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        System.out.println("Enter the city name");
        String addr=sc.next();
        String sql_query=String.format("select * from employee where eaddr='%s'",addr);
        ResultSet rs = st.executeQuery(sql_query);
        boolean flag=false;
        System.out.println("ENO \t ENAME \t ESAL \t EADDR");
        System.out.println("...............................");
        while(rs.next())
        {
            flag=true;
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                    rs.getString(4));
        }
        if(flag==false)
        {
            System.out.println("No Matched Record Found");
        }
        System.out.println("...............................");
        con.close();
    }
}
