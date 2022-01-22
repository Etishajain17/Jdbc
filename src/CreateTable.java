import java.sql.*;

public class CreateTable
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        String sql_query="insert into employee values(1001,'Etisha',5000,'Mathura')";
        st.executeUpdate(sql_query);
        System.out.println("Values inserted Successfully");
        con.close();
    }
}
