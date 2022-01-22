import java.sql.*;
import java.util.Scanner;

public class SelectTable4
{
    public static void main(String[] args) throws SQLException
    {
        Scanner sc=new Scanner(System.in);
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        String sql_query=String.format("select ename,eaddr from employee");
        ResultSet rs = st.executeQuery(sql_query);
        System.out.println("ENAME \t EADDR");
        System.out.println(".................");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"\t"+rs.getString(2));
        }
        System.out.println(".................");
        con.close();
    }
}