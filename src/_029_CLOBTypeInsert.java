import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _029_CLOBTypeInsert
{
    public static void main(String[] args) throws SQLException, FileNotFoundException
    {
        Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","");
        PreparedStatement ps=co.prepareStatement("insert into city values(?,?)");
        ps.setString(1,"Agra");
        File fi=new File("C:\\Users\\Etisha Jain\\Desktop\\Agra.jpg");
        FileReader fr=new FileReader(fi);
        ps.setCharacterStream(2,fr);
        System.out.println("Inserting image from :"+fi.getAbsolutePath());
        int updateCount =ps.executeUpdate();
        if(updateCount==1)
        {
            System.out.println("Record Inserted");
        }
        else
        {
            System.out.println("Record not Inserted");
        }
    }
}
