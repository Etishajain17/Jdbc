import java.sql.*;

public class _048_ScrollableResultSet2
{
    public static void main(String[] args) throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=st.executeQuery("select * from employee");
        System.out.println("Records in Original Order");
        System.out.println("ENO \t ENAME \t ESAL \t EADDR");
        System.out.println("...............................");
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                    rs.getString(4));
        }
        System.out.println("...............................");
        System.out.println();
        rs.first();
        System.out.println("First Row");
        System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                rs.getString(4));
        rs.last();
        System.out.println("Last Row");
        System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                rs.getString(4));
        rs.relative(-1);
        System.out.println("2nd Last Row");
        System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                rs.getString(4));
        rs.absolute(2);
        System.out.println("2nd Row");
        System.out.println(rs.getRow()+"---->"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                rs.getString(4));

        con.close();
    }
}
