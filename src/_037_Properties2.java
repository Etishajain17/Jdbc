import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class _037_Properties2
{
    public static void main(String[] args) throws IOException, SQLException
    {
        Properties p=new Properties();
        FileInputStream fs=new FileInputStream("jdbcpractical.properties");
        p.load(fs);
        String url=p.getProperty("url2");
        MysqlConnectionPoolDataSource mcon=new MysqlConnectionPoolDataSource();
        mcon.setURL(url);
//      mcon.setURL("jdbc:mysql://localhost:3306/jdbcpractical?user=root&password=");
        Connection con=mcon.getConnection();
        Statement st=con.createStatement();
        ResultSet rs= st.executeQuery("select * from employee");
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
