
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class _028_BLOBTypeRetrieve
{
    public static void main(String[] args) throws SQLException, IOException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","");
        PreparedStatement ps=con.prepareStatement("select * from persons;");
        ResultSet rs=ps.executeQuery();
        int n=1;
        while(rs.next())
        {
            FileOutputStream fos=new FileOutputStream("pic"+n+".jpg");
            String name=rs.getString(1);
            System.out.println(name);
            InputStream is=rs.getBinaryStream(2);
            byte[] buf=new byte[is.available()];
            while(is.read(buf)>0)
            {
                fos.write(buf);
            }
            fos.flush();
            System.out.println("image is visible in pic"+n+".jpg");
            n++;
        }
        con.close();
    }
}
