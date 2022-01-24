import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;

public class _030_CLOBTypeRetrieve
{
    public static void main(String[] args) throws SQLException, IOException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","");
        PreparedStatement ps=con.prepareStatement("select * from cities");
        ResultSet rs=ps.executeQuery();
        int n=1;
        while(rs.next())
        {
            FileWriter fw=new FileWriter("file"+n+".txt");
            String name=rs.getString(1);
            System.out.println(name);
            Reader r=rs.getCharacterStream(2);
            /*
            char[] buf=new char[1024];
            while(r.read(buf)>0)
            {
                fw.write(buf);
            }
             */
            int i=r.read();
            while(i!=-1)
            {
                fw.write(i);
                i=r.read();
            }
            fw.flush();
            System.out.println("Successfully retrieved file: file"+n+".txt");
            n++;
        }
        con.close();
    }
}
