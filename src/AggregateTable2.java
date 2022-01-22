import java.sql.*;

public class AggregateTable2
{
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        Statement st=con.createStatement();
        String sql_query="select * from employee where esal in (select max(esal) from employee)";
        ResultSet rs = st.executeQuery(sql_query);
        System.out.println("ENO \t ENAME \t ESAL \t EADDR");
        System.out.println("...............................");
        if(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                    rs.getString(4));
        }
        System.out.println("...............................");
        con.close();
    }
}
