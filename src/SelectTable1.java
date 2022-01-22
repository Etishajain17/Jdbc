import java.sql.*;

public class SelectTable1
{
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical","root","");
        String sql_query="select * from employee where esal>10000";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql_query);
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
