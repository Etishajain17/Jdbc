import java.sql.*;

public class _001_CreateTable
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        String sql_query="create table employee(eno int(4),ename varchar(10),esal decimal(10,2),eaddr varchar(10))";
        st.executeUpdate(sql_query);
        System.out.println("Table Created Successfully");
        con.close();
    }
}
