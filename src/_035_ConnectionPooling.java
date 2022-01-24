import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _035_ConnectionPooling
{
    public static void main(String[] args) throws SQLException {
        MysqlConnectionPoolDataSource mcon=new MysqlConnectionPoolDataSource();
        mcon.setURL("jdbc:mysql://localhost:3306/jdbcpractical");
        mcon.setUser("root");
        mcon.setPassword("");
        Connection con=mcon.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from employee");
        System.out.println("ENO \t ENAME \t ESAL \t EADDR");
        System.out.println("...............................");
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+
                    rs.getString(4));
        }
        con.close();
    }
}
