import java.sql.*;

public class _042_MetaData2
{
    public static void main(String[] args) throws SQLException
    {
        int count=0;
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        DatabaseMetaData dbmd=con.getMetaData();
        String catalog=null;
        String schemaPattern=null;
        String tableNamePattern=null;
        String[] types=null;
        ResultSet rs=dbmd.getTables(catalog,schemaPattern,tableNamePattern,types);
        while(rs.next())
        {
            count++;
            System.out.println(rs.getString(3));
        }
        System.out.println("Number Of Tables :"+count);
        con.close();
    }
}
